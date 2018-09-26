package com.simx.mvvm

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

class App : Application() {
    lateinit var context : Context

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    fun getAppContext(): Context {
        return context
    }
}