package com.example.quakereport

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_quake.*
import kotlin.properties.Delegates

class QuakeActivity : AppCompatActivity(), QuakeAdapter.QuakeClickListener {

    val numberOfCell = 100

    var quakes : List<Quake> = emptyList()

    var adapter: QuakeAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quake)
        quakes = QueryUtils.extractEarthquakes()
        adapter = QuakeAdapter(this, quakes , this)

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(false)
        recycler_view.adapter = adapter
    }

    override fun onClickedQuakeAt(index: Int) {
        Toast.makeText(this,"Clicked at index: $index", Toast.LENGTH_SHORT).show()
    }

}
