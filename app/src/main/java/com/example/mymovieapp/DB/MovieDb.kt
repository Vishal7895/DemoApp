package com.example.mymovieapp.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.mymovieapp.Model.Movie
@Database(entities = [Movie::class], version = 1, exportSchema = false)
@TypeConverters(DbConverter::class)
abstract class MovieDatabase : RoomDatabase() {

   abstract fun movieDao(): MovieDao

   companion object {
      private var INSTANCE: MovieDatabase? = null

      fun getInstance(context: Context): MovieDatabase? {
         if (INSTANCE == null) {
            synchronized(MovieDatabase::class) {
               INSTANCE = Room.databaseBuilder(
                  context.applicationContext,
                  MovieDatabase::class.java, "movie.db"
               ).allowMainThreadQueries()
                  .build()
            }
         }
         return INSTANCE
      }

      fun destroyInstance() {
         INSTANCE = null
      }
   }
}
