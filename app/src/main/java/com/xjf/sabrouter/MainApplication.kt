package com.xjf.sabrouter

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.xjf.sabrouter.annotation.AppSpec

/**
 * description: 主application
 * @author xuejingfei
 * create at 19-6-13
 */
@AppSpec
class MainApplication : Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
    }

    override fun onTerminate() {
        super.onTerminate()
    }

}