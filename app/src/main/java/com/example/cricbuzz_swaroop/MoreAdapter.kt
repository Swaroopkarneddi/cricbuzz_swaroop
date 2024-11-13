package com.example.cricbuzz_swaroop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MoreAdapter(private val context: Context, private val moreItemList: List<MoreItem>) : BaseAdapter() {

    override fun getCount(): Int {
        return moreItemList.size
    }

    override fun getItem(position: Int): Any {
        return moreItemList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.list_item_more, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = convertView.tag as ViewHolder
        }

        val moreItem = moreItemList[position]
        holder.icon.setImageResource(moreItem.iconResId)
        holder.title.text = moreItem.title

        return view
    }

    private class ViewHolder(view: View) {
        val icon: ImageView = view.findViewById(R.id.icon)
        val title: TextView = view.findViewById(R.id.title)
    }
}
