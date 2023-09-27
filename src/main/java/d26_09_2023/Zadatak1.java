package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://demoqa.com/automation-practice-form");

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys("Veljko");

        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Andjelkovic");

        WebElement email = driver.findElement(By.cssSelector("#userEmail"));
        email.sendKeys("veljkoandjelkovic2000@gmail.com");

        WebElement gender = driver.findElement(By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label"));
        gender.click();

        WebElement mobileNumber = driver.findElement(By.id("userNumber"));
        mobileNumber.sendKeys("1234567890");

        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.click();

        Select monthSelect = new Select(driver.findElement(By.className("react-datepicker__month-select")));
        monthSelect.selectByValue("0");

        Select yearSelect = new Select(driver.findElement(By.className("react-datepicker__year-select")));
        yearSelect.selectByValue("2000");

        WebElement day = driver.findElement(By.cssSelector("div[aria-label='Choose Saturday, January 29th, 2000']"));
        day.click();

        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        subjects.sendKeys("Computer Science");
        subjects.sendKeys(Keys.ENTER);

        WebElement hobbies = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
        hobbies.click();

        WebElement currentAddressInput = driver.findElement(By.id("currentAddress"));
        currentAddressInput.sendKeys("Ozrenska 99");

        driver.quit();
    }
}

