package com.iavariav.myapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.iavariav.myapplication.R
import com.iavariav.myapplication.model.Item

class RecyclerViewAdapter(private val context: Context,
                          // context dia berlaku sebagai this (ini)
                          private val items: List<Item>
                          // variabel dari Item.kt bernama items
)
    :RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>()
// RecyclerView nya kita extend ke parrent(orang tua) nya RecyclerView yaitu RecyclerViewAdapter
{
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val name = view.findViewById<TextView>(R.id.tv_name_team)
        // tv_name_team diganti dengan variabel name, kemudian mencari view dari id
        // list_item.xml bernama tv_name_team
        val image = view.findViewById<ImageView>(R.id.iv_team);

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    )= ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent,
        false))
    // menghubungkan antara layout list_item.xml dengan kotlin

    override fun getItemCount(): Int {
        return items.size
        // array yg dimuat dari strings.xml
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        Glide.with(context).load(items.get(position).image).into(holder.image)
        holder.name.text = items.get(position).name

    }

}