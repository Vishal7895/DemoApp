package com.example.mymovieapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovieapp.DTO.Resource
import com.example.mymovieapp.Enums.Status
import com.example.mymovieapp.Model.Movie
import com.example.mymovieapp.Model.MovieResponse
import com.example.mymovieapp.Utils.CommonUtils
import com.example.mymovieapp.databinding.ActivityMainBinding
import com.example.mymovieapp.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MovieViewModel
    lateinit var binding:ActivityMainBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        viewModel=ViewModelProvider(this).get(MovieViewModel::class.java)


     //   viewModel.getPopularMovie(resources.getString(R.string.api_key))
        callApi()
        viewModel.movieResponse.observe(this){
            handleResponseResult(it)
        }


    }

    private fun callApi() {
        if (CommonUtils.isNetworkConnected(this)){
            viewModel.getPopularMovie(resources.getString(R.string.api_key))
        }else{
            viewModel.getPopularMovie()
        }

    }

    private fun handleResponseResult(resource: Resource<List<Movie>>) {
        when(resource.status){
            Status.SUCCESS->{
                val recyclerView=binding.recyclerview
                val adapter = resource.data?.let { MovieAdapter(this,it) }
                recyclerView.layoutManager = GridLayoutManager(this, 2) // 2 columns in the grid
                recyclerView.adapter = adapter
                Toast.makeText(this,resource.message,Toast.LENGTH_LONG).show()

                //pass data to recycler view
                //also disable loading dialog
            }
            Status.LOADING->{
                //show loading dialog
                Toast.makeText(this,"loading",Toast.LENGTH_LONG).show()

            }
            Status.ERROR->{
                Toast.makeText(this,"error",Toast.LENGTH_LONG).show()

            }
            else->{}
        }
    }


}