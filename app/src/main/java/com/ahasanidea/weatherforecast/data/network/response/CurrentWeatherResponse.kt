package com.ahasanidea.weatherforecast.data.network.response

import com.ahasanidea.weatherforecast.data.db.entity.CurrentWeatherEntry
import com.ahasanidea.weatherforecast.data.db.entity.Location
import com.google.gson.annotations.SerializedName

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    val location: Location
)