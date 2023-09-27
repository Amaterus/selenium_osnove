package d26_09_2023;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement> elements = driver.findElements(By.className("close"));

        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            element.click();
            if (driver.findElements(By.className("close")).isEmpty()) {
                System.out.println("Element je obrisan.");
            } else {
                System.out.println("Element nije obrisan.");
            }
        }
        driver.quit();
    }
}
