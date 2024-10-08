package com.example.core.domain.di

import android.content.Context
import androidx.room.Room
import com.example.core.Constants.Companion.PROCEDURES_DATABASE
import com.example.core.data.database.AppDatabase
import com.example.core.data.database.dao.FavouriteItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            PROCEDURES_DATABASE
        ).build()
    }

    @Singleton
    @Provides
    fun provideFavouriteItemDao(appDatabase: AppDatabase): FavouriteItemDao {
        return appDatabase.favoriteItemDao()
    }

}