package com.example.calling.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calling.R
import com.example.calling.model.Contact
import java.util.*

class ContactsAdapter(private val contactArrayList: ArrayList<Contact>) :
    RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentContact: Contact = contactArrayList[position]
        holder.name.setText(currentContact.name)
        holder.mobile.setText(currentContact.mobile)
    }

    override fun getItemCount(): Int {
        return contactArrayList.size
    }

    inner class ViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.textView)
        var mobile: TextView = itemView.findViewById(R.id.textView_number)
        var icon: ImageView = itemView.findViewById(R.id.imageView_call)

        init {
            icon.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun onItemSetOnClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

}