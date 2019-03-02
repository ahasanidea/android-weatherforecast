package com.ahasanidea.weatherforecast

import android.app.Application
import android.preference.PreferenceManager
import com.ahasanidea.weatherforecast.data.db.ForecastDatabase
import com.ahasanidea.weatherforecast.data.network.*
import com.ahasanidea.weatherforecast.data.provider.UnitProvider
import com.ahasanidea.weatherforecast.data.provider.UnitProviderImpl
import com.ahasanidea.weatherforecast.data.repository.ForecastRepository
import com.ahasanidea.weatherforecast.data.repository.ForecastRepositoryImpl
import com.ahasanidea.weatherforecast.ui.weather.current.CurrentWeatherViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ForcastApplication: Application(),KodeinAware {
    override val kodein= Kodein.lazy {
       import(androidXModule(this@ForcastApplication))
        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao()}
        bind<ConnectivityInterceptor>() with singleton { ConnectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(),instance()) }
        bind<UnitProvider>() with singleton { UnitProviderImpl(instance()) }
        bind() from provider { CurrentWeatherViewModelFactory(instance(),instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
    }
}