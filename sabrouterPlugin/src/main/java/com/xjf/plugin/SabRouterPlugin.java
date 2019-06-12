package com.xjf.plugin;

import com.android.build.gradle.AppExtension;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

/**
 * Author：xuejingfei
 * <p>
 * Description：
 * <p>
 * Date：2019-06-12 22:22
 */
public class SabRouterPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        AppExtension extension =  (AppExtension) project.getProperties().get("android");
        extension.registerTransform(new SabRouterTransform(project));

    }
}
