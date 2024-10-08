package com.example.core.domain.di

import android.content.Context
import com.example.core.services.RetrofitHelper
import com.example.core.services.api.ProcedureApi
import com.example.core.services.api.ProcedureService
import com.example.core.services.interceptors.OfflineInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ServicesModule {

    @Singleton
    @Provides
    fun providesRetrofit(
        @ApplicationContext context: Context
    ): Retrofit {
        val builder = OkHttpClient.Builder()
        builder.addInterceptor(OfflineInterceptor(context))
        return RetrofitHelper.getInstance(builder)
    }

    @Provides
    @Singleton
    fun provideProcedureApi(retrofit: Retrofit): ProcedureService {
        return ProcedureApi(retrofit)
    }

}