package com.example.mymovieapp.DB

import androidx.room.TypeConverter
import com.example.mymovieapp.Model.Movie
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DbConverter {

    @TypeConverter
    fun fromMovieList(list: List<Movie?>?): String? {
        val type = object : TypeToken<List<Movie>>() {}.type
        return Gson().toJson(list, type)
    }

    @TypeConverter
    fun toMovieList(list: String?): List<Movie>? {
        val type = object : TypeToken<List<Movie>>() {}.type
        return Gson().fromJson<List<Movie>>(list, type)
    }

    @TypeConverter
    fun fromList(list: List<Int>?): String? {
        return list?.toString()
    }

    @TypeConverter
    fun toList(data: String?): List<Int>? {
        return data?.map { it.code }
    }
}