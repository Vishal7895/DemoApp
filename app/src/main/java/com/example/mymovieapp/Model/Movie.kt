package com.example.mymovieapp.Model


import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Entity(tableName = "movie")
@Keep
@Serializable
data class Movie  (
    @PrimaryKey
    @SerialName("id")
   
    var id: Int? = null,

    
    @SerialName("title")
   
    var title: String? = null,


    
    @SerialName("poster_path")
   
    var posterPath: String? = null,


    
    @SerialName("release_date")
   
    var releaseDate: String? = null,


    
    @SerialName("overview")
   
    var overview: String? = null,


    
    @SerialName("vote_average")
   
    var voteAverage: Double? = null



)