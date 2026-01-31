package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    By title = By.className("title");

    // Cart
    By addToCart = By.id("add-to-cart-sauce-labs-backpack");
    By removeFromCart = By.id("remove-sauce-labs-backpack");
    By cartBadge = By.className("shopping_cart_badge");
    By cartIcon = By.className("shopping_cart_link");

    // Menu
    By menuBtn = By.id("react-burger-menu-btn");
    By logoutLink = By.id("logout_sidebar_link");
    By aboutLink = By.id("about_sidebar_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductsPageDisplayed() {
        return driver.findElement(title).isDisplayed();
    }

    public String getTitleText() {
        return driver.findElement(title).getText();
    }

    public void addProduct() {
        driver.findElement(addToCart).click();
    }

    public void removeProduct() {
        driver.findElement(removeFromCart).click();
    }

    public boolean isCartBadgeVisible() {
        return driver.findElements(cartBadge).size() > 0;
    }

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public void openMenu() {
        driver.findElement(menuBtn).click();
    }

    public void logout() {
        driver.findElement(logoutLink).click();
    }

    public void openAbout() {
        driver.findElement(aboutLink).click();
    }
}