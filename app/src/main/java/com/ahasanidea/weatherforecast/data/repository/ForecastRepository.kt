package com.ahasanidea.weatherforecast.data.repository

import androidx.lifecycle.LiveData
import com.ahasanidea.weatherforecast.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric:Boolean):LiveData<out UnitSpecificCurrentWeatherEntry>
}