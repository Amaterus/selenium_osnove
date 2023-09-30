package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("http://seleniumdemo.com/?product=git-basics");
            driver.manage().window().maximize();

            WebElement addToCartBtn = driver.findElement(By.name("add-to-cart"));
            addToCartBtn.click();

            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".nav__woocart .count"), "1"));

            System.out.println("TASK COMPLETED SUCCESSFULLY");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
