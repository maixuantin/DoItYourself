package pages;

import locators.LoginLocatorsKatalon;
import locators.LoginLocatorsSauce;
import objects.Account;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginKatalonPage extends BasePage {

    public void login(Account account) {
        click(LoginLocatorsKatalon.BUTTON_MAKE_APPOINTMENT_KATALON);
        inputValue(LoginLocatorsKatalon.INPUT_USERNAME_KATALON, account.getUsername());
        inputMaskedValue(LoginLocatorsKatalon.INPUT_PASSWORD_KATALON, account.getPassword());
        click(LoginLocatorsKatalon.BUTTON_LOGIN_KATALON);
        System.out.println(account.toString());
    }

    public void verifyLoginMessage(String expectedMessage) {
        WebElement labelMessage = driver.findElement(LoginLocatorsSauce.LABEL_MESSAGE_SAUCE);
        String actualMessage = labelMessage.getText();
        System.out.println("Expected message: " + expectedMessage);
        System.out.println("Actual message: " + actualMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
}
