package com.example.lloyds_jamessavery_technical.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.lloyds_jamessavery_technical.data.database.dao.FavouriteItemDao
import com.example.lloyds_jamessavery_technical.data.model.FavouriteItem

@Database(entities = [FavouriteItem::class], version = 1, exportSchema = false)
@TypeConverters(DefaultTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteItemDao(): FavouriteItemDao
}