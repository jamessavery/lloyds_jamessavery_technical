package com.example.features.favourites.data.repository

import com.example.core.data.database.dao.FavouriteItemDao
import com.example.core.data.model.FavouriteItem
import javax.inject.Inject

class FavouritesRepositoryImpl @Inject constructor(
    private val favouriteItemDao: FavouriteItemDao
) : FavouritesRepository {

    override suspend fun insertFavouriteItem(favouriteItem: FavouriteItem) {
        favouriteItemDao.insertFavoriteItem(favouriteItem)
    }

    override suspend fun isFavourite(uuid: String): Boolean {
        return favouriteItemDao.isFavourite(uuid)
    }

    override suspend fun getAllFavoriteItems(): List<FavouriteItem> {
        return favouriteItemDao.getAllFavoriteItems()
    }

    override suspend fun deleteFavoriteItem(uuid: String) {
        favouriteItemDao.deleteFavoriteItem(uuid)
    }

}

interface FavouritesRepository {
    suspend fun insertFavouriteItem(favouriteItem: FavouriteItem)
    suspend fun isFavourite(uuid: String): Boolean
    suspend fun getAllFavoriteItems(): List<FavouriteItem>
    suspend fun deleteFavoriteItem(uuid: String)
}