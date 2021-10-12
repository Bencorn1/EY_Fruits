package com.ayotola.ey_fruits

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ayotola.ey_fruits.databinding.ActivityFruitDetailsBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset
import java.util.*
import kotlin.properties.Delegates

class Fruit_Details : AppCompatActivity() {
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
    private lateinit var bigImg: String

    private var fruitQuantity = ArrayList<String>()
    private var fruitDescription = ArrayList<String>()
    private var fruitOrganic = ArrayList<Boolean>()
    private var fruitPrices = ArrayList<String>()
    private var fruitsId by Delegates.notNull<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFruitDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nutrients = ""
        name = ""
        bigImg = ""
        origin = ""
        quantity = binding.quantity
        organic= binding.organicity
        description = binding.descriptions
        prices = binding.price
        img1 = binding.picture1
        img2 = binding.picture2
        img3 = binding.picture3
        img4 = binding.picture4
        var fruitImage = binding.fruitsImage
        val fruitName = binding.fruitNewName
        val fruitNutrient = binding.nutrientsList
        val fruitOrigin = binding.place

        // Get the values of the keys that were sent on click from Recycler Adapter.
        val bundle = intent

        if (bundle != null) {
            name = bundle.extras?.getString("NAME").toString().toUpperCase(Locale.ROOT)    // Get the value of the name and convert it to Uppercase.
            nutrients = bundle.extras?.getString("NUTRIENTS").toString()                               // Get the value of the URL and set as PokeyURL
            origin = bundle.extras?.getString("ORIGIN").toString()                                       // Get the value of ID
            fruitsId = bundle.extras?.getInt("ID") ?: 0
        }
//        lauchService(fruitsId)

        fruitName.text = name
        fruitNutrient.text = nutrients
        fruitOrigin.text = origin
//        Glide.with(this).load(pokemonUrl).into(pokemonImage)

        try {
            // since we have JSON array, so we are getting the array
            //here we are calling a function and that function is returning the JSON array
            val arr = JSONArray(loadJSONFromAsset())

            // implement for loop for getting data
            for (i in 0 until arr.length()) {

                // create a JSONObject for fetching data
                val details: JSONObject = arr.getJSONObject(i)

                // fetch email and name and store it in arraylist
                fruitQuantity.add(details.getString("quantity"))
                fruitOrganic.add(details.getBoolean("organic"))
                fruitDescription.add(details.getString("description"))
                fruitPrices.add(details.getString("price"))
            }
        } catch (e: JSONException) {
            //exception
            e.printStackTrace()
        }
        
    }

    private fun loadJSONFromAsset(): Any? {
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