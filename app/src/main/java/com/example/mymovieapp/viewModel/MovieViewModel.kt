package com.example.mymovieapp.viewModel

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mymovieapp.DTO.Resource
import com.example.mymovieapp.Model.Movie
import com.example.mymovieapp.Model.MovieResponse
import com.example.mymovieapp.Repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    val movieRepository: MovieRepository
) : ViewModel() {
    val movieResponse = MutableLiveData<Resource<List<Movie>>>()
    fun getPopularMovie(string: String) {
        viewModelScope.launch {
            movieResponse.value = Resource.loading()
            movieRepository.getPopularMovie(string).collect { response ->
                response.data?.let {
                    movieResponse.value = Resource.success(response.data.results, "fromRemote")
                    it.results?.let { it1 -> movieRepository.insertMovies(it1) }

                } ?: kotlin.run {
                    movieResponse.value = Resource.error("Error Occur", null, null)
                }
            }
        }
    }

    fun getPopularMovie() {
        viewModelScope.launch {
            movieResponse.value = Resource.loading()
            //getting data from roomDB
            movieRepository.getPopularMovie().collect {
                it?.let {
                    movieResponse.value = Resource.success(it, "fromDb")

                } ?: kotlin.run {
                    movieResponse.value = Resource.error("Connect to Internet", null, null)
                }
            }
        }
    }

}