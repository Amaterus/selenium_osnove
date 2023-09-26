package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        String[] todos = {
                "Visit Paris",
                "Visit Prague",
                "Visit London",
                "Visit New York",
                "Visit Belgrade"
        };

        driver.navigate().to("https://example.cypress.io/todo");

        for (int i = 0; i < todos.length; i++) {
            String todo = todos[i];
            WebElement todoInput = driver.findElement(By.cssSelector("input.new-todo"));
            todoInput.sendKeys(todo);
            todoInput.sendKeys(Keys.ENTER);
        }

        List<WebElement> todoElements = driver.findElements(By.cssSelector(".toggle"));
        for (int i = 0; i < todoElements.size(); i++) {
            WebElement todoElement = todoElements.get(i);
            todoElement.click();
        }
        Thread.sleep(5000);
        driver.quit();
    }
}
