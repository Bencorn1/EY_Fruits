package com.ayotola.ey_fruits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.ayotola.ey_fruits.databinding.FragmentDetailsLayBinding
import java.util.*

@Suppress("UNREACHABLE_CODE")
class DetailsLay : DialogFragment() {

    private lateinit var binding: FragmentDetailsLayBinding
    private lateinit var nutrients: TextView
    private lateinit var name: TextView
    private lateinit var quantity: TextView
    private lateinit var origin: TextView
    private lateinit var description: TextView
    private lateinit var organic: TextView
    private lateinit var prices: TextView
    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView
    private lateinit var bigImg: ImageView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailsLayBinding.inflate(inflater, container, false)
        return binding.root

        nutrients = binding.nutrientsList
        name = binding.fruitNewName
        bigImg = binding.fruitsImage
        origin = binding.place
        quantity = binding.quantity
        organic= binding.organicity
        description = binding.descriptions
        prices = binding.price
        img1 = binding.picture1
        img2 = binding.picture2
        img3 = binding.picture3
        img4 = binding.picture4

        // Gets the data from the passed bundle
        val bundle = arguments
        val fName = bundle?.getString("NAME").toString()
        val fNutrients = bundle?.getString("NUTRIENTS").toString()
        val fOrigin = bundle?.getString("ORIGIN").toString()

            // Sets the derived data (type String) in the TextView
        name.text = fName
        nutrients.text = fNutrients
        origin.text = fOrigin
        }
    }