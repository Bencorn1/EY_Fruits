package com.ayotola.ey_fruits.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayotola.ey_fruits.controller.FruitDetails
import com.ayotola.ey_fruits.model.FruitItems
import com.ayotola.ey_fruits.R

class MyAdapter(val context: Context,var data: List<FruitItems>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // Inflate the layout when viewholder created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruits_frame, parent, false)
        return MyHolder(view)
    }

    // Bind data
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        // Get current position of item in recyclerview to bind data and assign values from list
        val myHolder = holder as MyHolder
        val current: FruitItems = data[position]
        holder.setData(current, position)
    }

    // return total item from List
    override fun getItemCount(): Int {
        return data.size
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.fruit_name)
        private val fruitsOrigin: TextView = itemView.findViewById(R.id.fruit_location)
        private val fruitsPix: TextView = itemView.findViewById(R.id.fruit_img)
        private val fruitsNutrients: TextView = itemView.findViewById(R.id.fruit_nutrients)
        private lateinit var currentFruit: FruitItems
        var currentPos = 0

        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, FruitDetails::class.java).apply {
                    putExtra("NAME", currentFruit.name)
                    putExtra("NUTRIENTS", currentFruit.nutrients)
                    putExtra("ORIGIN", currentFruit.origin)
                    putExtra("PRICE", currentFruit.price)
                    putExtra("QUANTITY", currentFruit.quantity)
                    putExtra("ORGANIC", currentFruit.organic)
                    putExtra("DESCRIPTION", currentFruit.description)
                }
                itemView.context.startActivity(intent)
            }
        }

        fun setData(fruitey: FruitItems, position: Int) {
           name.text = fruitey.name
            fruitsOrigin.text = fruitey.origin
            fruitsPix.text = fruitey.image
            fruitsNutrients.text = fruitey.nutrients

            this.currentFruit = fruitey
            this.currentPos = position

        }

    }

}
