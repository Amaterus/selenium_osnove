package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UvodUActions {
    public static void main(String[] args) throws InterruptedException {

        long startTime = 0;
        long endTime = 0;
        startTime = System.currentTimeMillis();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        endTime = System.currentTimeMillis();

        System.out.println("Pokretanje " + (endTime - startTime) / 1000.0+ "s");
        driver.navigate().to("https://docs.katalon.com/");


        startTime = System.currentTimeMillis();
        WebElement docs = driver.findElement(By.cssSelector("nav .navbar__item"));
        endTime = System.currentTimeMillis();
        System.out.println("Trazenje " + (endTime - startTime) / 1000.0 + "s");
        startTime = System.currentTimeMillis();
        new Actions(driver)
                .moveToElement(docs)
                .perform();
        endTime = System.currentTimeMillis();
        System.out.println("AKcija move to element" + (endTime - startTime) / 1000.0+ "s");
//        driver.quit();
    }

}
