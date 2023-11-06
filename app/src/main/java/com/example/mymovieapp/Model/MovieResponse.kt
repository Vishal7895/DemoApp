package com.example.mymovieapp.Model

import androidx.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class MovieResponse (

    @SerialName("page")

    var page: Int? = null,

    @SerialName("total_pages")

    var totalPages: Int? = null,

    @SerialName("total_results")
    val totalResults: Int? = null,

    @SerialName("results")
     val result:List<Movie>?=null

)

    /*@SerializedName("results")
    @Expose
    private val results: List<Movie>? = null*/

