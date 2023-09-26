package p25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/webtables");
        driver.findElement(By.cssSelector("#edit-record-1 > svg > path"))
        .click();

        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        WebElement ageInput = driver.findElement(By.id("age"));
        WebElement salaryInput = driver.findElement(By.id("salary"));
        WebElement departmentInput = driver.findElement(By.id("department"));

        firstNameInput.clear();
        firstNameInput.sendKeys("Velja");

        lastNameInput.clear();
        lastNameInput.sendKeys("Andjelkovic");

        emailInput.clear();
        emailInput.sendKeys("velja@example.com");

        ageInput.clear();
        ageInput.sendKeys("23");

        salaryInput.clear();
        salaryInput.sendKeys("150000");

        departmentInput.clear();
        departmentInput.sendKeys("QA");

        driver.findElement(By.id("submit"))
        .click();

        Thread.sleep(5000);
        driver.quit();
    }

}
