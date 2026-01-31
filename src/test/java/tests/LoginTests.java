package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void validLoginTest() {
        driver.get("https://www.saucedemo.com");
        new LoginPage(driver).login("standard_user", "secret_sauce");

        Assert.assertTrue(new ProductsPage(driver).isProductsPageDisplayed());
    }

    @Test
    public void invalidPasswordTest() {
        driver.get("https://www.saucedemo.com");
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "wrong");

        Assert.assertTrue(lp.getErrorMessage().contains("do not match"));
    }

    @Test
    public void invalidUsernameTest() {
        driver.get("https://www.saucedemo.com");
        LoginPage lp = new LoginPage(driver);
        lp.login("wrong_user", "secret_sauce");

        Assert.assertTrue(lp.getErrorMessage().contains("do not match"));
    }

    @Test
    public void emptyUsernameTest() {
        driver.get("https://www.saucedemo.com");
        LoginPage lp = new LoginPage(driver);
        lp.login("", "secret_sauce");

        Assert.assertTrue(lp.getErrorMessage().contains("Username is required"));
    }

    @Test
    public void emptyPasswordTest() {
        driver.get("https://www.saucedemo.com");
        LoginPage lp = new LoginPage(driver);
        lp.login("standard_user", "");

        Assert.assertTrue(lp.getErrorMessage().contains("Password is required"));
    }

    @Test
    public void emptyCredentialsTest() {
        driver.get("https://www.saucedemo.com");
        LoginPage lp = new LoginPage(driver);
        lp.login("", "");

        Assert.assertTrue(lp.getErrorMessage().contains("Username is required"));
    }

    @Test
    public void lockedUserTest() {
        driver.get("https://www.saucedemo.com");
        LoginPage lp = new LoginPage(driver);
        lp.login("locked_out_user", "secret_sauce");

        Assert.assertTrue(lp.getErrorMessage().contains("locked"));
    }
}