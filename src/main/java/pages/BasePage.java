package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.bidi.log.LogLevel;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import utilities.Constant;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BasePage {
    static WebDriver driver;
    private WebDriverWait wait;

    public BasePage() {
    }

    /**
     * Maximize Window
     */
    public void maximize() {
        Reporter.log("Maximize window");
        driver.manage().window().maximize();
    }

    /**
     * Refresh Page
     */
    public void refresh() {
        Reporter.log("Refresh window");
        driver.navigate().refresh();
    }

    /**
     * Turn Back Page
     */
    public void back() {
        Reporter.log("Turn back page");
        driver.navigate().back();
    }

    /**
     * Forward Page
     */
    public void forward() {
        Reporter.log("Forward page");
        driver.navigate().forward();
    }

    /**
     * Navigate URL
     *
     * @param url
     */
    public void navigate(String url) {
        Reporter.log("Navigate to url: " + url);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constant.TIMEOUT));
        driver.get(url);
    }

    /**
     * Close Browser
     */
    public void closeBrowser() {
        Reporter.log("Close Browser");
        driver.quit();
    }

    /**
     * Setup Driver
     *
     * @return driver
     */
    public WebDriver setupDriver() {
        driver = new ChromeDriver();
        return driver;
    }

    /**
     * Setup Driver per Browser
     *
     * @param browserName
     * @return driver
     */
    public WebDriver setupDriver(String browserName) {
        if (browserName.toLowerCase().equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.toLowerCase().equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.toLowerCase().equals("safari")) {
            driver = new SafariDriver();
        } else if (browserName.toLowerCase().equals("ie")) {
            driver = new InternetExplorerDriver();
        }
        return driver;
    }

    /**
     * Input Value
     *
     * @param by
     * @param value
     */
    public void inputValue(By by, String value) {
        Reporter.log("Input value '" + value + "' on locator: " + by.toString());
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(value);
    }

    /**
     * Input Masked Value
     *
     * @param by
     * @param value
     */
    public void inputMaskedValue(By by, String value) {
        Reporter.log("Input value on locator: " + by.toString());
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(value);
    }

    /**
     * Click
     *
     * @param by
     */
    public void click(By by) {
        Reporter.log("Click on locator: " + by.toString());
        driver.findElement(by).click();
    }

    /**
     * Get Title
     *
     * @return
     */
    public String getTitle() {
        String title = driver.getTitle();
        Reporter.log("Title: " + title);
        return title;
    }

    /**
     * Get URL
     *
     * @return
     */
    public String getURL() {
        String url = driver.getCurrentUrl();
        Reporter.log("URL: " + url);
        return url;
    }

    /**
     * Is Displayed
     *
     * @param by
     * @return
     */
    public boolean isDisplayed(By by) {
        Reporter.log("Check element is displayed or not" + by.toString());
        return driver.findElement(by).isDisplayed();
    }

    /**
     * Is Enabled
     *
     * @param by
     * @return
     */
    public boolean isEnabled(By by) {
        Reporter.log("Check element is enabled or not" + by.toString());
        return driver.findElement(by).isEnabled();
    }

    /**
     * Is Selected
     *
     * @param by
     * @return
     */
    public boolean isSelected(By by) {
        Reporter.log("Check element is selected or not" + by.toString());
        return driver.findElement(by).isSelected();
    }

    /**
     * Get Text
     *
     * @param by
     * @return
     */
    public String getText(By by) {
        String text = driver.findElement(by).getText();
        Reporter.log("Get Text '" + text + "' on the locator: " + by.toString());
        return text;
    }

    /**
     * Wait For Element To Appear
     *
     * @param by
     */
    public void waitForElementToAppear(By by) {
        Reporter.log("Wait for element to appear on locator: " + by.toString());
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     * Wait For Element To Disappear
     *
     * @param by
     */
    public void waitForElementToDisappear(By by) {
        Reporter.log("Wait for element to disappear on locator: " + by.toString());
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    /**
     * Wait For Text To Disappeared
     *
     * @param by
     * @param text
     */
    public void waitForTextToDisappeared(By by, String text) {
        Reporter.log("Wait for text '" + text + "' to disappeared on locator: " + by.toString());
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(by, text)));
    }

    /**
     * Select Drop Down By Value
     *
     * @param by
     * @param value
     */
    public void selectDropdownByValue(By by, String value) {
        Reporter.log("Select drop down by value: '" + value + "' on a locator " + by.toString());
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByValue(value);
    }

    /**
     * Select Drop Down By Index
     *
     * @param by
     * @param index
     */
    public void selectDropdownByIndex(By by, int index) {
        Reporter.log("Select drop down by index: '" + index + "' on a locator " + by.toString());
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByIndex(index);
    }

    /**
     * Select Drop Down By Text
     *
     * @param by
     * @param text
     */
    public void selectDropdownByText(By by, String text) {
        Reporter.log("Select drop down by text: '" + text + "' on a locator " + by.toString());
        Select dropdown = new Select(driver.findElement(by));
        dropdown.selectByVisibleText(text);
    }

    /**
     * Close Alert
     *
     * @param option (accept or dismiss)
     */
    public void closeAlert(String option) {
        Reporter.log("Close Alert with option: " + option);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        if (option.toLowerCase().equals("accept")) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }

    /**
     * Set Value Into Alert
     *
     * @param value  input value
     * @param option (accept or dismiss)
     */
    public void setValueIntoAlert(String value, String option) {
        Reporter.log("Set '" + value + "' into Alert");
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(value);
        if (option.toLowerCase().equals("accept")) {
            alert.accept();
        } else {
            alert.dismiss();
        }
    }

    /**
     * Drag and Drop
     *
     * @param from
     * @param to
     */
    public void dragAndDrop(By from, By to) {
        Reporter.log("Drag " + from + " drop " + to);
        WebElement elementFrom = driver.findElement(from);
        WebElement elementTo = driver.findElement(to);
        Actions action = new Actions(driver);
        action.dragAndDrop(elementFrom, elementTo).build().perform();
    }

    /**
     * Execute Script
     *
     * @param value
     */
    public void executeScript(String value) {
        Reporter.log("Execute script: " + value);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(value);
    }
}