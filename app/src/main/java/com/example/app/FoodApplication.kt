package com.example.app

import android.app.Application
import com.example.app.database.AppDatabase

class FoodApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}