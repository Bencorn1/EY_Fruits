package com.ayotola.ey_fruits

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ayotola.ey_fruits.databinding.ActivityFruitDetailsBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.util.*

class FruitDetails : AppCompatActivity() {

    private lateinit var binding: ActivityFruitDetailsBinding
    private lateinit var nutrients: String
    private lateinit var name: String
    private lateinit var quantity: TextView
    private lateinit var origin: String
    private lateinit var description: TextView
    private lateinit var organic: TextView
    private lateinit var prices: TextView
    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFruitDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        nutrients = binding.nutrientsList
//        origin = binding.place
        quantity = binding.quantity
        organic = binding.organicity
        description = binding.descriptions
        prices = binding.price
        img1 = binding.picture1
        img2 = binding.picture2
        img3 = binding.picture3
        img4 = binding.picture4

        // Gets the data from the passed bundle
        // Get the values of the keys that were sent on click from Recycler Adapter.

        val bundle = intent
        name = ""
        nutrients = ""
        origin = ""

        if (bundle != null) {
            name = bundle.extras?.getString("productName").toString().toUpperCase(Locale.ROOT)
            nutrients = bundle.extras?.getString("nutrients").toString()
            origin = bundle.extras?.getString("from").toString()
        }

        try {
            // since we have JSON array, so we are getting the array
            //here we are calling a function and that function is returning the JSON array
            val arr = JSONArray(getAssetJsonData())

            // implement for loop for getting data
            for (i in 0 until arr.length()) {

                // create a JSONObject for fetching data
                val details: JSONObject = arr.getJSONObject(i)

                // fetch information and store it in array list

                quantity.text = details.getString("quantity")
                description.text = details.getString("description")
                organic.text = details.getBoolean("organic").toString()
                prices.text = details.getString("price")
//                nutrients.text = details.getString("nutrients")
//                origin.text = details.getString("from")
            }
        } catch (e: JSONException) {
            //exception
            e.printStackTrace()
        }

    }

    private fun getAssetJsonData(): String? {
        val json: String
        try {
            val inputStream = assets.open("data.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.use { it.read(buffer) }
            json = String(buffer)
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        // print the data
        Log.i("data", json)
        return json
    }

}