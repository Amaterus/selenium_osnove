package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.youtube.com/");
        driver
                .findElement(By.name("search_query"))
                .click();
        Thread.sleep(1000);
        driver
                .findElement(By.name("search_query"))
                .sendKeys("Breskvica");


        wait
                .withMessage("Pretraga nije prikazala preporuke")
                .until(ExpectedConditions
                        .numberOfElementsToBeMoreThan(
                                By.cssSelector("[role='presentation']"), 2));



        Thread.sleep(5000);
        driver.quit();
    }

}
