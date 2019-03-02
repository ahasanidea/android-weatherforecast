package com.ahasanidea.weatherforecast.ui.weather.current

import androidx.lifecycle.ViewModel;
import com.ahasanidea.weatherforecast.data.provider.UnitProvider
import com.ahasanidea.weatherforecast.data.repository.ForecastRepository
import com.ahasanidea.weatherforecast.internal.UnitSystem
import com.ahasanidea.weatherforecast.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forcastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    private val unitSystem = unitProvider.getUnitSystem()//UnitSystem.METRIC //get from setting later
    val isMetric: Boolean
        get() = unitSystem==UnitSystem.METRIC
    val weather by lazyDeferred {
        forcastRepository.getCurrentWeather(isMetric)
    }


}
