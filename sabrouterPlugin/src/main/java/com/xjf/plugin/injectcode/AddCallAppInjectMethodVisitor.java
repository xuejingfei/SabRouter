package com.xjf.plugin.injectcode;

import com.xjf.plugin.ScanSetting;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * description: 专家个人信息界面
 *
 * @author xuejingfei
 * create at 19-6-13
 */
public class AddCallAppInjectMethodVisitor extends MethodVisitor {
    private String mName;
    private String methodDescribe;
    private boolean mILoad;
    private boolean mALoad;

    public AddCallAppInjectMethodVisitor(MethodVisitor mv,String methodName,String methodDescribe,Boolean aLoad1, boolean  iLoad1) {
        super(Opcodes.ASM5, mv);
        this.mName = methodName;
        this.methodDescribe = methodDescribe;
        this.mILoad = iLoad1;
        this.mALoad = aLoad1;

    }

    @Override
    public void visitInsn(int opcode) {
        switch (opcode) {
            case Opcodes.IRETURN:
            case Opcodes.FRETURN:
            case Opcodes.ARETURN:
            case Opcodes.LRETURN:
            case Opcodes.DRETURN:
            case Opcodes.RETURN:
                mv.visitMethodInsn(Opcodes.INVOKESTATIC, ScanSetting.ServiceManager, "instance", "()L${ScanSetting.ServiceManager};", false);
                if (mALoad) {
                    mv.visitVarInsn(Opcodes.ALOAD, 1);
                }
                if (mILoad) {
                    mv.visitVarInsn(Opcodes.ILOAD, 1);
                }
                mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, ScanSetting.ServiceManager, mName, methodDescribe, false);
            }
        super.visitInsn(Opcodes.ASM5);

    }

}
