package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "email")
    private WebElement inputLogin;

    @FindBy(id = "passwd")
    private WebElement inputPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement buttonSubmit;

    public LoginPage (WebDriver driver) {
        super(driver);
    }

    public LoginPage fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage fillPasswd(String passwd) {
        inputPassword.sendKeys(passwd);
        return this;
    }


    public MainPage login(String login, String pswd) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(pswd);
        buttonSubmit.click();
        return new MainPage(driver);
    }
}
