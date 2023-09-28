package d26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class ZadatakSeleniumTestPage {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        Scanner s = new Scanner(System.in);

        driver.navigate().to("https://automationintesting.com/selenium/testpage/");

        System.out.println("Unesite First Name: ");
        String firstName = s.next();
        driver.findElement(By.id("firstname")).sendKeys(firstName);

        System.out.println("Unesite Surname: ");
        String surName = s.next();
        driver.findElement(By.id("surname")).sendKeys(surName);

        WebElement pol = driver.findElement(By.id("gender"));
        pol.click();
        s.nextLine();

        System.out.print("Unesite vrednost (npr. 'Male', 'Female', 'My Business!'): ");
        String genderInput = s.nextLine();
        pol.sendKeys(genderInput);
        pol.sendKeys(Keys.ENTER);

        System.out.print("Unesite vrednost za omiljenu boju ('Red' ili 'Blue'): ");
        String colorInput = s.nextLine().toLowerCase();

        if (colorInput.equals("red")) {
            WebElement redRadio = driver.findElement(By.id("red"));
            redRadio.click();
        } else if (colorInput.equals("blue")) {
            WebElement blueRadio = driver.findElement(By.id("blue"));
            blueRadio.click();
        }

        System.out.println("Napisite nesto o sebi: ");
        String text = s.nextLine();
        driver.findElement(By.cssSelector("#contactus > div:nth-child(5) > div > label > textarea")).sendKeys(text);

        System.out.print("Unesite opciju za kontinent: ");
        String continentInput = s.nextLine();

        List<WebElement> continentOptions = driver.findElements(By.tagName("option"));
        for (int i = 0; i < continentOptions.size(); i++) {
            WebElement option = continentOptions.get(i);
            if (option.getText().equalsIgnoreCase(continentInput)) {
                option.click();
            }
        }

        WebElement submit = driver.findElement(By.id("submitbutton"));
        submit.click();
    }
}

