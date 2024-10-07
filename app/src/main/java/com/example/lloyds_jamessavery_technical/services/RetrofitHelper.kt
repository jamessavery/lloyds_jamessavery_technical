package com.example.lloyds_jamessavery_technical.services

import com.example.lloyds_jamessavery_technical.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private var logging: HttpLoggingInterceptor = HttpLoggingInterceptor()

    fun getInstance(builder: OkHttpClient.Builder): Retrofit {
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val client: OkHttpClient = builder.build()

        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
}