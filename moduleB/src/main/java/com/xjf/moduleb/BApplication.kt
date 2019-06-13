package com.xjf.moduleb

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import com.xjf.sabrouter.annotation.ModuleSpec

/**
 * description: 专家个人信息界面
 * @author xuejingfei
 * create at 19-6-13
 */

@ModuleSpec
class BApplication: Application() {

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
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