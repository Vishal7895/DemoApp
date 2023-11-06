package com.example.mymovieapp.Remote

import com.example.mymovieapp.Model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {


    @GET("movie")
    suspend fun getPopularMovies(@Query("api_key") apiKey:String):MovieResponse
}