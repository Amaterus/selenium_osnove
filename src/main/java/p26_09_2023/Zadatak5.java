package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/automation-practice-form");

//        driver.findElement(By.id("hobbies-checkbox-1")).click();

        driver
                .findElement(By.cssSelector("[for='hobbies-checkbox-1']"))
                .click();

        boolean checked = driver
                .findElement(By.id("hobbies-checkbox-1"))
                .isSelected();

        if (checked) {
            System.out.println("Cekirano");
        } else {
            System.out.println("Nije cekirano.");
        }

        Thread.sleep(5000);
        driver.quit();









    }
}
