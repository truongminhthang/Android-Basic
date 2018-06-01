package com.example.recyclerviewdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.widget.RecyclerView
import android.widget.Toast

class MainActivity : AppCompatActivity(), GreenAdapter.ListItemClickListener {

    val numberOfList = 100

    val adapter by lazy {
        GreenAdapter(applicationContext, numberOfList, this)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
        recycler_view.adapter =  adapter

    }

    override fun onListItemClick(clickedItemIndex: Int) {
        Toast.makeText(this,"Clicked at index: $clickedItemIndex", Toast.LENGTH_SHORT).show()
    }
}
