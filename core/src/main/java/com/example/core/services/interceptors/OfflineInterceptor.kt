package com.example.core.services.interceptors

import android.content.Context
import com.example.core.domain.util.NetworkUtil
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class OfflineInterceptor(private val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!NetworkUtil.isNetworkAvailable(context)) {
            throw IOException("No internet connection")
        }
        return chain.proceed(chain.request())
    }
}