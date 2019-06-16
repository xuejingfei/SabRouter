package com.xjf.plugin.injectcode;

import com.xjf.plugin.ScanSetting;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.LocalVariablesSorter;

/**
 * description: 专家个人信息界面
 *
 * @author xuejingfei
 * create at 19-6-13
 */
public class AddCallAppInjectMethodVisitor extends LocalVariablesSorter implements Opcodes {
    private String mName;
    private String methodDescribe;
    private boolean mILoad;
    private boolean mALoad;

    public AddCallAppInjectMethodVisitor(MethodVisitor mv,int access,String methodName,String methodDescribe,Boolean aLoad1, boolean  iLoad1) {
        super(Opcodes.ASM5,access,methodDescribe, mv);
        this.mName = methodName;
        this.methodDescribe = methodDescribe;
        this.mILoad = iLoad1;
        this.mALoad = aLoad1;
    }

    @Override
    public void visitInsn(int opcode) {
        if ((opcode >= IRETURN && opcode <= RETURN) || opcode == ATHROW) {
            mv.visitMethodInsn(Opcodes.INVOKESTATIC, ScanSetting.ServiceManager, "getInstance", "()L" + ScanSetting.ServiceManager + ";", false);
            if (mALoad) {
                mv.visitVarInsn(Opcodes.ALOAD, 1);
            }
            if (mILoad) {
                mv.visitVarInsn(Opcodes.ILOAD, 1);
            }
            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ScanSetting.ServiceManager, mName, methodDescribe, false);
        }
        super.visitInsn(opcode);

    }

}
