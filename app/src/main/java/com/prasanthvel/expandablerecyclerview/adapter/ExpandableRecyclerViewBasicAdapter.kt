package com.prasanthvel.expandablerecyclerview.adapter

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.prasanthvel.expandablerecyclerview.R

class ExpandableRecyclerViewBasicAdapter(
    val headerItems: ArrayList<String>,
    val bodyItems: ArrayList<String>,
    val mContext: Context
) :
    RecyclerView.Adapter<ExpandableRecyclerViewBasicAdapter.BasicViewHolder>() {

    var selected = -1
    var isExpanded = false

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BasicViewHolder {
        return BasicViewHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.item_basic_expandable_reclcyer_view,
                p0,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return headerItems.size
    }

    override fun onBindViewHolder(p0: BasicViewHolder, p1: Int) {
        p0.headerText.text = headerItems.get(p1)
        p0.bodyText.text = bodyItems.get(p1)

        if (selected == p1) {
            p0.expandedView.setVisibility(View.VISIBLE)
            openArrow(p0.arrowKey)
            // onMainCatClick(p1)
        } else {
            p0.expandedView.setVisibility(View.GONE)
            closeArrow(p0.arrowKey)
        }

        p0.arrowKey.setOnClickListener {
            if (selected == p1) {
                if (isExpanded) {
                    isExpanded = false
                    selected = -1
                    notifyDataSetChanged()
                } else {
                    selected = p1
                    isExpanded = true
                    notifyDataSetChanged()
                }
            } else {
                selected = p1
                isExpanded = true
                notifyDataSetChanged()
            }
        }

        p0.mainCardView.setOnClickListener {
            if (selected == p1) {
                if (isExpanded) {
                    // collapseView(holder.mExpandedView, holder.mArrow, position);
                    selected = -1
                    isExpanded = false
                    notifyDataSetChanged()
                } else {
                    selected = p1
                    // closeArrow(holder.mArrow);
                    notifyDataSetChanged()
                    isExpanded = true
                }
            } else {
                selected = p1
                isExpanded = true
                notifyDataSetChanged()

            }
        }
    }

    private fun closeArrow(arrowKey: ImageView) {
        arrowKey.animate().setDuration(150).rotation(0f)
    }

    private fun openArrow(arrowKey: ImageView) {
        arrowKey.animate().setDuration(150).rotation(180f)
    }


    class BasicViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val headerText = view.findViewById(R.id.basic_view_header_tv) as TextView
        val bodyText = view.findViewById(R.id.basic_view_body_tv) as TextView
        val arrowKey = view.findViewById(R.id.basic_view_down_arrow) as ImageView

        val mainCardView = view.findViewById(R.id.item_basic_layout) as CardView
        val expandedView = view.findViewById(R.id.item_basic_expand_view_body) as LinearLayout
    }
}