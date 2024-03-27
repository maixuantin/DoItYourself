package Selenium;

import data.TestData_Sauce;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;
import utilities.Constant;

public class VerifyLogin4 {
    BasePage basePage;
    LoginPage loginPage;
    @BeforeClass
    public void setUp(){
        basePage = new BasePage();
        basePage.setupDriver();
        loginPage = new LoginPage();
    }
    @AfterClass
    public void tearDown(){
        basePage.closeBrowser();
    }
    @Test
    public void TestLogin2(){
        basePage.navigate(Constant.SAUCE_URL);
        loginPage.login(TestData_Sauce.accountSuccess3());
    }
}
