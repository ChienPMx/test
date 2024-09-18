package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class CartTest extends BaseTest {
    @Test
    public void verifySubtotalAndAlertMatch() throws InterruptedException {
        //        1. Go to "https://react-shopping-cart-67954.firebaseapp.com/"
        HomePage homePage = new HomePage(getDriver());
        homePage.navigateToLoginPage("https://react-shopping-cart-67954.firebaseapp.com/");
        homePage.maximizeBrowserwindow();

        //        2. On the left side, click on filter size = S
        homePage.clickSizeSButton();

        //        3. Add 2 items to cart
        homePage.printIndexAndClickEachAddToCartButton();

        //        4. Go to the cart
        //        5. Click "CHECKOUT" button
        homePage.clickCheckoutButton();

        //        6.1 Verify the alert is displayed
        boolean result1 = homePage.VerifyAlertIsDisplayed();
        Assert.assertTrue(result1, "The alert is NOT displayed as expected.");
        //        6.2 Verify the subtotal price in the cart and in the alert is matched
        boolean result2 = homePage.CompareSubtotalPrices();
        Assert.assertTrue(result2, "The subtotal price in the cart and alert do not match.");
    }
}

