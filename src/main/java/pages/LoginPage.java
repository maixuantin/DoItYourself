package pages;

import locators.LoginLocatorsKatalon;
import locators.LoginLocatorsSauce;
import objects.Account;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public void login(Account account) {
        inputValue(LoginLocatorsSauce.INPUT_USERNAME_SAUCE, account.getUsername());
        inputMaskedValue(LoginLocatorsSauce.INPUT_PASSWORD_SAUCE, account.getPassword());
        click(LoginLocatorsSauce.BUTTON_LOGIN_SAUCE);
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
