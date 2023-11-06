package com.example.mymovieapp.viewModel

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovieapp.DTO.Resource
import com.example.mymovieapp.Model.MovieResponse
import com.example.mymovieapp.Repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    val movieRepository: MovieRepository
) :ViewModel() {
    val movieResponse = MutableLiveData<Resource<MovieResponse>>()


    @SuppressLint("SuspiciousIndentation")
    fun getPopularMovie(string: String) {
        viewModelScope.launch {
            movieResponse.value=Resource.loading()
            movieRepository.getPopularMovie(string).collect{response->
            response.data?.result?.let {
            movieResponse.value=response
                movieRepository.insertMovies(it)

            }?: kotlin.run {
                movieResponse.value=Resource.error("Error Occur",null,null)
            }
            }
        }
    }

}