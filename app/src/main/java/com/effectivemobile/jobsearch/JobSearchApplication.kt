package com.effectivemobile.jobsearch

import android.app.Application
import com.effectivemobile.jobsearch.data.AppContainer
import com.effectivemobile.jobsearch.data.DefaultAppContainer

class JobSearchApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}