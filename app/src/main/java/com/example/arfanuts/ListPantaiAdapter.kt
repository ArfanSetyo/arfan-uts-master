package com.example.arfanuts

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListPantaiAdapter(private val listPantai: ArrayList<Pantai>) :
    RecyclerView.Adapter<ListPantaiAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_pantai, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, photo) = listPantai[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text=name
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listPantai[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Pantai)
    }

    override fun getItemCount(): Int = listPantai.size
}