package com.xjf.sabrouter;

import android.app.Application;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    //module和moduleService 之前的映射关系哈希表
    private Map<Class,Class> serviceImplMap = new HashMap<>();
    private ArrayList<Application> moduleApplication = new ArrayList<>();



    @Test
    public void init() throws ClassNotFoundException {
        serviceImplMap.put(String.class,String.class);
        moduleApplication.add(new Application());
    }
}
