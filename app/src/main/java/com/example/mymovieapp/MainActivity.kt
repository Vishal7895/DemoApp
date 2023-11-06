package com.example.mymovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.mymovieapp.DTO.Resource
import com.example.mymovieapp.Enums.Status
import com.example.mymovieapp.Model.MovieResponse
import com.example.mymovieapp.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var textView:TextView
    lateinit var viewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         viewModel=ViewModelProvider(this).get(MovieViewModel::class.java)
        textView=findViewById(R.id.text)
        viewModel.getPopularMovie(resources.getString(R.string.api_key))
        viewModel.movieResponse.observe(this){
            handleResponseResult(it)
        }

    }

    private fun handleResponseResult(resource: Resource<MovieResponse>) {
        when(resource.status){
            Status.SUCCESS->{
              //pass data to recycler view
                //also disable loading dialog
                Toast.makeText(this,"success",Toast.LENGTH_LONG).show()
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