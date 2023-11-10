package com.example.mymovieapp.Repository

import com.example.mymovieapp.DB.MovieDao
import android.content.Context
import com.example.mymovieapp.DB.movieDb
import com.example.mymovieapp.DTO.Resource
import com.example.mymovieapp.Model.Movie
import com.example.mymovieapp.Model.MovieResponse
import com.example.mymovieapp.Remote.ApiCall
import com.example.mymovieapp.Remote.RestApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApi: RestApi,
    private val context: Context,
    private val db: movieDb
):ApiCall {
     suspend fun getPopularMovie(string: String): Flow<Resource<MovieResponse> >{
     val movieResponse =    apiCall { (movieApi.getPopularMovies(string,"int",false)) }
         return flow {
             emit(movieResponse)
         }.flowOn(Dispatchers.IO)
     }

    suspend fun getPopularMovie(): Flow<List<Movie>?> {
        val movie = db.movieDao().getAllMovie()
        return flow {
            emit(movie)
        }.flowOn(Dispatchers.IO)
    }


    suspend fun insertMovies(movieList: List<Movie>) {
       // var db: MovieDao = MovieDatabase.getInstance(context)?.movieDao()!!


        db.movieDao().insert(movieList)
    }
}
