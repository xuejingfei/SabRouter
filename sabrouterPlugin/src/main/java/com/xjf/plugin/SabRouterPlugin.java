package com.xjf.plugin;

import com.android.build.gradle.AppExtension;
import com.xjf.plugin.findclass.FindClassTransform;
import com.xjf.plugin.injectcode.CodeInjectTransform;
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
        System.out.println("---this  is my plugin----");
        AppExtension extension =  (AppExtension) project.getProperties().get("android");
        extension.registerTransform(new FindClassTransform(project));
        extension.registerTransform(new CodeInjectTransform(project));
    }
}
