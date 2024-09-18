package provider;

import org.testng.annotations.DataProvider;
import utility.ExcelUtils;

public class LoginDataProvider {
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"", "", "unsuccessful"},
                {"", "secret_sauce", "unsuccessful"},
                {"standard_user", "", "unsuccessful"},
                {"standard_user", "secret_sauce", "successful"}
        };
    }

    @DataProvider(name = "excelLoginData")
    public Object[][] getDataFromExcel() throws Exception {
        return ExcelUtils.getTableArray("public/testData.xlsx", "data");

    }
}
