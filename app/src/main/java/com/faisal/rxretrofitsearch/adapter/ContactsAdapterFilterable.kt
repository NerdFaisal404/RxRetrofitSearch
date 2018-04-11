package com.faisal.rxretrofitsearch.adapter

import com.faisal.rxretrofitsearch.model.Contact
import android.R.attr.name
import android.content.Context
import android.widget.TextView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.faisal.rxretrofitsearch.R


class ContactsAdapterFilterable (context: Context, contactList: List<Contact>, listener: ContactsAdapterListener){
    private val context: Context? = null
    private val contactList: List<Contact>? = null
    private val contactListFiltered: List<Contact>? = null
    private val listener: ContactsAdapterListener? = null

    init {

    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView
        var phone: TextView
        var thumbnail: ImageView

        init {
            name = view.findViewById(R.id.name)
            phone = view.findViewById(R.id.phone)
            thumbnail = view.findViewById(R.id.thumbnail)

            view.setOnClickListener(object : View.OnClickListener {
                override fun onClick(view: View) {
                    // send selected contact in callback
                    listener!!.onContactSelected(contactListFiltered!!.get(adapterPosition))
                }
            })
        }
    }


    interface ContactsAdapterListener {
        fun onContactSelected(contact: Contact)
    }
}