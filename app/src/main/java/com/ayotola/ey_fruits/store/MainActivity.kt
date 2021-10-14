package com.ayotola.ey_fruits.store

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayotola.ey_fruits.adapter.MyAdapter
import com.ayotola.ey_fruits.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rv: RecyclerView
    private lateinit var rvAdapter: MyAdapter

    private val data: MutableList<FruitItems> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            // since we have JSON array, so we are getting the array
            //here we are calling a function and that function is returning the JSON array
            val arr = JSONArray(loadJSONFromAsset())

            // implement for loop for getting data
            for (i in 0 until arr.length()) {

                // create a JSONObject for fetching data
                val details = arr.getJSONObject(i)
                val fruitData = FruitItems(
                        details.getString("image"),
                        details.getString("productName"),
                        details.getString("nutrients"),
                        details.getString("from"),
                        details.getString("price"),
                        details.getString("quantity"),
                        details.getString("description"),
                        details.getString("organic")
                )

                data.add(fruitData)

            }
//             getting the recyclerview by its id
            rv = binding.recyclerView

            // this creates a vertical layout Manager
            rv.layoutManager = LinearLayoutManager(applicationContext)

            //  call the constructor of MyAdapter to send the reference and data to Adapter
            rvAdapter = MyAdapter(this@MainActivity, data)

            // attach adapter to the recycler view
            rv.adapter = rvAdapter
        } catch (e: JSONException) {
            //exception
            e.printStackTrace()
        }
    }

    private fun loadJSONFromAsset(): String? {
        //function to load the JSON from the Asset and return the array
        var json: String? = null
        val charset: Charset = Charsets.UTF_8
        try {
            val `is` = assets.open("data.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }
}