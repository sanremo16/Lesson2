package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(linkText = "Women")
    private WebElement womenLink;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public WomenPage clickWomen() {
        womenLink.click();
        return new WomenPage(driver);
    }
}
