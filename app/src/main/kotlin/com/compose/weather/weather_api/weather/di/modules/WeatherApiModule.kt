package com.compose.weather.weather_api.weather.di.modules

import com.compose.weather.weather_api.weather.data.WeatherRepository
import com.compose.weather.weather_api.weather.data.WeatherRepositoryImpl
import com.compose.weather.weather_api.weather.data.remote.WeatherApiDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
interface WeatherApiModule {

    companion object {
        @Provides
        fun provideApiDataSource(
            retrofit: Retrofit
        ): WeatherApiDataSource = retrofit.create(WeatherApiDataSource::class.java)
    }

    @Binds
    fun bindWeatherRepository(impl: WeatherRepositoryImpl): WeatherRepository
}