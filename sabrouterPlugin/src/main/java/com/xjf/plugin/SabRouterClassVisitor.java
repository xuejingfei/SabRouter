package com.xjf.plugin;


import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Author：xuejingfei
 * <p>
 * Description：
 * <p>
 * Date：2019-06-12 22:44
 */
public class SabRouterClassVisitor extends ClassVisitor {
    private String[]  interfaces;
    private List moduleApplications = new ArrayList<String>();
    private Map serviceImplMaps = new HashMap<String, String>();

    private String className;

    public SabRouterClassVisitor(int api) {
        super(api);
    }

    public SabRouterClassVisitor(int api, ClassVisitor cv) {
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
            case "ModuleSpec":
                moduleApplications.add(className);
                break;
            case "ServiceImpl":
                for(String inter:interfaces){
                    serviceImplMaps.put(inter,className);
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
