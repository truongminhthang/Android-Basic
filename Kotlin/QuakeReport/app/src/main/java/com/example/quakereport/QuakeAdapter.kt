package com.example.quakereport

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.quake_cell.view.*

class QuakeAdapter(val context: Context, var earthQuakes: List<Quake>, var itemClickListener: QuakeClickListener): RecyclerView.Adapter<QuakeAdapter.ViewHoler>() {

    interface QuakeClickListener {
        fun onClickedQuakeAt(index: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler {
        val view = LayoutInflater.from(context)
        val viewHoler = ViewHoler(view.inflate(R.layout.quake_cell, parent,false))
        return viewHoler
    }

    override fun getItemCount(): Int {
        return earthQuakes.count()
    }

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        holder.bindingData(earthQuakes[position])
        holder.itemView.setOnClickListener {
            itemClickListener.onClickedQuakeAt(position)
        }
    }

    class ViewHoler(item: View): RecyclerView.ViewHolder(item) {
        fun bindingData(quake: Quake) {
            itemView.magnitude.text = quake.magnitude
            itemView.location.text = quake.location
            itemView.date.text = quake.date
        }
    }


}