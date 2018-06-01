package com.example.onetohundred

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val numberArray = Array(100, {i -> i + 1})
    private  val adapter by lazy {
        makeAdapter(numberArray)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView.adapter = adapter
    }

    private fun makeAdapter(list: Array<Int>): ArrayAdapter<Int> = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
}
