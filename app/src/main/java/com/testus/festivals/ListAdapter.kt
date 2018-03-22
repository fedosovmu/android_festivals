package com.testus.festivals

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.list_layout.view.*
import java.util.*

class ListAdapter(var c: Context, var lists: ArrayList<FestivalInfo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder? {
        var v = LayoutInflater.from(c).inflate(R.layout.list_layout, parent, false)
        return Item(v)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as Item).bindData(lists[position], c)
    }

    class Item(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(item: FestivalInfo, c: Context) {
            itemView.my_button.text = item.name

            itemView.my_button.setOnClickListener {
                //itemView.my_button.text = item.description
                val intent = Intent(c, FestivalActivity::class.java)
                intent.putExtra("ITEM_DESCRIPTION", item.description)
                startActivity(c, intent, null)
            }
        }
    }
}