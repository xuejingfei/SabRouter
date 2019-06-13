package com.xjf.plugin.findclass;

import com.android.build.api.transform.QualifiedContent;
import com.quinn.hunter.transform.HunterTransform;
import org.gradle.api.Project;

import java.util.HashSet;
import java.util.Set;

/**
 * Author：xuejingfei
 * <p>
 * Description：
 * <p>
 * Date：2019-06-12 22:26
 */
public class FindClassTransform extends HunterTransform {
    private static final Set<QualifiedContent.Scope> FINDSCOPES = new HashSet<>();

    static {
        FINDSCOPES.add(QualifiedContent.Scope.PROJECT);
        FINDSCOPES.add(QualifiedContent.Scope.SUB_PROJECTS);
    }
    public FindClassTransform(Project project) {
        super(project);
        System.out.println("开始寻找目标类");
        this.bytecodeWeaver = new FindClassWeaver();
    }
    @Override
    public Set<QualifiedContent.Scope> getScopes() {
        return FINDSCOPES;
    }
}
