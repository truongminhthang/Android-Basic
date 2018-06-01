/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.recyclerviewdemo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.green_cell.view.*

/**
 * We couldn't come up with a good name for this class. Then, we realized
 * that this lesson is about RecyclerView.
 *
 * RecyclerView... Recycling... Saving the planet? Being green? Anyone?
 * #crickets
 *
 * Avoid unnecessary garbage collection by using RecyclerView and ViewHolders.
 *
 * If you don't like our puns, we named this Adapter GreenAdapter because its
 * contents are green.
 */
class GreenAdapter (val context: Context, val numberOfItems : Int, val listItemClickListener: ListItemClickListener): RecyclerView.Adapter<GreenAdapter.GreenViewHolder>() {

    interface ListItemClickListener {
        fun onListItemClick(clickedItemIndex: Int)
    }

    private val tag = GreenAdapter::class.java.simpleName
    private var viewHolderCount = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GreenViewHolder {
        val view = LayoutInflater.from(context)
        val cell = GreenViewHolder(view.inflate(R.layout.green_cell, parent,false))
        cell.itemView.tv_view_holder_instance.text = "ViewHolder index: $viewHolderCount"
        cell.itemView.setBackgroundColor(ColorUtils.getViewHolderBackgroundColorFromInstance(context, viewHolderCount))
        viewHolderCount += 1
        Log.d(tag, "onCreateViewHolder: number of ViewHolders created: $viewHolderCount")
        return cell
    }

    override fun getItemCount(): Int {
        return numberOfItems
    }

    override fun onBindViewHolder(holder: GreenViewHolder, position: Int) {
        holder.bindData(position)
        holder.itemView.setOnClickListener {
            listItemClickListener.onListItemClick(position)
        }
    }

    class GreenViewHolder(item: View): RecyclerView.ViewHolder(item) {
        fun bindData(number: Int) {
            itemView.tv_item_number.text = number.toString()
        }

    }
}
