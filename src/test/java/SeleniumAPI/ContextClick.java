package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement element = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        new Actions(driver).moveToElement(element).perform(); // di chuyển mouse
        new Actions(driver).contextClick(element).perform(); // click chuột phải
        new Actions(driver).doubleClick(element).perform();
    }
}
