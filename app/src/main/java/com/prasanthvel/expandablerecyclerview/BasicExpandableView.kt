package com.prasanthvel.expandablerecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.prasanthvel.expandablerecyclerview.adapter.ExpandableRecyclerViewBasicAdapter
import java.lang.Exception
import java.lang.IndexOutOfBoundsException

class BasicExpandableView : AppCompatActivity() {

    private lateinit var mBasicRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_expandable_view)

        mBasicRecyclerView = findViewById(R.id.main_recycler)

        val header: ArrayList<String> = ArrayList()

        header.add("Header 1")
        header.add("Header 2")
        header.add("Header 3")
        header.add("Header 4")
        header.add("Header 5")

        val body: ArrayList<String> = ArrayList()
        body.add("Content 1")
        body.add("Content 2")
        body.add("Content 3")
        body.add("Content 4")
        body.add("Content 5")

        try {
            if (validateList(header, body)) {
                val adapter = ExpandableRecyclerViewBasicAdapter(header, body, this)
                mBasicRecyclerView.adapter = adapter
            }
        } catch (e: Exception) {
            println(e.toString())
        }

    }

    private fun validateList(header: ArrayList<String>, body: ArrayList<String>): Boolean {
        if (header.size == body.size)
            return true
        else
            return throw IndexOutOfBoundsException("Both list must have same length")
    }
}
