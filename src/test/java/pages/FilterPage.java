package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FilterPage {

    WebDriver driver;

    By filterDropdown = By.className("product_sort_container");

    public FilterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFilter(String filterText) {
        new Select(driver.findElement(filterDropdown))
                .selectByVisibleText(filterText);
    }
}