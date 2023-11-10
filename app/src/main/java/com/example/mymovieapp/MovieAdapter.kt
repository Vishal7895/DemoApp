package com.example.mymovieapp

import android.content.Context
import android.content.Intent
import com.example.mymovieapp.Model.Movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovieapp.Enums.MovieEnums
import com.example.mymovieapp.databinding.GridItemBinding

class MovieAdapter(private val context: Context,private val items: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {


    class ViewHolder(private val binding: GridItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item:Movie){
            binding.originalTitle.text=item.original_title
            binding.id.text=item.id.toString()
            binding.title.text=item.title
            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w500"+item.poster_path)
                .into(binding.imageView)

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding=GridItemBinding.inflate(inflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            val intent = Intent(context,MovieDetailActivity::class.java)
            intent.putExtra(MovieEnums.OVERVIEW.name,item.overview)

            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }
}
