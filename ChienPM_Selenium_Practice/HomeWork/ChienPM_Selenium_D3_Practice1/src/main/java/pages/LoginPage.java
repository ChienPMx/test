package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }

    @FindBy (how = How.NAME, using = "uid")
            private WebElement userIdField;
    @FindBy (how = How.NAME, using = "password")
    private WebElement passwordField;
    @FindBy (how = How.NAME, using = "btnLogin")
    private WebElement loginButton;

    public void navigateToLoginPage(String url) {
        driver.navigate().to(url);
    }

    public void setUserId(String userId) {
        userIdField.sendKeys(userId);
    }
    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
}