package com.example.features.favourites.domain.di

import com.example.features.favourites.data.repository.FavouritesRepository
import com.example.features.favourites.data.repository.FavouritesRepositoryImpl
import com.example.core.data.database.dao.FavouriteItemDao
import com.example.features.favourites.domain.usecase.FavouritesUsecase
import com.example.features.favourites.domain.usecase.FavouritesUsecaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class FavouritesModule {

    @Provides
    @Singleton
    fun provideFavouritesRepository(
        favouriteItemDao: FavouriteItemDao
    ): FavouritesRepository {
        return FavouritesRepositoryImpl(favouriteItemDao)
    }

    @Provides
    @Singleton
    fun provideFavouritesUsecase(
        favouriteRepository: FavouritesRepository
    ): FavouritesUsecase {
        return FavouritesUsecaseImpl(favouriteRepository)
    }

}