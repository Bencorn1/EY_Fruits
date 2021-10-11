package com.ayotola.ey_fruits

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayotola.ey_fruits.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var rv: RecyclerView
    private lateinit var rvAdapter: MyAdapter

    // Creating ArrayList to store fruits names, origins and nutrients.
    private var fruitNames = ArrayList<String>()
    private var origin = ArrayList<String>()
    private var nutrients = ArrayList<String>()
    private var fruitImages = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getting the recyclerview by its id
        rv = binding.recyclerView

        // this creates a vertical layout Manager
        rv.layoutManager = LinearLayoutManager(applicationContext)

        try {
            // since we have JSON array, so we are getting the array
            //here we are calling a function and that function is returning the JSON array
            val arr = JSONArray(loadJSONFromAsset())

            // implement for loop for getting data
            for (i in 0 until arr.length()) {

                // create a JSONObject for fetching data
                val details: JSONObject = arr.getJSONObject(i)

                // fetch email and name and store it in arraylist
                fruitNames.add(details.getString("productName"))
                origin.add(details.getString("from"))
                nutrients.add(details.getString("nutrients"))

            }
        } catch (e: JSONException) {
            //exception
            e.printStackTrace()
        }

        //  call the constructor of MyAdapter to send the reference and data to Adapter
        rvAdapter = MyAdapter(this@MainActivity, fruitNames, origin, nutrients, fruitImages)

        // attach adapter to the recycler view
        rv.adapter = rvAdapter
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

//    private fun readArrayOfJsonObject(): Unit {
//
//        val bufferReader = application.assets.open("android_version.json").bufferedReader()
//        val json_string = bufferReader.use {
//            it.readText()
//        }
//        val jsonArray = JSONArray(json_string);
//
//        for (i in 0..jsonArray.length() - 1) {
//            val jsonObject: JSONObject = jsonArray.getJSONObject(i)
//
//            val name = jsonObject.getString("name")
//            val version = jsonObject.getString("version")
//
//            Log.d("readArrayOfJsonObject", "name: $name || version : $version  \n")
//        }
//    }

}