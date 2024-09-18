package pages;

import core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//marquee[@class='heading3']")
    private WebElement welcomeMessage;

    @FindBy(how = How.XPATH, using = "//a[@href='Logout.php']")
    private WebElement logoutButton;

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    public boolean isLogOutMessageDisplayed() throws InterruptedException {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            System.out.println("Alert text: " + alertText);
            return alertText.contains("You Have Succesfully Logged Out!!");

    }
}

