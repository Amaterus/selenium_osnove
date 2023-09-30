package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://mdbootstrap.com/docs/standard/components/toasts/");

//        driver.findElement(By.linkText("Basic example")).click();
        WebElement basicLink = driver.findElement(By.linkText("Basic example"));
        new Actions(driver)
                .click(basicLink)
                .perform();

//        new Select(basicLink).selectByValue("2000");

        wait
                .withMessage("Neka poruka!")
                .until(ExpectedConditions.urlContains("#section-basic-example"));


        Thread.sleep(5000);
        driver.quit();
    }

}
