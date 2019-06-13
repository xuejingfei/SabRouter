package com.xjf.plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * description:
 *
 * @author xuejingfei
 * create at 19-6-13
 */
public class ScanSetting {
    public static final String ModuleSpec = "Lcom/xjf/sabrouter/annotation/ModuleSpec;";
    public static final String ServiceImpl = "Lcom/xjf/sabrouter/annotation/ServiceImpl;";
    public static final String AppSpec = "Lcom/xjf/sabrouter/annotation/AppSpec;";

    public static final String ServiceManager = "com.xjf.sabrouter.SabRouterManager";

    public  static List moduleApplications = new ArrayList<String>();
    public static Map serviceImplMaps = new HashMap<String, String>();


}
