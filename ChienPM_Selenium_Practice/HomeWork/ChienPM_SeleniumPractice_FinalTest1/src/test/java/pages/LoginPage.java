package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 3);
    }

    @FindBy(id = "txt-username")
    private WebElement userField;

    @FindBy(id = "txt-password")
    private WebElement passwordField;

    @FindBy(id = "btn-login")
    private WebElement loginButton;


    public void navigateToLoginPage(String url) {
        driver.navigate().to(url);
    }

    public void maximizeBrowserwindow() {
        driver.manage().window().maximize();
    }

    public void enterUsername(String username) {
        userField.clear();
        userField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
