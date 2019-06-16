package com.xjf.sabrouter;

import android.content.Context;
import android.content.res.Configuration;
import com.xjf.sabrouter.annotation.SabApplication;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * Author：xuejingfei
 * <p>
 * Description：
 * <p>
 * Date：2019-06-16 11:27
 */
public class SabRouterManager {
    private static volatile SabRouterManager mInstance;

    //module和moduleService 之前的映射关系哈希表
    private Map<Class,Class> serviceImplMap = new HashMap<>();

    //module和moduleService实例的映射关系表
    private Map<Class,Object> serviceImplInstanceMap = new HashMap<>();

    //各个module的Application集合，是为了方便管理各个module的生命周期
    private List<SabApplication> moduleApplications = new ArrayList<>();

    public static SabRouterManager getInstance() {
        if(mInstance == null) {
            synchronized (SabRouterManager.class) {
                if(mInstance == null) {
                    mInstance = new SabRouterManager();
                    return mInstance;
                }
            }
        }
        return mInstance;
    }


    private SabRouterManager() {

    }

    public void attachBaseContext(@NotNull Context context)  {
        for (SabApplication application : moduleApplications) {
            application.attachBaseContext(context);
        }
    }

    public void onCreate() {
        for (SabApplication application : moduleApplications) {
            application.onCreate();
        }
    }

    public void onConfigurationChanged(@NotNull Configuration configuration) {
        for (SabApplication application : moduleApplications) {
            application.onConfigurationChanged(configuration);
        }
    }

    public void onLowMemory() {
        for (SabApplication application : moduleApplications) {
            application.onLowMemory();
        }
    }

    public void onTerminate() {
        for (SabApplication application : moduleApplications) {
            application.onTerminate();
        }
    }

    public void onTrimMemory(int level) {
        for (SabApplication application : moduleApplications) {
            application.onTrimMemory(level);
        }
    }

    public <T> T getService(Class<T> tClass){
        try{
            Object serviceInstance = serviceImplInstanceMap.get(tClass);
            if(serviceInstance != null) {
                return (T) serviceInstance;
            }else {
                Class serviceImpl = serviceImplMap.get(tClass);
                if(serviceImpl !=null) {
                    serviceInstance = serviceImpl.newInstance();
                    serviceImplInstanceMap.put(tClass,serviceInstance);
                    return (T)serviceInstance;
                }
            }
        }catch (InstantiationException instantiationException) {
            instantiationException.printStackTrace();
        }catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        return null;
    }

}
