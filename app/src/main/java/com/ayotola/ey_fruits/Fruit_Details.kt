package com.ayotola.ey_fruits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.ayotola.ey_fruits.databinding.ActivityFruitDetailsBinding
import com.bumptech.glide.Glide
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
        var fruitName = binding.fruitNewName
        var fruitNutrient = binding.nutrientsList
        var fruitOrigin = binding.place


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
    }

}