package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import provider.LoginDataProvider;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void validateLoginUsingDataProvider(String username, String password, String result) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage("https://www.saucedemo.com/");
        //loginPage.maximizeBrowserwindow();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        if (result.equals("unsuccessful")) {
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Expected error message to be displayed.");
        } else {
            Assert.assertTrue(loginPage.getCurrentUrl().contains("/inventory.html"), "Expected to be redirected to inventory page.");
        }
    }
    @Test(dataProvider = "excelLoginData", dataProviderClass = LoginDataProvider.class)
    public void validateLoginUsingExcelFile(String username, String password, String result) {
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.navigateToLoginPage("https://www.saucedemo.com/");
        //loginPage.maximizeBrowserwindow();
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        if (result.equals("unsuccessful")) {
            Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Expected error message to be displayed.");
        } else {
            Assert.assertTrue(loginPage.getCurrentUrl().contains("/inventory.html"), "Expected to be redirected to inventory page.");
        }
    }

}
