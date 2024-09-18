package tests;
import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginLogoutTest extends BaseTest {
    @Test
    public void testLoginAndLogout() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.navigateToLoginPage("http://demo.guru99.com/v4/index.php");
        loginPage.setUserId("mngr587344");
        loginPage.setPassword("uvUbaza");
        loginPage.clickLoginButton();

        // Xác minh đăng nhập thành công
        Assert.assertTrue(homePage.isWelcomeMessageDisplayed(), "Đăng nhập không thành công");
        // Xác minh đăng xuất thành công
        homePage.clickLogoutButton();
        Assert.assertTrue(homePage.isLogOutMessageDisplayed(), "Log out không thành công");
    }
}

