package com.example.moviebookingapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titles = arrayOf("THE BATMAN", "SONIC THE HEDGEHOG", "UNCHARTED", "PHANTON OF THE OPEN", "THE SPIDER-MAN: NO WAY HOME", "DEATH ON THE NILE", "THE ROYAL OPERA: LA TRAVIATA", "THE DUKE")
    private var details = arrayOf("GET ALL TIMES & TICKETS", "GET ALL TIMES & TICKETS", "GET ALL TIMES & TICKETS", "GET ALL TIMES & TICKETS", "GET ALL TIMES & TICKETS",
        "GET ALL TIMES & TICKETS", "GET ALL TIMES & TICKETS", "GET ALL TIMES & TICKETS")
    private var images = intArrayOf(R.drawable.batman, R.drawable.sonic, R.drawable.uncharted, R.drawable.the_phanton_of_the_open_poster,
        R.drawable.spiderman,R.drawable.death_on_the_nile,R.drawable.traviata,R.drawable.the_duke_poster)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener{
                val position: Int = adapterPosition

                Toast.makeText(itemView.context, "you clicked on ${titles[position]}", Toast.LENGTH_LONG).show()
            }
        }
    }
}