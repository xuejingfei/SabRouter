package com.xjf.plugin;

import com.quinn.hunter.transform.HunterTransform;
import org.gradle.api.Project;

/**
 * Author：xuejingfei
 * <p>
 * Description：
 * <p>
 * Date：2019-06-12 22:26
 */
public class SabRouterTransform extends HunterTransform {
    public SabRouterTransform(Project project) {
        super(project);
        this.bytecodeWeaver = new SabRouterWeaver();
    }
}
