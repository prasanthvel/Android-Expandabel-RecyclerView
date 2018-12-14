package com.prasanthvel.expandablerecyclerview.adapter


import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import com.prasanthvel.expandablerecyclerview.R

class ExpandableRecyclerViewGridAdapter(
    val headerItems: ArrayList<String>,
    val bodyItems: ArrayList<String>,
    val mContext: Context
) :
    RecyclerView.Adapter<ExpandableRecyclerViewGridAdapter.GridViewHolder>() {

    var selected = -1
    var isExpanded = false
    private lateinit var gridRcycleAdapter: GridVviewAdapter

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GridViewHolder {
        return GridViewHolder(
            LayoutInflater.from(mContext).inflate(
                R.layout.item_grid_expandable_view,
                p0,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return headerItems.size
    }

    override fun onBindViewHolder(p0: GridViewHolder, p1: Int) {
        p0.headerText.text = headerItems.get(p1)

        gridRcycleAdapter = GridVviewAdapter(bodyItems, mContext)
        p0.gridRecyclerView.adapter = gridRcycleAdapter

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


    class GridViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val headerText = view.findViewById(R.id.item_grid_expand_header_tv) as TextView
        //  val bodyText = view.findViewById(R.id.basic_view_body_tv) as TextView
        val arrowKey = view.findViewById(R.id.item_grid_expand_arrow) as ImageView

        val mainCardView = view.findViewById(R.id.item_grid_expand_new) as RelativeLayout
        val expandedView = view.findViewById(R.id.item_grid_expandview_rl) as RelativeLayout
        val gridRecyclerView = view.findViewById(R.id.item_cat_new_expnd_gridview) as RecyclerView

    }
}