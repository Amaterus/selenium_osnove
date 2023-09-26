package p26_09_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class UvodUTrazenjeIzPrograma {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://s.bootsnipp.com/iframe/oV91g");

        Thread.sleep(1000);

//        WebElement pager = driver.findElement(By.cssSelector("#myPager"));
//
//        WebElement firstLink = pager.findElement(By.cssSelector("a"));

//        List<WebElement> links =
//                pager.findElements(By.cssSelector("a.page_link"));


//        WebElement drugi =
//                driver.findElement(By.cssSelector(
//                                "#myPager > li:nth-child(2) > a.page_link"));


        List<WebElement> pagination =
                driver.findElements(By.cssSelector("#myPager a.page_link"));

        pagination.get(2).click();
        pagination.get(pagination.size() - 1).click();


        for (int i = 0; i < pagination.size(); i++) {
//            pagination.get(i).click();
//            Thread.sleep(1000);

            WebElement drugi =
                    driver.findElement(By.cssSelector(
                            "#myPager > li:nth-child("+i+") > a.page_link"));
        }
// #myPager > li:nth-child(0) > a.page_link
// #myPager > li:nth-child(1) > a.page_link
// #myPager > li:nth-child(2) > a.page_link

        driver.quit();









    }
}
