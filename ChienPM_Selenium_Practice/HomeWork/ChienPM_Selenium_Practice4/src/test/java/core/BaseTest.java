package core;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import utility.ExtentManager;

public class BaseTest {
    private WebDriver driver;
    ExtentReports extent = ExtentManager.createInstance();
    ExtentTest test;
    protected WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    @Parameters("browser")
    public void setUp(String browser) {
        System.out.println("Browser: " + browser);
        extent = ExtentManager.createInstance();
        test = extent.createTest("Sample Test ", "Testing");

        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", ".\\drivers\\msedgedriver.exe");
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
        test.log(Status.INFO, "Browser closed");
        extent.flush();
    }
}
