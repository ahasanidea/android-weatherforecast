package com.ahasanidea.weatherforecast.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ahasanidea.weatherforecast.data.db.entity.CURRENT_WEATHER_ID
import com.ahasanidea.weatherforecast.data.db.entity.CurrentWeatherEntry
import com.ahasanidea.weatherforecast.data.db.unitlocalized.ImperialCurrentWeatherEntry
import com.ahasanidea.weatherforecast.data.db.unitlocalized.MetricCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    //Insert or update current data
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("SELECT * FROM current_weather where id=$CURRENT_WEATHER_ID")
    fun getWeatherMertic():LiveData<MetricCurrentWeatherEntry>

    @Query("SELECT * FROM current_weather where id=$CURRENT_WEATHER_ID")
    fun getWeatherImperial():LiveData<ImperialCurrentWeatherEntry>

}