package devops.tests;

import devops.tasks.ImLoggedIn;
import me.alb_i986.selenium.tinafw.domain.WebUser;
import me.alb_i986.selenium.tinafw.tasks.WebTasks;
import me.alb_i986.selenium.tinafw.tasks.runnable.RunnableTask;
import me.alb_i986.selenium.tinafw.tasks.runnable.SingleUserInteraction;
import me.alb_i986.selenium.tinafw.tests.JunitWebTest;
import org.junit.Test;

import static me.alb_i986.selenium.tinafw.tasks.WebTasks.*;

public class MyTest extends JunitWebTest {

    private WebUser user;

    @Override
    public void before() {
        user = new WebUser().withBrowserType(browserType);
        browserManager.registerBrowsers(user.getBrowser());
        htmlReporter.setBrowser(user.getBrowser());
        user.openBrowser();
    }

    @Test
    public void draftTest() throws Exception {
        RunnableTask task = new SingleUserInteraction(
            given(new ImLoggedIn())
        );
        task.setUser(user);
        task.run();
    }
}
