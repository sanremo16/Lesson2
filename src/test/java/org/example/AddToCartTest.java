package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToCartTest {
    private WebDriver driver;
    private WebDriverWait driverWait;

    @BeforeAll
    static void setupDriver() {
        WebDriverManager.chromedriver().setup();
        /**System.setProperty(
                "webdriver.chrome.driver", "src/main/resources/chromedriver.exe"
        );
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);**/
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @Test
    public void loginTest() {
        OrderPage orderPage = new LoginPage(driver)
        .login("parfenova.ksenia@gmail.com", "101187")
        .clickWomen()
        .productOneAddToCart()
        .clickContinue()
        .productTwoAddToCart()
        .clickCheckout();

        Assertions.assertEquals(2, orderPage.getProducts().size());

        orderPage.deleteProducts();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
