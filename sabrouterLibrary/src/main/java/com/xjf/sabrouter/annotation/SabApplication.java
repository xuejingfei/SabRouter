package com.xjf.sabrouter.annotation;

import android.content.Context;
import android.content.res.Configuration;

/**
 * Author：xuejingfei
 * <p>
 * Description：
 * <p>
 * Date：2019-06-16 14:30
 */
public interface SabApplication {
    void attachBaseContext(Context base);
    void onCreate();
    void onConfigurationChanged(Configuration newConfig);
    void onLowMemory();
    void onTrimMemory(int level);
    void onTerminate();
}
