package com.compose.weather.network.interceptors

import com.compose.weather.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class WeatherApiKeyInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val apiKey = BuildConfig.WEATHER_API_KEY
        val request = chain.request()
        val newRequest = request.newBuilder()
            .addHeader("X-Api-Key", apiKey)
            .build()
        return chain.proceed(newRequest)
    }
}