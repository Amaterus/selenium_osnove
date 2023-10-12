package tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.SwagLabsRetry;

public class SwagLabsTests extends BasicTest{

    @Test(retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenUsernameIsMissing () {
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(),
                "Epic sadface: Username is required",
                "Error is not valid when username is missing.");
    }
    @Test(retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenPasswordIsMissing () {
        String username = "standard_user";

        loginPage.clearAndTypeUsername(username);
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(),
                "Epic sadface: Password is required",
                "Error is not valid when password is missing.");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenCredentialsAreWrong () {
        String username = "standard_user";
        String password = "invalidpassword";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageText(),
                "Epic sadface: Username and password do not match any user in this service",
                "Error is not valid when credentials are wrong");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyErrorIsDisplayedWhenUserIsLocked () {
        String username = "locked_out_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getErrorMessageText(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Error is not valid when user is locked");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifySuccessfulLogin () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");
        leftNavPage.clickOnMenuButton();
        leftNavPage.waitForLeftMenuToBeVisible();
        Assert.assertTrue(leftNavPage.doesLogoutButtonExist(),
                "Logout button does not exist in menu.");
        leftNavPage.clickOnButtonLogout();
        Assert.assertTrue(loginPage.doesUsernameInputExist(),
                "Should be redirected to login page after logout.");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void addingProductsToCart () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.clearAndTypeUsername(username);
        loginPage.clearAndTypePassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");
        inventoryPage.clickOnAddToCartButtonForSauceLabsBackpack();
        Assert.assertTrue(inventoryPage.doesRemoveButtonForSauceLabsBackpackExist(),
                "Remove button is not visible.");
        Assert.assertEquals(topNavPage.getTheNumberOfItemInShoppingCast(),
                "1",
                "The number of items should be increased by 1");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyTheUrlOnTheCartPage () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.login(username, password);

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");

        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/cart.html",
                "Should be redirected to cart page after click on the cart button.");

    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyTheTitleOfCartPage () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.login(username, password);

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");

        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertEquals(driver.getTitle(),
                baseTitle,
                "Title should be Swag Labs.");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyTheTitleInHeaderOnCartPage () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.login(username, password);

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");

        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertEquals(topNavPage.getTheTitleInHeader(),
                baseTitle, "Title in header on the Cart Page should be Swag Labs.");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheHamburgerMenuButtonIsPresented () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.login(username, password);

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");

        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertTrue(topNavPage.doesHamburgerMenuButtonExist(),
                "Menu button should be present on the Cart Page.");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheCartIconIsPresented () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.login(username, password);

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");
        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertTrue(topNavPage.doesCartIconExist(),
                "Cart icon should be present on the Cart Page.");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheHamburgerMenuButtonIsEnabled () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.login(username, password);

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");
        topNavPage.clickOnTheHamburgerMenuButton();
        Assert.assertTrue(topNavPage.doesHamburgerMenuIsEnabled(),
                "Hamburger menu button is not enabled.");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheCartIconIsEnabled () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.login(username, password);

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");
        topNavPage.clickOnTheShoppingCartButton();

        Assert.assertTrue(topNavPage.doesShoppingCartButtonIsEnabled(),
                "Shopping cart button is not enabled.");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheHamburgerButtonIsWorking () {
        verifyIfTheHamburgerMenuButtonIsEnabled();
        leftNavPage.waitForLeftMenuToBeVisible();
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheCartIconIsWorking () {
        verifyIfTheCartIconIsEnabled();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/cart.html",
                "Should be redirected to cart page after click on the cart button.");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheCartIconHasCorrectNumberOfAddedItems () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.login(username, password);

        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to inventory page after login.");
        inventoryPage.clickOnAddToCartButtonForSauceLabsBackpack();
        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertEquals(cartPage.getNumberInSpan(),
                cartPage.getNumberInSpan(), "Numbers should be equal.");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyTheSubHeaderTitle () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.login(username, password);
        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertEquals(subHeaderPage.getTheSubHeader(),
                subHeaderCartPage,
                "Sub-header should be 'Your Cart' on the Cart Page.");

    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyTheTotalNumberOfMenuOptions () {
        verifyIfTheHamburgerButtonIsWorking();
        Assert.assertEquals(leftNavPage.numberOfMenuOptions(), 4,
                "Total number of menu options should be four.");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyTheSpellingOfAllOptionsInMenu () {
        verifyIfTheHamburgerButtonIsWorking();
        Assert.assertTrue(leftNavPage.spellingOfAllOptions(),
                "Spelling of options in menu is not correct.");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfAllItemsOptionIsWorking () {
        verifyIfTheHamburgerButtonIsWorking();
        leftNavPage.clickOnTheAllItemsFromMenuOption();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/inventory.html",
                "Should be redirected to the products page.");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfAboutOptionIsWorking () {
        verifyIfTheHamburgerButtonIsWorking();
        leftNavPage.clickOnTheAboutFromMenuOption();
        Assert.assertEquals(driver.getCurrentUrl(),
                "https://saucelabs.com/",
                "Should be redirected to the sauce labs website");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfLogoutOptionIsWorking () throws InterruptedException {
        verifyIfTheHamburgerButtonIsWorking();
        leftNavPage.clickOnTheLogoutFromMenuOption();
        Assert.assertEquals(driver.getCurrentUrl(),
                baseUrl + "/", "Should be redirected to the login page");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfResetAppStateIsWorking () {
        verifyIfTheHamburgerButtonIsWorking();
        inventoryPage.clickOnAddToCartButtonForSauceLabsBackpack();
        leftNavPage.clickOnTheResetFromMenuOption();
        topNavPage.getTheShoppingCartButton();
        Assert.assertTrue(topNavPage.invisibilityOfNumberItemsInCart());
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheEkisButtonIsPresented () {
        verifyIfTheHamburgerButtonIsWorking();
        Assert.assertTrue(leftNavPage.doesEkisButtonExistInMenu(),
                "Ekis button should be visible in menu");
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheEkisButtonsIsWorking () {
        verifyIfTheHamburgerButtonIsWorking();
        leftNavPage.clickOnTheEkisButtonFromMenu();
        leftNavPage.waitForLeftMenuToBeInvisible();
    }
    @Test (retryAnalyzer = SwagLabsRetry.class)
    public void verifyIfTheItemsAddedIsPresented () {
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.login(username, password);
        inventoryPage.clickOnAddToCartButtonForSauceLabsBackpack();
        topNavPage.clickOnTheShoppingCartButton();
        Assert.assertTrue(cartPage.areTheItemsAdded(),
                "Added items should be presented on the page.");
    }
}