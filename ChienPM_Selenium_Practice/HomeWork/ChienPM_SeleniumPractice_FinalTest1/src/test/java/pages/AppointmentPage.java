package pages;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppointmentPage extends BasePage {
    public AppointmentPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 3);
    }

    //Identify the elements on the Make Appointment page
    @FindBy(id = "combo_facility")
    private WebElement facility;

    @FindBy(id = "chk_hospotal_readmission")
    private WebElement hospitalReadmission;

    @FindBy(id = "radio_program_medicaid")
    private WebElement medicaidRadioButton;
    @FindBy(id = "radio_program_medicaid")
    private WebElement medicareRadioButton;
    @FindBy(id = "radio_program_medicaid")
    private WebElement noneRadioButton;

    @FindBy(id = "txt_visit_date")
    private WebElement visitDate;

    @FindBy(id = "txt_comment")
    private WebElement comment;

    @FindBy(id = "btn-book-appointment")
    private WebElement bookAppointmentButton;

    // Identify the values on the confirmation page
    @FindBy(how = How.XPATH, using = "//*[text()='Appointment Confirmation']")
    private WebElement appointmentConfirmationText;

    @FindBy(id = "facility")
    private WebElement facilityConfirm;

    @FindBy(id = "hospital_readmission")
    private WebElement hospitalReadmissionConfirm;

    @FindBy(id = "program")
    private WebElement healthcareProgramConfirm;

    @FindBy(id = "visit_date")
    private WebElement visitDateConfirm;

    @FindBy(id = "comment")
    private WebElement commentConfirm;

    public void selectFacility(String facilityName) {
        facility.sendKeys(facilityName);
    }

    public void clickHospitalReadmission(String isHospitalReadmission) {
        if (isHospitalReadmission.toLowerCase().equalsIgnoreCase("yes")) {
            hospitalReadmission.click();
        }
    }

    public void selectHealthcareProgram(String healthcareProgram) {
        switch (healthcareProgram.toLowerCase()) {
            case "medicaid":
                medicaidRadioButton.click();
                break;
            case "medicare":
                medicareRadioButton.click();
                break;
            case "none":
                noneRadioButton.click();
                break;
        }
    }

    public void enterVisitDate(String date) {
        visitDate.sendKeys(date);
    }

    public void enterComment(String commentText) {
        comment.sendKeys(commentText);
    }

    public void clickBookAppointment() {
        bookAppointmentButton.click();
    }

    //Method verify book successful
    public boolean isAppointmentConfirmed() {
        return appointmentConfirmationText.isDisplayed();
    }

    // Method to get the healthcare program value from the confirmation page
    public String getFacility() {
        return facilityConfirm.getText();
    }

    public String isReadmissionChecked() {
        return hospitalReadmissionConfirm.getText();
    }

    public String getHealthcareProgram() {
        return healthcareProgramConfirm.getText();
    }

    public String getVisitDate() {
        return visitDateConfirm.getText();
    }

    public String getComment() {
        return commentConfirm.getText();
    }
}
