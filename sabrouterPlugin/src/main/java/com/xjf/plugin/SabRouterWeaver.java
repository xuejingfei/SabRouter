package com.xjf.plugin;

import com.quinn.hunter.transform.asm.BaseWeaver;
import jdk.internal.org.objectweb.asm.Opcodes;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

/**
 * Author：xuejingfei
 * <p>
 * Description：
 * <p>
 * Date：2019-06-12 22:28
 */
public class SabRouterWeaver extends BaseWeaver {

    @Override
    protected ClassVisitor wrapClassWriter(ClassWriter classWriter) {
        return new SabRouterClassVisitor(Opcodes.ASM5,classWriter);
    }

    /**
     * 表示是否需要对该类进行处理。该transform任务会遍历所有的class，
     * 在遍历每一个class的时候都会调用该方法来判断是否要对该类进行处理。
     * @param fullQualifiedClassName
     * @return
     */
    @Override
    public boolean isWeavableClass(String fullQualifiedClassName) {
        return super.isWeavableClass(fullQualifiedClassName);
    }

}
