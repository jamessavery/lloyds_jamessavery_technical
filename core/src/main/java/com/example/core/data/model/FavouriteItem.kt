package com.example.core.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourites")
data class FavouriteItem(
    @PrimaryKey val uuid: String,
    val procedure: Procedure
)