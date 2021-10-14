package com.ayotola.ey_fruits

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.ayotola.ey_fruits.databinding.ActivityFruitDetailsBinding
import java.util.*

class FruitDetails : AppCompatActivity() {

    private lateinit var binding: ActivityFruitDetailsBinding
    private lateinit var nutrients: String
    private lateinit var name: String
    private lateinit var quantity: String
    private lateinit var origin: String
    private lateinit var description: String
    private lateinit var organic: String
    private lateinit var price: String
    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFruitDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
        quantity = ""
        organic = ""
        description = ""
        price = ""

        if (bundle != null) {
            name = bundle.extras?.getString("NAME").toString().toUpperCase(Locale.ROOT)
            nutrients = bundle.extras?.getString("NUTRIENTS").toString()
            origin = bundle.extras?.getString("ORIGIN").toString()
            price = bundle.extras?.getString("PRICE").toString()
            quantity = bundle.extras?.getString("QUANTITY").toString()
            description = bundle.extras?.getString("DESCRIPTION").toString()
            organic = bundle.extras?.getString("ORGANIC").toString()
        }

        val fruitName = binding.fruitName
        val fruitNutrient = binding.nutrientsList
        val fruitOrigin = binding.place
        val fPrice = binding.price
        val fruitQuantity = binding.quantity
        val describe = binding.descriptions
        val fOrganic = binding.organicity

        fruitName.text = name
        fruitNutrient.text = "Nutrients: $nutrients"
        fruitOrigin.text = "Origin: $origin"
        fPrice.text = "Price: $price"
        fruitQuantity.text = "Quantity: $quantity"
        describe.text = "Description: $description"
        fOrganic.text = "Organic: $organic"

    }

}