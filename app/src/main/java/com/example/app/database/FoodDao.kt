package com.example.app.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.app.models.Food
import java.util.concurrent.Flow

@Dao
interface FoodDao {
    @Query("SELECT * FROM food_database")
    fun getAll(): kotlinx.coroutines.flow.Flow<List<Food>>
}