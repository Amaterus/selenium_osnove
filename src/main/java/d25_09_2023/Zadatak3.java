package d25_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.navigate().to("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

        for (int i = 0; i < 5; i++) {
            WebElement addNewButton = driver.findElement(By.cssSelector("button.btn.btn-info.add-new"));
            addNewButton.click();

            WebElement nameField = driver.findElement(By.name("name"));
            nameField.sendKeys("Velja");

            WebElement departmentField = driver.findElement(By.name("department"));
            departmentField.sendKeys("QA");

            WebElement phoneField = driver.findElement(By.name("phone"));
            phoneField.sendKeys("0642323234");

            WebElement addButton = driver.findElement(By.xpath("//a[@class=\"add\" and @style=\"display: inline;\"][last()]"));
            addButton.click();
            Thread.sleep(500);
        }
        driver.quit();
    }
}
