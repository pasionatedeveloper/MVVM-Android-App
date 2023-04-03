package com.ajssoftwares.mvvmapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(var context : Context, var list : ArrayList<User>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val textViewName = itemView.findViewById<TextView>(R.id.textViewName)
        val textViewEmail = itemView.findViewById<TextView>(R.id.textViewEmail)
        val textViewContact = itemView.findViewById<TextView>(R.id.textViewContact)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sample_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewName.text= list[position].userName
        holder.textViewEmail.text= list[position].email
        holder.textViewContact.text = list[position].contactNumber
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
