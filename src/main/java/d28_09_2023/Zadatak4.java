package d28_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("http://seleniumdemo.com/?post_type=product");
            driver.findElement(By.cssSelector(".mobile-navbar__wrapper a.search-toggle_btn")).click();

            WebElement searchInput = driver.findElement(By.cssSelector(".mobile-navbar__wrapper input[title='Search …']"));
            wait.until(ExpectedConditions.visibilityOf(searchInput));

            String searchText = "BDD Cucumber";
            searchInput.sendKeys(searchText);
            searchInput.sendKeys(Keys.ENTER);

            WebElement firstResult = driver.findElement(By.cssSelector("article:first-child .czr-title"));
            wait.until(ExpectedConditions.textToBePresentInElement(firstResult, searchText));

            System.out.println("Trazeni tekst se nalazi u naslovu rezultata.");
        } catch (Exception e) {
            System.out.println("Trazeni tekst nije prisutan.");
        } finally {
            driver.quit();
        }
    }
}
