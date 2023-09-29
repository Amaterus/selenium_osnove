package p28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class ProveraPostojanja {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        I NACIN - TRY CATCH

//        WebElement btn = null;
//        try {
//            btn = driver.findElement(By.id("visibleAfter"));
//        } catch (Exception e) {
//
//        }
//
//        if (btn != null) {
//            btn.click();
//            System.out.println("Postoji element");
//        } else {
//            System.out.println("Ne postoji element.");
//        }

//        II NACIN

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        List<WebElement> buttons =
                driver.findElements(By.id("visibleAfter"));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        if (buttons.isEmpty()) {
            System.out.println("Ne postoji element");
        } else {
            System.out.println("Postoji element");
        }


    }
}
