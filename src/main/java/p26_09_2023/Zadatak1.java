package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/oV91g");

        Thread.sleep(1000);


        List<WebElement> pagination =
                driver.findElements(By.cssSelector("#myPager a.page_link"));


        for (int i = 0; i < pagination.size(); i++) {
//            pagination.get(i).click();
            String x= pagination.get(i).getText();
            System.out.println(x);
            Thread.sleep(1000);
        }


        driver.quit();









    }
}
