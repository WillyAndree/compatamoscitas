package com.compartamos.citasapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.androidmaster.databinding.ItemSuperheroBinding

class CitaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(citaItemResponse: CitaItemResponse, onItemSelected: (String) -> Unit) {
        binding.tvSuperheroName.text = citaItemResponse.name
        binding.root.setOnClickListener { onItemSelected(citaItemResponse.Id) }
    }
}