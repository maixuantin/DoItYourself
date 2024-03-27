package SeleniumAPI;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.name("frame-top")));
        driver.switchTo().frame(driver.findElement(By.name("frame-left")));
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.name("frame-middle")));
        driver.switchTo().parentFrame();
        driver.switchTo().frame(driver.findElement(By.name("frame-right")));
        driver.switchTo().parentFrame();

        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.name("frame-bottom")));
        driver.switchTo().parentFrame();
        driver.quit();
    }
}
