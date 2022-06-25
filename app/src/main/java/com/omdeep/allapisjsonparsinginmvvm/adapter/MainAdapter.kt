package com.omdeep.allapisjsonparsinginmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.omdeep.allapisjsonparsinginmvvm.R
import com.omdeep.allapisjsonparsinginmvvm.databinding.LayoutRvItemBinding
import com.omdeep.allapisjsonparsinginmvvm.model.Movie

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var movies = mutableListOf<Movie>()

    fun setMoviesList(movie: List<Movie>) {
        this.movies = movie.toMutableList()
        notifyDataSetChanged()
    }
    class MainViewHolder(val binding : LayoutRvItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = LayoutRvItemBinding.inflate(inflator, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.movieTitle.text = movie.title
        holder.binding.imdbId.text = movie.imdbID
        holder.binding.year.text = movie.year

        Glide.with(holder.itemView.context).load(movie.poster).placeholder(R.drawable.placeholder)
            .into(holder.binding.moviePoster)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}