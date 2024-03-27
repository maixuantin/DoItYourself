package Selenium;

import objects.Account;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import utilities.Constant;
import utilities.ReadJSON;

import java.io.IOException;

public class VerifyLogin8ReadJSON {
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
        for (Account account : ReadJSON.getAccounts(Constant.JSON_FILE)) {
            System.out.println(account.toString());
            basePage.navigate(Constant.SAUCE_URL);
            loginPage.login(account);
            loginPage.verifyLoginMessage(account.getMessage());
        }
    }
}
