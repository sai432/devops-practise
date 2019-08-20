package devops.tasks;

import devops.config.MyConfig;
import me.alb_i986.selenium.tinafw.domain.WebUser;
import me.alb_i986.selenium.tinafw.tasks.runnable.RunnableTask;
import me.alb_i986.selenium.tinafw.tasks.runnable.SingleUserInteraction;

/**
 * Collection of static (factory) methods returning RunnableTask's.
 */
public class MyRunnableTasks {

    private static WebUser user = new WebUser()
            .withUsername(MyConfig.getUsername())
            .withPassword(MyConfig.getPassword())
            .withBrowserType(MyConfig.getBrowsers().get(0));

    public static RunnableTask login() {
        SingleUserInteraction task = new SingleUserInteraction(
                new ImLoggedIn()
        );
        task.setUser(user);
        return task;
    }
}
