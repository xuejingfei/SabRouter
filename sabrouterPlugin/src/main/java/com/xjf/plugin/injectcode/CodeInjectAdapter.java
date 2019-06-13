package com.xjf.plugin.injectcode;

import com.xjf.plugin.ScanSetting;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

/**
 * description: 植入代码code
 *
 * @author xuejingfei
 * create at 19-6-13
 */
public class CodeInjectAdapter extends ClassVisitor {
    private boolean isAppModule = false;
    private boolean isSabRouterManager = false;

    public CodeInjectAdapter(int api) {
        super(api);
    }

    public CodeInjectAdapter(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        isAppModule = desc == ScanSetting.AppSpec;
        return super.visitAnnotation(desc, visible);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        isSabRouterManager = name == ScanSetting.ServiceManager;
    }


    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        MethodVisitor methodVisitor = super.visitMethod(access, name, desc, signature, exceptions);
        if (isAppModule) {
            System.out.println("appModule" +  name + desc);
            switch (name + desc) {
                case "onCreate()V":
                    return new AddCallAppInjectMethodVisitor(methodVisitor,name,desc,false,false);
                case "attachBaseContext(Landroid/content/Context;)V":
                    return new AddCallAppInjectMethodVisitor(methodVisitor,name,desc,true,false);
                case "onConfigurationChanged(Landroid/content/res/Configuration;)V":
                    return new AddCallAppInjectMethodVisitor(methodVisitor,name,desc,true,false);
                case "onLowMemory()V":
                    return new AddCallAppInjectMethodVisitor(methodVisitor,name,desc,false,false);
                case "onTerminate()V":
                    return new AddCallAppInjectMethodVisitor(methodVisitor,name,desc,false,false);
                case "onTrimMemory(I)V":
                    return new AddCallAppInjectMethodVisitor(methodVisitor,name,desc,false,true);
            }
        }
        return methodVisitor;
    }

}
