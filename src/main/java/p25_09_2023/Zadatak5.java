package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak5 {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String[] urls = {
                "https://google.com/",
                "https://youtube.com/",
                "https://www.ebay.com/",
                "https://www.kupujemprodajem.com/"
        };

        for (int i = 0; i < urls.length; i++) {
            String url = urls[i];
            driver.get(url);
            WebElement pageTitleElement = driver.findElement(By.tagName("title"));
            String pageTitle = driver.getTitle();
            System.out.println(pageTitle);
        }
        driver.quit();
    }
}

