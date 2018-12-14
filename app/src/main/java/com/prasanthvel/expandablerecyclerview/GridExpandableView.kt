package com.prasanthvel.expandablerecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.prasanthvel.expandablerecyclerview.adapter.ExpandableRecyclerViewGridAdapter

class GridExpandableView : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_expandable_view)

        recyclerView = findViewById(R.id.recylcer2);

        val header: ArrayList<String> = ArrayList()

        header.add("Header 1")
        header.add("Header 2")
        header.add("Header 3")
        header.add("Header 4")
        header.add("Header 5")

        val body: ArrayList<String> = ArrayList()
        body.add("1")
        body.add("2")
        body.add("3")
        body.add("4")
        body.add("5")

        val adapter = ExpandableRecyclerViewGridAdapter(header, body, this)
        recyclerView.adapter = adapter
    }
}
