package com.ayotola.ey_fruits

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private var context: Context,
                private var fruitNames: ArrayList<String>,
                private var origin: ArrayList<String>,
                private var nutrients: ArrayList<String>,
                private var fruitImages:ArrayList<Int>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        // inflate the Layout with the UI that we have created for the RecyclerView
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruits_frame, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
//         set the data in items of the RecyclerView
        holder.names.text = fruitNames[position]
        holder.fruitsOrigin.text = origin[position]
        holder.fruitsNutrients.text = nutrients[position]
//        holder.fruitsPix.setImageResource(Image)
    }

    override fun getItemCount(): Int {
        //return the item count
        return fruitNames.size
    }

    inner class MyViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView) {
        //connecting views with the text and image views
        val names: TextView = itemView.findViewById(R.id.fruit_name)
        val fruitsOrigin: TextView = itemView.findViewById(R.id.fruit_location)
        val fruitsPix: ImageView = itemView.findViewById(R.id.fruit_img)
        val fruitsImage: ImageView = itemView.findViewById(R.id.bg_img)
        val fruitsNutrients: TextView = itemView.findViewById(R.id.fruit_nutrients)
    }
}