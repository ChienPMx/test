package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AppointmentPage;
import pages.HomePage;
import pages.LoginPage;
import provider.LoginDataProvider;

public class CuraHealthcareServiceTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = LoginDataProvider.class)
    public void ATC001DoLoginUsingDataProvider(String username, String password) {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.navigateToLoginPage("https://katalon-demo-cura.herokuapp.com");
        loginPage.maximizeBrowserwindow();

        homePage.clickMenuToggle();
        homePage.clickLoginLink();
        //login
        loginPage.login(username, password);
        //validateLogin
        Assert.assertTrue(loginPage.getCurrentUrl().contains("#appointment"), "User failed to login.");

        //logout
        homePage.clickMenuToggle();
        homePage.clickLogoutLink();
        //validateLogout
        Assert.assertTrue(loginPage.getCurrentUrl().contentEquals("https://katalon-demo-cura.herokuapp.com/"), "User failed to logout.");
    }

    @Test(dataProvider = "excelMakeAppointmentData", dataProviderClass = LoginDataProvider.class)
    public void ATC002MakeAppointmentUsingExcelFile(String username, String password, String facility, String isHospitalReadmission,
                                                    String healthcareProgram, String visitDate, String comment) {
        HomePage homePage = new HomePage(getDriver());
        LoginPage loginPage = new LoginPage(getDriver());
        AppointmentPage appointmentPage = new AppointmentPage(getDriver());
        loginPage.navigateToLoginPage("https://katalon-demo-cura.herokuapp.com");
        homePage.clickMakeAppointmentButton();
        //login
        loginPage.login(username, password);
        //validateLogin
        Assert.assertTrue(loginPage.getCurrentUrl().contains("#appointment"), "User failed to login.");

        appointmentPage.selectFacility(facility);
        appointmentPage.clickHospitalReadmission(isHospitalReadmission);
        appointmentPage.selectHealthcareProgram(healthcareProgram);
        appointmentPage.enterVisitDate(visitDate);
        appointmentPage.enterComment(comment);
        appointmentPage.clickBookAppointment();

        //Verify Appointment book successful
        Assert.assertTrue(appointmentPage.isAppointmentConfirmed(), "Appointment failed to book");

        // Verify information on confirmation page
        Assert.assertEquals(appointmentPage.getFacility(), facility);
        Assert.assertEquals(appointmentPage.isReadmissionChecked(), isHospitalReadmission);
        Assert.assertEquals(appointmentPage.getHealthcareProgram(), healthcareProgram);
        Assert.assertEquals(appointmentPage.getVisitDate(), visitDate);
        Assert.assertEquals(appointmentPage.getComment(), comment);
    }
}
