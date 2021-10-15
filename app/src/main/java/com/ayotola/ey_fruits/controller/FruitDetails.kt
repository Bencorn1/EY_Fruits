package com.ayotola.ey_fruits.controller

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.ayotola.ey_fruits.R
import com.ayotola.ey_fruits.databinding.ActivityFruitDetailsBinding
import com.bumptech.glide.Glide
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
    private lateinit var img3: String
    private lateinit var img4: ImageView

//    val storage = FirebaseStorage.getInstance()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFruitDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        img1 = binding.picture1
        img2 = binding.picture2
        img4 = binding.picture4

        // Gets the data from the passed bundle
        // Get the values of the keys that were sent on click from Recycler Adapter.

        val bundle = intent

        if (bundle != null) {
            name = bundle.extras?.getString("NAME").toString().toUpperCase(Locale.ROOT)
            nutrients = bundle.extras?.getString("NUTRIENTS").toString()
            origin = bundle.extras?.getString("ORIGIN").toString()
            price = bundle.extras?.getString("PRICE").toString()
            quantity = bundle.extras?.getString("QUANTITY").toString()
            description = bundle.extras?.getString("DESCRIPTION").toString()
            organic = bundle.extras?.getString("ORGANIC").toString()
            img3 = bundle.extras?.getString("IMAGE").toString()
        }

        val fruitName = binding.fruitName
        val fruitNutrient = binding.nutrientsList
        val fruitOrigin = binding.place
        val fPrice = binding.price
        val fruitQuantity = binding.quantity
        val describe = binding.descriptions
        val fOrganic = binding.organicity
        val fImg3 = binding.picture3

        fruitName.text = name
        fruitNutrient.text = "Nutrients: $nutrients"
        fruitOrigin.text = "Origin: $origin"
        fPrice.text = "Price: $price"
        fruitQuantity.text = "Quantity: $quantity"
        describe.text = "Description: $description"
        fOrganic.text = "Organic: $organic"
        fImg3.text = img3

        fetchData()
    }
    // Create a reference to a file from a Cloudinary Storage URI
    private fun fetchData() {
        Glide.with(baseContext).load("https://res.cloudinary.com/dftldy3sr/image/upload/v1634278403/unnamed_xgostd.png")
            .error(R.drawable.fruits)
            .into(img1)

        Glide.with(baseContext).load("https://res.cloudinary.com/dftldy3sr/image/upload/v1634278403/png-transparent-coconut-download-with-transparent-background-free-fruits_kavjye.png")
            .error(R.drawable.fruits)
            .into(img2)

        Glide.with(baseContext).load("https://res.cloudinary.com/dftldy3sr/image/upload/v1634278402/19-orange-png-image-download-thumb_vrdgp2.png")
            .error(R.drawable.fruits)
            .into(img4)
    }
}