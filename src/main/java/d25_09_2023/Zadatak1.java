package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button.orangehrm-login-button"));

        usernameInput.sendKeys("Admin");
        passwordInput.sendKeys("admin123");

        loginButton.click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("input.oxd-input.oxd-input--active"))
                .sendKeys("Me");
        driver.findElement(By.cssSelector("a.oxd-main-menu-item[href=\"/web/index.php/time/viewTimeModule\"]"))
                .click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("img.oxd-userdropdown-img[src=\"/web/index.php/pim/viewPhoto/empNumber/7\"]"))
                .click();
        driver.findElement(By.cssSelector("a.oxd-userdropdown-link[href=\"/web/index.php/auth/logout\"]"))
                .click();
        Thread.sleep(5000);
        driver.quit();
    }
}

