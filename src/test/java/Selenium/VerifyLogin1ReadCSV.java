package Selenium;

import data.TestData_Sauce;
import objects.Account;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import utilities.Constant;

public class VerifyLogin1ReadCSV {
    BasePage basePage;
    LoginPage loginPage;

    @BeforeClass
    public void setup() {
        basePage = new BasePage();
        basePage.setupDriver();
        loginPage = new LoginPage();
    }

    @AfterClass
    public void tearDown() {
        basePage.closeBrowser();
    }
    @Test
    public void testLogin01() {
        for (Account account : TestData_Sauce.readAccount()) {
            System.out.println(account.toString());
            basePage.navigate(Constant.SAUCE_URL);
            loginPage.login(account);
            loginPage.verifyLoginMessage(account.getMessage());
        }
    }
}
