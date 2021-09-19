package com.example.converter.di

import android.app.Application
import android.content.Context
import com.example.converter.di.AppComponent
import com.example.converter.di.DaggerAppComponent

class MainApp : Application() {
    lateinit var appComponent: AppComponent
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(applicationContext)
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is MainApp -> appComponent
        else -> applicationContext.appComponent
    }