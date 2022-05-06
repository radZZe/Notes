package com.mimoza_app.notes.radzze.screens.main

import androidx.recyclerview.widget.DiffUtil
import com.mimoza_app.notes.radzze.models.AppNote

class AppNoteDiffCallback: DiffUtil.ItemCallback<AppNote>() {
    override fun areItemsTheSame(oldItem: AppNote, newItem: AppNote): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: AppNote, newItem: AppNote): Boolean {
        return oldItem == newItem
    }
}