package Selenium;

import data.TestData_Katalon;
import objects.Account;
import objects.Appointment;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginKatalonPage;
import pages.MakeAppointmentConfirmationPage;
import pages.MakeAppointmentPage;
import utilities.Constant;

import java.util.ArrayList;
import java.util.Arrays;

public class VerifyLogin7 {
    @BeforeClass
    public void setUp() {

    }

    /*@AfterClass
    public void tearDown(){
        basePage.closeBrowser();
    }*/

    @Test(dataProvider = "testdata")
    public void TestMakeAppointment(String username, String password) {
        System.out.println(username + password);
    }

    @Test(dataProvider = "testdata2")
    public void TestMakeAppointment2(Account account) {
        System.out.println(account.getUsername() + account.getPassword());
    }

    @DataProvider(name = "testdata")
    public Object[][] TestDataFeed() {

// Create object array with 2 rows and 2 column- first parameter is row and second is //column
        Object[][] twitterdata = new Object[2][2];

// Enter data to row 0 column 0
        twitterdata[0][0] = "username1@gmail.com";

// Enter data to row 0 column 1
        twitterdata[0][1] = "Password1";

// Enter data to row 1 column 0
        twitterdata[1][0] = "username2@gmail.com";

// Enter data to row 1 column 0
        twitterdata[1][1] = "Password2";

// return arrayobject to testscript
        return twitterdata;
    }

    //Dùng DataProvider với ArrayList hoaặc csv
    @DataProvider(name = "testdata2")
    public Object[][] TestDataFeed2() {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(new Account("abc", "123"));
        accounts.add(new Account("ABC", "456"));
        accounts.add(new Account("hello", "world"));
        return accounts.stream().map(account -> new Object[] {account}).toArray(Object[][]::new);
    }

}
