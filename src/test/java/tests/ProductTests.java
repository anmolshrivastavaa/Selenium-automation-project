package tests;

import base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTests extends BaseTest {

    private void login() {
        driver.get("https://www.saucedemo.com");
        new LoginPage(driver).login("standard_user", "secret_sauce");
    }

    @Test
    public void productsPageDisplayedTest() {
        login();
        Assert.assertTrue(new ProductsPage(driver).isProductsPageDisplayed());
    }

    @Test
    public void addProductToCartTest() {
        login();
        ProductsPage pp = new ProductsPage(driver);
        pp.addProduct();

        Assert.assertTrue(pp.isCartBadgeVisible());
    }

    @Test
    public void removeProductFromCartTest() {
        login();
        ProductsPage pp = new ProductsPage(driver);
        pp.addProduct();
        pp.removeProduct();

        Assert.assertFalse(pp.isCartBadgeVisible());
    }

    @Test
    public void cartNavigationTest() {
        login();
        ProductsPage pp = new ProductsPage(driver);
        pp.addProduct();
        pp.openCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
    }
}