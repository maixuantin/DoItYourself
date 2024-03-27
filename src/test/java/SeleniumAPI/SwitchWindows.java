package SeleniumAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SwitchWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        String originalWindow = driver.getWindowHandle();
        System.out.println(originalWindow);
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        for (String windowHandle : driver.getWindowHandles()) {
            System.out.println(windowHandle);
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}
