package com.xjf.plugin.injectcode;

import com.xjf.plugin.ScanSetting;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.LocalVariablesSorter;

/**
 * description: SabRouterManager 构造函数插入代码
 *
 * @author xuejingfei
 * create at 19-6-14
 */
public class AddCodeToConstructorVisitor extends LocalVariablesSorter implements Opcodes {


    public AddCodeToConstructorVisitor(String name, int access, String desc,MethodVisitor mv) {
        super(Opcodes.ASM5,access,desc, mv);
    }

    @Override
    public void visitInsn(int opcode) {
        if ((opcode >= IRETURN && opcode <= RETURN) || opcode == ATHROW) {
                // 插入Application
                for (String appName : ScanSetting.moduleApplications) {
                    insertApplicationAdd(appName);
                }

                //插入实现方法
                for (String key : ScanSetting.serviceImplMaps.keySet()) {
                    insertServiceImpPut(key, ScanSetting.serviceImplMaps.get(key));
                }
        }
        super.visitInsn(opcode);

    }


    private void insertApplicationAdd(String applicationName) {
        //方法是否为基本类型
        System.out.println("modularization: insertApplicationAdd -> " + applicationName);
        mv.visitVarInsn(ALOAD, 0);
        mv.visitFieldInsn(GETFIELD, ScanSetting.ServiceManager, "moduleApplication", "Ljava/util/ArrayList;");
        mv.visitTypeInsn(NEW, applicationName);
        mv.visitInsn(DUP);
        mv.visitMethodInsn(INVOKESPECIAL, applicationName, "<init>", "()V", false);
        mv.visitMethodInsn(INVOKEVIRTUAL, "java/util/ArrayList", "add", "(Ljava/lang/Object;)Z", false);
        mv.visitInsn(POP);
    }

    private void insertServiceImpPut(String key, String value) {
        mv.visitVarInsn(ALOAD, 0);
        mv.visitFieldInsn(GETFIELD, ScanSetting.ServiceManager, "serviceImplMap", "Ljava/util/HashMap;");
        mv.visitLdcInsn(Type.getObjectType(key));
        mv.visitLdcInsn(Type.getObjectType(value));
        mv.visitMethodInsn(INVOKEINTERFACE, "java/util/HashMap", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", true);
        mv.visitInsn(POP);
    }


}
