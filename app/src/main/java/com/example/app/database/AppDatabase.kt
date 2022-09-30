package com.example.app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.app.models.Food

@Database(entities = [Food::class], version = 1)
abstract class AppDatabase() : RoomDatabase(){
    abstract fun foodDao(): FoodDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase ?=null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "app_database")
                    .createFromAsset("assets/food_database.db")
                    .build()
                INSTANCE = instance

                instance
            }
        }
    }
}