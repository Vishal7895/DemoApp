package com.example.mymovieapp.Remote

import com.example.mymovieapp.Model.Movie
import com.example.mymovieapp.Model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RestApi {


    @GET("search/movie")
    suspend fun getPopularMovies(@Query("api_key") apiKey:String,@Query("query") query: String,@Query("include_adult") include_adult:Boolean?=false):MovieResponse
}