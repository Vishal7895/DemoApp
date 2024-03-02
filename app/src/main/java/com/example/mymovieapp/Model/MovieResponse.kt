package com.example.mymovieapp.Model

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


data class MovieResponse(


    var page: Int? = null,


    val results: List<Movie>? = null,


    var total_pages: Int? = null,


    val total_results: Int? = null,


    )


/*@SerializedName("results")
@Expose
private val results: List<Movie>? = null*/

