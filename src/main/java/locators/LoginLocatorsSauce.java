package locators;

import org.openqa.selenium.By;

public class LoginLocatorsSauce {
    public static By INPUT_USERNAME_SAUCE = By.id("user-name");
    public static By INPUT_PASSWORD_SAUCE = By.id("password");
    public static By BUTTON_LOGIN_SAUCE = By.id("login-button");
    public static By LABEL_MESSAGE_SAUCE = By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");
}
