package com.example.kotlin.examentc2007b.framework.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.examentc2007b.domain.model.MovieBase
import com.example.kotlin.examentc2007b.databinding.ItemMovieBinding
import com.example.kotlin.examentc2007b.framework.adapters.viewholders.MovieViewHolder

class MovieAdapter(private val context: Context): RecyclerView.Adapter<MovieViewHolder>() {
    var data:ArrayList<MovieBase> = ArrayList()

    fun CommonsAdapter(data:ArrayList<MovieBase>, context: Context){
        this.data = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item, context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
