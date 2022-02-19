package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OrderPage extends BasePage {
    @FindBy(xpath = ".//*[@class='cart_product']")
    private List<WebElement> products;

    @FindBy(xpath = ".//*[@title='Delete']")
    private List<WebElement> deleteLinks;

    public OrderPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getProducts() {
        return products;
    }

    public void deleteProducts() {
        deleteLinks.stream().forEach(l -> l.click());
    }
}
