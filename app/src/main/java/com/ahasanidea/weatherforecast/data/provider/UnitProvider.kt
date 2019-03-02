package com.ahasanidea.weatherforecast.data.provider

import com.ahasanidea.weatherforecast.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem():UnitSystem
}