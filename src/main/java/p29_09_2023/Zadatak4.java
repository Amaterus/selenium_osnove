package p29_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");

        driver.findElement(By.id("basic-primary-trigger")).click();

        WebElement toasts = driver.findElement(By.id("basic-primary-example"));
        wait
                .withMessage("Neka pporuka za gresku")
                .until(ExpectedConditions.visibilityOfAllElements(toasts));
        wait
                .withMessage("Neka pporuka za gresku")
                .until(ExpectedConditions.invisibilityOf(toasts));


        driver.findElement(By.id("basic-primary-trigger")).click();
        wait
                .withMessage("Neka pporuka za gresku")
                .until(ExpectedConditions.visibilityOfAllElements(toasts));
        wait
                .withMessage("Neka pporuka za gresku")
                .until(ExpectedConditions.invisibilityOf(toasts));



        Thread.sleep(5000);
        driver.quit();
    }

}
