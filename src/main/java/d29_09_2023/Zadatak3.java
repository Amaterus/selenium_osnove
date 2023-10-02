package d29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        driver.get("https://docs.katalon.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[@data-theme='light']")));
        System.out.println("Tema je svetla!");

        driver.findElement(By.xpath("//button[contains(@class, 'toggleButton_rCf9')]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[@data-theme='dark']")));
        System.out.println("Tema je mracna!");

        new Actions(driver).keyDown(Keys.LEFT_CONTROL).sendKeys("k").keyUp(Keys.LEFT_CONTROL).perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='docsearch-input']")));

        try {
            driver.findElement(By.xpath("//input[@id='docsearch-input'][@type='search']"));
        } catch (Exception e) {
            throw e;
        }
        driver.quit();
    }
}

