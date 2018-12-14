package com.prasanthvel.expandablerecyclerview.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.prasanthvel.expandablerecyclerview.R

class GridVviewAdapter(
    val grdiDataItems: ArrayList<String>,
    val mContext: Context
) :
    RecyclerView.Adapter<GridVviewAdapter.GridViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GridViewHolder {
        return GridViewHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.item_grid_single,
                p0,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return grdiDataItems.size
    }

    override fun onBindViewHolder(p0: GridViewHolder, p1: Int) {
        p0.gridItem.text = grdiDataItems.get(p1)
    }


    class GridViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val gridItem = view.findViewById(R.id.item_subcategory_grid_iv) as TextView
    }
}