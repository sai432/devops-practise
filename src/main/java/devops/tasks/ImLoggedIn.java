package devops.tasks;

import devops.ui.MyLoginPage;
import me.alb_i986.selenium.tinafw.tasks.ImLoggedInBase;
import me.alb_i986.selenium.tinafw.ui.LoginPage;

public class ImLoggedIn extends ImLoggedInBase {

	@Override
    @SuppressWarnings("unchecked")
    protected <P extends LoginPage<?>> Class<P> loginPageClass() {
        return (Class<P>) MyLoginPage.class;
    }
}
