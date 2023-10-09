package p05_10_2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class SwagLabsTests {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com";
    WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(baseUrl);
        driver.manage().deleteAllCookies();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void verifyErrorWhenUsernameIsMissing() {
        WebElement loginButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("login-button")));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector("[data-test='error']"));
        String expectedErrorMessage = "Epic sadface: Username is required";
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage);
    }

    @Test
    public void verifyErrorWhenPasswordIsMissing() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("velja123");

        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();


        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test='error']")));

        String expectedErrorMessage = "Epic sadface: Password is required";
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage);
    }

    @Test
    public void verifyErrorWhenCredentialsAreWrong() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("invalidpassword");

        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();


        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test='error']")));

        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage);
    }

    @Test
    public void verifyErrorWhenUserIsLocked() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("locked_out_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();


        WebElement errorMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-test='error']")));

        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out.";
        Assert.assertEquals(errorMessage.getText(), expectedErrorMessage);
    }

    @Test
    public void verifySuccessfulLoginAndLogout() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/inventory.html");
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1000);
        WebElement logoutButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("logout_sidebar_link")));
        logoutButton.click();
        WebElement loginForm = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("login-button")));
        Assert.assertTrue(loginForm.isDisplayed());
    }


    @Test
    public void verifyAddingProductsToCart() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/inventory.html");

        WebElement backpackProduct = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));

        WebElement addToCartButton = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();

        WebElement removeButton = driver.findElement(By.name("remove-sauce-labs-backpack"));
        Assert.assertTrue(removeButton.isDisplayed());

        WebElement cartItemCount = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        Assert.assertEquals(cartItemCount.getText(), "1");
    }

    @Test
    public void verifyViewingProductDetails() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.name("login-button")).click();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/inventory.html");

        WebElement backpackProduct = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        backpackProduct.click();

        Assert.assertTrue(driver.findElement(By.className("inventory_details_price")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.className("inventory_details_desc")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).isDisplayed());
    }


    @Test
    public void verifyRemovingProductsFromCart() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/inventory.html");

        WebElement backpackProduct = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));

        WebElement addToCartButton = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();

        WebElement cartItemCount = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        Assert.assertEquals(cartItemCount.getText(), "1");

        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();

        List<WebElement> cartProducts = driver.findElements(By.xpath("//div[text()='Sauce Labs Backpack']"));
        Assert.assertEquals(cartProducts.size(), 1);

        WebElement removeButton = driver.findElement(By.name("remove-sauce-labs-backpack"));
        removeButton.click();

        cartProducts = driver.findElements(By.xpath("//div[text()='Sauce Labs Backpack']"));
        Assert.assertEquals(cartProducts.size(), 0);
    }

    @Test
    public void verifyProductCheckout() {
        WebElement usernameField = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");

        WebElement backpackProduct = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));

        WebElement addToCartButton = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();

        WebElement cartItemCount = driver.findElement(By.cssSelector(".shopping_cart_badge"));
        Assert.assertEquals(cartItemCount.getText(), "1");

        WebElement cartIcon = driver.findElement(By.className("shopping_cart_link"));
        cartIcon.click();

        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();

        WebElement firstNameField = driver.findElement(By.name("firstName"));
        WebElement lastNameField = driver.findElement(By.name("lastName"));
        WebElement zipCodeField = driver.findElement(By.name("postalCode"));

        firstNameField.sendKeys("Velja");
        lastNameField.sendKeys("Veljic");
        zipCodeField.sendKeys("18400");

        WebElement continueButton = driver.findElement(By.id("continue"));
        continueButton.click();

        WebElement overviewName = driver.findElement(By.cssSelector("#item_4_title_link > div"));

        Assert.assertTrue(overviewName.isDisplayed());

        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

        WebElement orderConfirmation = driver.findElement(By.cssSelector("#checkout_complete_container > h2"));
        Assert.assertTrue(orderConfirmation.isDisplayed());
    }

    @Test
    public void validateSocialLinksInFooter() throws IOException {
        String username10= "standard_user";
        String password10= "secret_sauce";
        WebElement usernameField= driver.findElement(By.id("user-name"));
        usernameField.sendKeys(username10);
        WebElement passwordField= driver.findElement(By.id("password"));
        passwordField.sendKeys(password10);
        WebElement login = driver.findElement(By.name("login-button"));
        login.click();
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl+"/inventory.html");

        WebElement footer = driver.findElement(By.tagName("footer"));
        ((ChromeDriver) driver).executeScript("arguments[0].scrollIntoView(true);", footer);

        String[] socialLinks = {"linkedin", "facebook", "twitter"};
        for (String socialLink : socialLinks) {
            WebElement link = driver.findElement(By.xpath("//a[contains(@href, '" + socialLink + "')]"));
            String href = link.getAttribute("href");
            int responseCode = getResponseCode(href);
            Assert.assertTrue(responseCode == 200 || responseCode == 302, "Response code isnt 200 or 302");
        }
    }

    private int getResponseCode(String url) throws IOException, IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        return con.getResponseCode();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}


