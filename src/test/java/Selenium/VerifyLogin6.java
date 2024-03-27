package Selenium;

import data.TestData_Katalon;
import objects.Appointment;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utilities.Constant;

public class VerifyLogin6 {
    BasePage basePage;
    LoginKatalonPage loginPage;
    MakeAppointmentPage makeAppointmentPage;
    MakeAppointmentConfirmationPage makeAppointmentConfirmationPage;

    @BeforeClass
    public void setUp() {
        basePage = new BasePage();
        basePage.setupDriver();
        loginPage = new LoginKatalonPage();
        makeAppointmentPage = new MakeAppointmentPage();
        makeAppointmentConfirmationPage = new MakeAppointmentConfirmationPage();
    }

    /*@AfterClass
    public void tearDown(){
        basePage.closeBrowser();
    }*/
    @Test
    public void TestMakeAppointment() {
        Appointment appointment = TestData_Katalon.genAppointment();
        basePage.navigate(Constant.KATALON_URL);
        loginPage.login(TestData_Katalon.accountKatalonSuccess());
        makeAppointmentPage.makeAppointment(appointment);
        makeAppointmentConfirmationPage.validateAppointment(appointment);
    }

}
