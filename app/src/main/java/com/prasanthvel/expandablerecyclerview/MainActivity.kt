package com.prasanthvel.expandablerecyclerview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        menu1.setOnClickListener {
            val intent = Intent(this, BasicExpandableView::class.java)
            startActivity(intent)
        }
        menu2.setOnClickListener {
            val intent = Intent(this, GridExpandableView::class.java)
            startActivity(intent)
        }
    }
}
