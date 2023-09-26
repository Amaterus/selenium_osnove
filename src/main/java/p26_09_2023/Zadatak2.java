package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/z80en");

//        #lorem table > tbody > tr > td:nth-child(1)
//        //*[@id='lorem']//tbody/tr/td[1]

        List<WebElement> firstColumn =
                driver.findElements(By.xpath("//*[@id='lorem']//tbody/tr/td[1]"));


//        List<WebElement> rows =
//                driver.findElements(By.xpath("//*[@id='lorem']//tbody/tr"));
//
//        for (int i = 0; i < rows.size(); i++) { // By.tagName("td") => td
//            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
//            columns.get(1).getText();
////            System.out.println(x);
//        }


        for (int i = 0; i < firstColumn.size(); i++) {
            System.out.println(firstColumn.get(i).getText());
        }

        System.out.println("**************");

//      #lorem table tbody tr:nth-child(1) td
//      #lorem table tbody tr:first-child td

        List<WebElement> firstRow =
                driver.findElements(By.xpath("#lorem table tbody tr:first-child td"));

        for (int i = 0; i < firstRow.size(); i++) {
            System.out.println(firstRow.get(i).getText());
        }
        driver.quit();









    }
}
