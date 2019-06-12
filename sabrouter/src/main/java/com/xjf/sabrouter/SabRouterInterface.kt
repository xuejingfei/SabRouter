package com.xjf.sabrouter

import android.content.Context
import android.content.res.Configuration

/**
 * description: 管理类接口
 * @author xuejingfei
 * create at 19-6-12
 */

interface SabRouterInterface {

    fun attachBaseContext(context: Context)

    fun onCreate()

    fun onConfigurationChanged(configuration:Configuration)

    fun onLowMemory()

    fun onTerminate()

    fun onTrimMemory(level: Int)

}