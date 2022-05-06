package com.mimoza_app.notes.radzze.screens.main

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mimoza_app.notes.radzze.R

class MainHolder(view:View):RecyclerView.ViewHolder(view) {
    val textNote:TextView = view.findViewById(R.id.item_note_text)
    val nameNote:TextView = view.findViewById(R.id.note_item_name)
}