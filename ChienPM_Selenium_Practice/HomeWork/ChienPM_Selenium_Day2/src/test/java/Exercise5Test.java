import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Exercise5Test {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void testContextMenuAndAlert() {
        driver.get("http://demo.guru99.com/test/simple_context_menu.html");
        WebElement doubleClickBtn = driver.findElement(By.xpath("//button[contains(text(),'Double-Click Me To See Alert')]"));
        Assert.assertTrue(doubleClickBtn.isDisplayed(), "Double click button should be displayed.");
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn).perform();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        WebElement rightClickBtn = driver.findElement(By.xpath("//span[contains(text(),'right click me')]"));
        actions.contextClick(rightClickBtn).perform();
        driver.findElement(By.xpath("//li[contains(@class,'context-menu-item') and contains(.,'Edit')]")).click();


        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "clicked: edit", "Alert message should be 'clicked: edit'.");
        driver.switchTo().alert().accept();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
