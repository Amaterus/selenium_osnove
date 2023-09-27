package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;

public class Zadatak1Scanner {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/automation-practice-form");

        Scanner s = new Scanner(System.in);


        System.out.print("Unesite first name: ");
        String firstName = s.nextLine();

        System.out.print("Unesite last name: ");
        String lastName = s.nextLine();

        System.out.print("Unesite email: ");
        String email = s.nextLine();

        System.out.print("Unesite mobile number: ");
        String mobileNumber = s.nextLine();

        WebElement firstNameField = driver.findElement(By.id("firstName"));
        WebElement lastNameField = driver.findElement(By.id("lastName"));
        WebElement emailField = driver.findElement(By.id("userEmail"));
        WebElement mobileNumberField = driver.findElement(By.id("userNumber"));

        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        mobileNumberField.sendKeys(mobileNumber);

        System.out.print("Unesite gender: male, female, other ");
        String genderChoice = s.next();
        s.nextLine();

        if (genderChoice.equals("male")) {
            driver.findElement(By.xpath("//label[@for='gender-radio-1']")).click();
        } else if (genderChoice.equals("female")) {
            driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
        } else if (genderChoice.equals("other")) {
            driver.findElement(By.xpath("//label[@for='gender-radio-3']")).click();
        }

        System.out.print("Unesite Current Address: ");
        WebElement currentAddressField = driver.findElement(By.id("currentAddress"));
        currentAddressField.sendKeys(s.nextLine());

        System.out.print("Unesite datum rodjenja (MM/DD/YYYY): ");
        String dateOfBirth = s.nextLine();

        WebElement dateOfBirthField = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthField.clear();
        dateOfBirthField.sendKeys(dateOfBirth);

        System.out.print("Unesite predmet: ");
        driver.findElement(By.id("subjectsInput")).sendKeys(s.next());
        driver.findElement(By.id("subjectsInput")).sendKeys(Keys.ENTER);

        driver.quit();
    }
}

