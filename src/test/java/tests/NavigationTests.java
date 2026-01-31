package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest {

    private void login() {
        driver.get("https://www.saucedemo.com");
        new LoginPage(driver).login("standard_user", "secret_sauce");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void navigationMenuOpensTest() {
        login();
        ProductsPage pp = new ProductsPage(driver);
        pp.openMenu();

        Assert.assertTrue(driver.getPageSource().contains("Logout"));
    }

    @Test
    public void logoutTest() {
        login();
        ProductsPage pp = new ProductsPage(driver);
        pp.openMenu();
        pp.logout();

        Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));
    }

    @Test
    public void aboutPageTest() {
        login();
        ProductsPage pp = new ProductsPage(driver);
        pp.openMenu();
        pp.openAbout();

        Assert.assertTrue(driver.getCurrentUrl().equals("https://saucelabs.com/"));
    }
}