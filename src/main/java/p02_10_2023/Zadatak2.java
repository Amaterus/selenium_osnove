package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://blueimp.github.io/jQuery-File-Upload/");


        driver.findElement(By.name("files[]"))
                .sendKeys(new File("test_data/lion.jpg").getAbsolutePath());

        wait.until(ExpectedConditions.numberOfElementsToBe(
                By.cssSelector(".files > tr"), 1));


        driver.findElement(By.cssSelector(".fileupload-buttonbar .start")).click();

        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector(".files button.delete")));

        driver.findElement(By.cssSelector(".files button.delete")).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(
                By.cssSelector(".files > tr"), 0));


    }
}
