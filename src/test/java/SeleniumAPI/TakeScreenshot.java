package SeleniumAPI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement element = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        File file = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("./image.png"));

        File file2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file2, new File("./full_image.png"));
    }
}
