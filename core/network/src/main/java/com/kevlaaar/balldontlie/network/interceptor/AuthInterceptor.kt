package com.kevlaaar.balldontlie.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("Authorization", API_KEY)
            .build()
        return chain.proceed(request)
    }

    companion object {
        // TODO: Get API key from balldontlie website
        // TODO: Move to BuildConfig or local.properties for security
        private const val API_KEY = "blank_for_now"
    }
}