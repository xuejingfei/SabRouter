package com.xjf.plugin.injectcode;

import com.quinn.hunter.transform.HunterTransform;
import org.gradle.api.Project;

/**
 * description: 代码植入
 *
 * @author xuejingfei
 * create at 19-6-13
 */
public class CodeInjectTransform extends HunterTransform {

    public CodeInjectTransform(Project project) {
        super(project);
        System.out.print("开始代码植入");
        this.bytecodeWeaver = new CodeInjectWeaver();
    }
}
