package com.compartamos.citasapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aristidevs.androidmaster.R

class CitaAdapter(
    var citaList: List<CitaItemResponse> = emptyList(),
    private val onItemSelected: (String) -> Unit
) :
    RecyclerView.Adapter<CitaViewHolder>() {

    fun updateList(list: List<CitaItemResponse>) {
        citaList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitaViewHolder {
        return CitaViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_superhero, parent, false)
        )
    }

    override fun onBindViewHolder(viewholder: CitaViewHolder, position: Int) {
        viewholder.bind(citaList[position],onItemSelected)
    }

    override fun getItemCount() = citaList.size


}