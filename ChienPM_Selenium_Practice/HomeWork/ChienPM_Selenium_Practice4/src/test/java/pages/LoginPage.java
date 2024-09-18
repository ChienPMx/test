package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
    private WebDriverWait wait;
    public LoginPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, 3);
    }
    @FindBy(id = "user-name")
    private WebElement userField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = "//*[@data-test='error']")
    private WebElement errorMessage;

    public void navigateToLoginPage(String url) {
        driver.navigate().to(url);
    }
    public void setImplicitWait() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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

    public boolean isErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return errorMessage.isDisplayed();
        } catch (Exception e) {
            System.err.println("An error occurred while checking if the error message is displayed: " + e.getMessage());
            return false;
        }
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

}
