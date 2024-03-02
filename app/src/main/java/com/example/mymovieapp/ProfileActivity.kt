package com.example.mymovieapp

import android.annotation.SuppressLint
import android.content.Intent
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
import com.example.mymovieapp.databinding.ProfileActivityBinding
import com.example.mymovieapp.viewModel.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileActivity : AppCompatActivity() {

    lateinit var binding: ProfileActivityBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ProfileActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.bottomButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }


}