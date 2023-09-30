package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        try {
            driver.get("https://web.dev/patterns/web-vitals-patterns/infinite-scroll/infinite-scroll/demo.html");

            Select delayDropdown = new Select(driver.findElement(By.id("delay-select")));
            delayDropdown.selectByValue("2000");

            WebElement showMoreButton = driver.findElement(By.cssSelector("button#infinite-scroll-button"));

            while (true) {
                showMoreButton.click();
                Thread.sleep(2000);
                if (driver.findElements(By.className("item")).size() >= 49) {
                    break;
                }
            }

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("button#infinite-scroll-button")));

            System.out.println("Test je uspesno zavrsen!");
        } catch (Exception e) {
            System.err.println("Doslo je do greske: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}
