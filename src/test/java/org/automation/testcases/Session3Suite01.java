package org.automation.testcases;

import jxl.read.biff.BiffException;
import org.automation.commons.LoginCommons;
import org.automation.configurations.selenium.TestCaseBase;
import org.automation.pageobjects.LoginPage;
import org.automation.utils.ExcelUtility;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Session3Suite01 extends TestCaseBase {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
    }

    //    ***************************************************************************************
    //    EJEMPLO DE SCREENSHOT
    //    ***************************************************************************************
    @Test(description = "Este test case va a fallar con la idea de tomar un screenshot", groups = {"fail"})
    @Parameters({"username", "password"})
    public void testFail(String userName, String password) {
        LoginCommons.login(loginPage, userName, password);
        Assert.assertFalse(true);
    }

    //    ***************************************************************************************
    //    EJEMPLO DE DATAPROVIDERS CON UNA MATRIZ
    //    ***************************************************************************************
    @DataProvider(name = "dataProviderEjemploMatriz")
    public static Object[][] credentials() {
        return new Object[][]{
                {"automation", "Automation123$"},
                {"automation", ""},
                {"", "Automation123$"},
                {"", ""}
        };
    }

    @Test(description = "Este test case va probar a usar un data provider que lee una matriz",
            groups = {"full_regression", "dp_matriz"},
            dataProvider = "dataProviderEjemploMatriz")
    public void testDataProviderConMatriz(String userName, String password) {
        LoginCommons.login(loginPage, userName, password);
    }

    //    ***************************************************************************************
    //    EJEMPLO DE DATAPROVIDERS CON UN ARCHIVO DE EXCEL/CSV
    //    ***************************************************************************************
    @DataProvider(name = "dataProviderEjemploXLS")
    public static Object[][] dataProviderEjemploXLS() throws IOException, BiffException {
        return new ExcelUtility("src/test/resources/Excel/testXLS.xls").getData();
    }

    @Test(description = "Este test case va probar a usar un data provider que lee un Excel",
            groups = {"full_regression", "dp_excel"},
            dataProvider = "dataProviderEjemploXLS")
    public void testDataProviderConExcel(String userName, String password) {
        LoginCommons.login(loginPage, userName, password);
    }
}
