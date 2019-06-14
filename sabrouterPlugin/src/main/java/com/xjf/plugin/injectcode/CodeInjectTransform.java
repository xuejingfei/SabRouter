package com.xjf.plugin.injectcode;

import com.android.build.api.transform.QualifiedContent;
import com.quinn.hunter.transform.HunterTransform;
import org.gradle.api.Project;

import java.util.HashSet;
import java.util.Set;

/**
 * description: 代码植入
 *
 * @author xuejingfei
 * create at 19-6-13
 */
public class CodeInjectTransform extends HunterTransform {
    private static final Set<QualifiedContent.Scope> FINDSCOPES = new HashSet<>();

    public CodeInjectTransform(Project project) {
        super(project);
        System.out.print("开始代码植入");
        this.bytecodeWeaver = new CodeInjectWeaver();
    }

    static {
        FINDSCOPES.add(QualifiedContent.Scope.PROJECT);
        FINDSCOPES.add(QualifiedContent.Scope.SUB_PROJECTS);
    }

    @Override
    public Set<QualifiedContent.Scope> getScopes() {
        return FINDSCOPES;
    }
}
