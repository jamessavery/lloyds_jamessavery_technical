package com.example.core.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.core.data.model.FavouriteItem

@Dao
interface FavouriteItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavoriteItem(favouriteItem: FavouriteItem)

    @Query("SELECT EXISTS(SELECT 1 FROM favourites WHERE uuid = :uuid)")
    suspend fun isFavourite(uuid: String): Boolean

    @Query("SELECT * FROM favourites")
    suspend fun getAllFavoriteItems(): List<FavouriteItem>

    @Query("DELETE FROM favourites WHERE uuid = :uuid")
    suspend fun deleteFavoriteItem(uuid: String)

}