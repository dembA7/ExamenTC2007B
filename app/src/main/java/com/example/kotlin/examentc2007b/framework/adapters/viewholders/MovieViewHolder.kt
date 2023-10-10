package com.example.kotlin.examentc2007b.framework.adapters.viewholders

import android.content.Context
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.examentc2007b.domain.model.MovieBase
import com.example.kotlin.examentc2007b.databinding.ItemMovieBinding
import com.example.kotlin.examentc2007b.utils.Constants

class MovieViewHolder(private val binding: ItemMovieBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MovieBase, context: Context){
        binding.TVName.text = item.title
        binding.TVDescription.text = truncateOverview(item.overview)
        setImage(item, context, binding.IVPhoto, binding.root.context)
    }

    private fun setImage(movie: MovieBase, context: Context, imageView: ImageView, context1: Context){
        val urlImage = Constants.URL_IMAGEN + movie.poster_path
        Log.d("URL", urlImage)

        Glide.with(context1)
            .load(urlImage)
            .centerCrop()
            .fitCenter()
            .into(imageView)
    }

    private fun truncateOverview(overview: String): String {
        val maxLength = 120
        return if (overview.length > maxLength) {
            overview.substring(0, maxLength) + "..."
        } else {
            overview
        }
    }
}