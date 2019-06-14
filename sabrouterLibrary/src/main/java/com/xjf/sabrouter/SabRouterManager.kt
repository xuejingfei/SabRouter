package com.xjf.sabrouter

import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.util.Log
import java.util.*

/**
 * description: 核心类管理
 * @author xuejingfei
 * create at 19-6-12
 */

class SabRouterManager : SabRouterInterface {


    //各个module的Application集合，是为了方便管理各个module的生命周期
    private val moduleApplication = ArrayList<Application>()

    //module和moduleService 之前的映射关系哈希表
    private val serviceImplMap = HashMap<Class<*>, Class<*>>()

    //module和moduleService实例的映射关系表
    private val serviceImplInstanceMap = HashMap<Class<*>, Any>()


    init {

        moduleApplication.add(Application())
    }

    override fun attachBaseContext(context: Context) {
        moduleApplication.forEach {
            val attachBaseContext =
                ContextWrapper::class.java.getDeclaredMethod("attachBaseContext", Context::class.java)
            attachBaseContext.isAccessible = true
            attachBaseContext.invoke(it, attachBaseContext)
        }
    }


    override fun onCreate() {
        moduleApplication.forEach {
            it.onCreate()
        }
    }

    override fun onConfigurationChanged(configuration: Configuration) {
        moduleApplication.forEach {
            it.onConfigurationChanged(configuration)
        }
    }

    override fun onLowMemory() {
        moduleApplication.forEach {
            it.onLowMemory()
        }
    }

    override fun onTerminate() {
        moduleApplication.forEach {
            it.onTerminate()
        }
    }

    override fun onTrimMemory(level: Int) {
        moduleApplication.forEach {
            it.onTrimMemory(level)
        }
    }


    /**
     * 获取实现类
     */
    @Synchronized
    public fun <T> getService(classType: Class<T>): T? {
        Log.d(TAG, serviceImplInstanceMap.size.toString())
        val serviceInstance = serviceImplInstanceMap[classType]
        serviceInstance?.let {
            return serviceInstance as T
        } ?: serviceImplMap[classType]?.let {
            return (it.newInstance() as T).apply {
                serviceImplInstanceMap[classType] = this as Any
            }
        } ?: Log.e(TAG, "no ${classType.name} type ,please checkout your code---")
        return null
    }


    companion object {
        private val TAG = SabRouterManager::class.java.name

        @JvmStatic
        val getInstance: SabRouterManager by lazy {
            SabRouterManager()
        }
    }

}