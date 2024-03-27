package Selenium;

import objects.Account;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import utilities.Constant;
import utilities.ReadJSON;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import static data.TesData_DB.getAccounts;
import static utilities.ReadDB.*;

public class VerifyLogin9ReadDB {
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
        Connection connection = connection();
        ResultSet resultSet = executeQuery(connection, "Select * from \"Accounts\"");
        ArrayList<Account> accounts = getAccounts(resultSet);
        closeConnections();
        for (Account account : accounts) {
            basePage.navigate(Constant.SAUCE_URL);
            loginPage.login(account);
            loginPage.verifyLoginMessage(account.getMessage());
            System.out.println(account.toString());
        }
    }
}
