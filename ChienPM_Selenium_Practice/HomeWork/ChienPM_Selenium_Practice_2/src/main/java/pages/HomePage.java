package pages;

import core.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[text() = 'S']")
    private WebElement sizeSButton;

    @FindBy(how = How.XPATH, using = "//*[text() = 'Add to cart']")
    private List<WebElement> addToCartButtons;

    @FindBy(how = How.XPATH, using = "//*[text() = 'Checkout']")
    private WebElement checkoutButton;

    @FindBy(how = How.XPATH, using = "//*[@class='sc-1h98xa9-9 jzywDV']")
    private WebElement subTotal;

    public void navigateToLoginPage(String url) {
        driver.navigate().to(url);
    }

    public void maximizeBrowserwindow() {
        driver.manage().window().maximize();
    }

    public void clickSizeSButton() {
        sizeSButton.click();
    }

    // Method to get the list of "Add to cart" buttons using XPath
    public List<WebElement> getAddToCartButtons() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text() = 'Add to cart']")));
        return driver.findElements(By.xpath("//button[text()='Add to cart']"));
    }

    // Method to print index and click each "Add to cart" button in the list
    public void printIndexAndClickEachAddToCartButton() {
        List<WebElement> addToCartButtons = getAddToCartButtons();
        if (addToCartButtons.isEmpty()) {
            System.out.println("No 'Add to cart' buttons found!");
        } else {
            for (int i = 0; i < addToCartButtons.size(); i++) {
                System.out.println("Clicking on button number: " + (i + 1));  // Print the order of the button
                addToCartButtons.get(i).click();  // Click the button at index i
            }
        }
    }

    public void clickCheckoutButton() {
        wait.until(ExpectedConditions.visibilityOf(subTotal));
        checkoutButton.click();
    }

    // Verify alert is displayed
    public boolean VerifyAlertIsDisplayed() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            return true;

        } catch (Exception e) {
            System.err.println("An error occurred while verifying the alert: " + e.getMessage());
            return false;
        }
    }
    // Verify compare subtotal prices
    public boolean CompareSubtotalPrices() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            alert.accept();
            System.out.println("Alert text: " + alertText);
            String subtotalText = subTotal.getText();
            System.out.println("Subtotal: " + subtotalText);
            // Verify that the subtotal price in the cart matches the one in the alert
            // Return the comparison result
            return alertText.contains(subtotalText);

        } catch (Exception e) {
            System.err.println("An error occurred while verifying alert and subtotal: " + e.getMessage());
            return false;
        }
    }

}

