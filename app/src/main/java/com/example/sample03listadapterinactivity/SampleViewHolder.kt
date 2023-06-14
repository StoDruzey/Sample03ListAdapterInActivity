package com.example.sample03listadapterinactivity

import androidx.recyclerview.widget.RecyclerView
import com.example.sample03listadapterinactivity.databinding.ItemFragmentBinding

class SampleViewHolder(
    private val binding: ItemFragmentBinding,
    private val onItemClicked: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(itemString: String) {
        binding.item.text = itemString
        binding.root.setOnClickListener {
            onItemClicked(itemString)
        }
    }
}