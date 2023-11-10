package com.example.mymovieapp.Model


import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Entity(tableName = "movie")
@Keep
data class Movie(
    @PrimaryKey


    var id: Int? = null,


    var title: String? = null,


    var poster_path: String? = null,


    var backdrop_path: String? = null,


    var release_date: String? = null,


    var vote_average: Double? = null,


    var adult: Boolean? = null,


    var genre_ids: List<Int>? = null,


    var original_language: String? = null,


    var original_title: String? = null,


    var overview: String? = null,


    var popularity: Double? = null,


    var vote_count: Int? = null,


    var video: Boolean? = null,


    )

