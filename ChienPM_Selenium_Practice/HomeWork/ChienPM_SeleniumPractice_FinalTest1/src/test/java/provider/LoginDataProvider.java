package provider;

import org.testng.annotations.DataProvider;
import utility.ExcelUtils;

public class LoginDataProvider {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"John Doe", "ThisIsNotAPassword"}
        };
    }

    @DataProvider(name = "excelMakeAppointmentData")
    public Object[][] getDataFromExcel() throws Exception {
        return ExcelUtils.getTableArray("public/testData.xlsx", "data");

    }
}
