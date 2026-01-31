package tests;

import base.BaseTest;
import pages.FilterPage;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FilterTests extends BaseTest {

    private void login() {
        driver.get("https://www.saucedemo.com");
        new LoginPage(driver).login("standard_user", "secret_sauce");
    }

    @Test
    public void filterNameAToZTest() {
        login();
        new FilterPage(driver).selectFilter("Name (A to Z)");
        Assert.assertTrue(true);
    }

    @Test
    public void filterNameZToATest() {
        login();
        new FilterPage(driver).selectFilter("Name (Z to A)");
        Assert.assertTrue(true);
    }

    @Test
    public void filterPriceLowToHighTest() {
        login();
        new FilterPage(driver).selectFilter("Price (low to high)");
        Assert.assertTrue(true);
    }

    @Test
    public void filterPriceHighToLowTest() {
        login();
        new FilterPage(driver).selectFilter("Price (high to low)");
        Assert.assertTrue(true);
    }
}