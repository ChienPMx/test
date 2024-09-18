package core;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
    private WebDriver driver;
    protected WebDriver getDriver() {
        return driver;
    }
    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
