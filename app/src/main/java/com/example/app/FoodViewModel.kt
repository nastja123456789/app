package com.example.app

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.database.FoodDao
import com.example.app.models.Food

class FoodViewModel(private val foodDao: FoodDao) : ViewModel() {
    fun fullFood(): kotlinx.coroutines.flow.Flow<List<Food>> = foodDao.getAll()
}

class FoodViewModelFactory(
    private val foodDao: FoodDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FoodViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FoodViewModel(foodDao) as T
        }
        throw IllegalAccessException("")
    }
}

