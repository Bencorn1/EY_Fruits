package com.ayotola.ey_fruits

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(
    private var context: Context,
    private var fruitNames: ArrayList<String>,
    private var origin: ArrayList<String>,
    private var nutrients: ArrayList<String>,
    private var fruitImages: ArrayList<String>
) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

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
//        holder.fruitsPix.setImageResource(fruitImages)
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
        var currentId = 0

        // The onClickListener is set on the init here in the MyViewHolder inner class
        // This is used to launch a new activity which goes along with the necessary information.

        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, Fruit_Details::class.java).apply {
                    putExtra("NAME", fruitNames)
                    putExtra("NUTRIENTS", nutrients)
                    putExtra("ORIGIN", origin)
                    putExtra("ID", currentId)
                }
                itemView.context.startActivity(intent)
            }
        }

    }
}
