package com.xjf.plugin.findclass;


import com.xjf.plugin.ScanSetting;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;


/**
 * Author：xuejingfei
 * <p>
 * Description： 第一次遍历项目中所有的类，找到目标类
 * <p>
 * Date：2019-06-12 22:44
 */
public class FindTargetClassAdapter extends ClassVisitor {
    private String[]  interfaces;
    private String className;


    public FindTargetClassAdapter(int api, ClassVisitor cv) {
        super(api, cv);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        this.className = name;
        this.interfaces = interfaces;
    }


    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        switch (desc) {
            case ScanSetting.ModuleSpec:
                System.out.println("moduleApplication" + className);
                ScanSetting.moduleApplications.add(className);
                break;
            case ScanSetting.ServiceImpl:
                for(String inter:interfaces){
                    System.out.println("serviceImpl" + inter + className);
                    ScanSetting.serviceImplMaps.put(inter,className);
                }
                break;
            default:
                break;
        }
        return super.visitAnnotation(desc, visible);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        return super.visitMethod(access, name, desc, signature, exceptions);
    }


}
