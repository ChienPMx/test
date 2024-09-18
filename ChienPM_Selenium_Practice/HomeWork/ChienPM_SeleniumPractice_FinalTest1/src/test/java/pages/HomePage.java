package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 3);
    }

    @FindBy(id = "menu-toggle")
    private WebElement menuToggle;

    @FindBy(linkText = "Login")
    private WebElement loginLink;

    @FindBy(linkText = "Logout")
    private WebElement logoutLink;

    @FindBy(id = "btn-make-appointment")
    private WebElement makeAppointmentButton;

    public void clickMenuToggle() {
        menuToggle.click();
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void clickLogoutLink() {
        logoutLink.click();
    }

    public void clickMakeAppointmentButton() {
        makeAppointmentButton.click();
    }
}
