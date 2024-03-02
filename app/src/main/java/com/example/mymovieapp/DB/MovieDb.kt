package com.example.mymovieapp.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mymovieapp.Model.Movie

@Database(
   entities = arrayOf(Movie::class),
   version = 1,
   exportSchema = false
)
@TypeConverters(DbConverter::class)
abstract class movieDb : RoomDatabase() {
   abstract fun movieDao(): MovieDao

}
