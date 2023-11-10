package com.example.mymovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mymovieapp.Enums.MovieEnums
import com.example.mymovieapp.databinding.ActivityMainBinding
import com.example.mymovieapp.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {
    lateinit var movieDetailBinding: ActivityMovieDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieDetailBinding = ActivityMovieDetailBinding.inflate(layoutInflater)
        val view = movieDetailBinding.root
        setContentView(view)
        movieDetailBinding.back.setOnClickListener {
            finish()
        }
        val overView = intent?.getStringExtra(MovieEnums.OVERVIEW.name)
        overView?.let {
            movieDetailBinding.tvOverview.text=overView
        }?: kotlin.run {
            movieDetailBinding.tvOverview.text="No Overview"
        }

       // Toast.makeText(this,receiveData.toString(),Toast.LENGTH_SHORT).show()
    }
}