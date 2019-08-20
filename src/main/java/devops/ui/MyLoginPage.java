package devops.ui;

import me.alb_i986.selenium.tinafw.ui.LoginPage;
import me.alb_i986.selenium.tinafw.ui.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyLoginPage extends MyBaseWebPage implements LoginPage<MyHomePage> {

    public static String getRelativeUrl() {
        return "";
    }

    private static final String ROOT_ID_SELECTOR = "content";
    private static final By ROOT_LOCATOR = By.id(ROOT_ID_SELECTOR);

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit")
    private WebElement submitBtn;

    public MyLoginPage(WebDriver driver, WebPage previous) {
        super(driver, previous);
    }

    /**
     * Enter username and password, and submit.
     * Afterwards, the system takes you to the homepage.
     */
    @Override
    public MyHomePage loginAs(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        submitBtn.click();
        return new MyHomePage(driver, this);
    }

    @Override
    protected By getIdentifyingLocator() {
        return ROOT_LOCATOR;
    }
}
