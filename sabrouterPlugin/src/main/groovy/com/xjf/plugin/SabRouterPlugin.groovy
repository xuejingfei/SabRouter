import org.gradle.api.Plugin
import org.gradle.api.Project



public class SabRouterPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        def android  = project.extensions.findByType(AppExtension)

    }
}