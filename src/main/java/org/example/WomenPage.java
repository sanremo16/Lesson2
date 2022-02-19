package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenPage extends BasePage {
    @FindBy(xpath = ".//*[@data-id-product=1][@title='Add to cart']")
    private WebElement productOneAddToCart;

    @FindBy(xpath = ".//*[@data-id-product=2][@title='Add to cart']")
    private WebElement productTwoAddToCart;

    @FindBy(xpath = ".//*[@title='Proceed to checkout']")
    private WebElement checkout;

    @FindBy(xpath = ".//*[@title='Continue shopping']")
    private WebElement continueElement;

    public WomenPage(WebDriver driver) {
        super(driver);
    }

    public WomenPage productOneAddToCart() {
        sleep(5000);
        productOneAddToCart.click();
        return this;
    }

    public WomenPage productTwoAddToCart() {
        sleep(5000);
        productTwoAddToCart.click();
        return this;
    }

    public OrderPage clickCheckout() {
        sleep(5000);
        checkout.click();
        return new OrderPage(driver);
    }

    public WomenPage clickContinue() {
        sleep(5000);
        continueElement.click();
        return this;
    }
}
