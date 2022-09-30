package com.example.app.models

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "food_database.db")
data class Food(
    @PrimaryKey var id: Int,
    @ColumnInfo(name="name_food") val name: String
)