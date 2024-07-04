package com.example.androidbasicapp.ui

import android.app.Application
import android.content.Context
import timber.log.Timber

class ApplicationClass : Application() {

    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()

        context = this

         Timber.plant(Timber.DebugTree())
    }
}