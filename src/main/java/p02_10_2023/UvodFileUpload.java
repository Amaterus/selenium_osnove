package p02_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class UvodFileUpload {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("http://demo.guru99.com/test/upload/");

        File uploadFile = new File("test_data/lion.jpg");

        driver
                .findElement(By.id("uploadfile_0"))
                .sendKeys(uploadFile.getAbsolutePath());

        driver
                .findElement(By.id("submitbutton"))
                .click();

        WebElement res = driver.findElement(By.id("res"));
        wait
                .withMessage("Fajl nije uploadovan.")
                .until(ExpectedConditions.textToBePresentInElement(res, "successfully uploaded"));

    }
}
