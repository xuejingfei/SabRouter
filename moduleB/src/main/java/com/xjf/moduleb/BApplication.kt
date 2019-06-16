package com.xjf.moduleb

import android.content.Context
import android.content.res.Configuration
import com.xjf.sabrouter.annotation.ModuleSpec
import com.xjf.sabrouter.annotation.SabApplication

/**
 * description: 专家个人信息界面
 * @author xuejingfei
 * create at 19-6-13
 */

@ModuleSpec
class BApplication: SabApplication {
    override fun attachBaseContext(base: Context?) {

    }

    override fun onCreate() {
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
    }

    override fun onLowMemory() {
    }

    override fun onTrimMemory(level:Int ) {
    }
    override fun onTerminate() {
    }

}