package org.example;

import io.qameta.allure.Step;
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

    @Step("Добавление первого продукта в корзину")
    public WomenPage productOneAddToCart() {
        sleep(5000);
        productOneAddToCart.click();
        return this;
    }

    @Step("Добавление второго продукта в корзину")
    public WomenPage productTwoAddToCart() {
        sleep(5000);
        productTwoAddToCart.click();
        return this;
    }

    @Step("Оформить покупку")
    public OrderPage clickCheckout() {
        sleep(5000);
        checkout.click();
        return new OrderPage(driver);
    }

    @Step("Продолжить покупки")
    public WomenPage clickContinue() {
        sleep(5000);
        continueElement.click();
        return this;
    }
}
