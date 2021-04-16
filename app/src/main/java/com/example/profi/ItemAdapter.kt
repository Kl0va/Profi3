package com.example.profi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter (
    private val context: Context,
    private val count : Int,
    private val listener: (CardView) -> Unit
        ) : RecyclerView.Adapter<ItemAdapter.ImageViewHolder>(){
    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val card = view.findViewById<CardView>(R.id.Card)
        fun bindView(listener: (CardView) -> Unit){
            listener(card)
        }
    }

    override fun getItemCount(): Int = count

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list,parent,false))

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) = holder.bindView(listener)
}

