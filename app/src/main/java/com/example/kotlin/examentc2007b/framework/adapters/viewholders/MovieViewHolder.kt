package com.example.kotlin.examentc2007b.framework.adapters.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examentc2007b.data.network.model.MovieBase
import com.example.kotlin.examentc2007b.databinding.ItemMovieBinding

class MovieViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MovieBase){
        binding.TVName.text = item.title
    }
}