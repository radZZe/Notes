package com.mimoza_app.notes.radzze.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mimoza_app.notes.radzze.R
import com.mimoza_app.notes.radzze.models.AppNote

class MainAdapter: ListAdapter<AppNote, MainHolder>(AppNoteDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val layout = R.layout.note_item
        val view = LayoutInflater.from(parent.context).inflate(layout,parent,false)
        return MainHolder(view)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.nameNote.text = getItem(position).name
        holder.textNote.text = getItem(position).text
    }

    override fun onViewAttachedToWindow(holder: MainHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener{
            MainFragment.onClickNote(getItem(holder.adapterPosition))
        }
    }


    override fun onViewDetachedFromWindow(holder: MainHolder) {
        holder.itemView.setOnClickListener(null)
    }

}