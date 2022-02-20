package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@Story("Проверка корзины")
public class AddToCartTest {
    private EventFiringWebDriver driver;
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
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CustomLogger());
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    @Test
    @Description("Тест добавления товаров в корзину")
    @TmsLink("234")
    public void addToCartTest() {
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
        // Вывод всех ошибок браузера после каждого теста
        LogEntries browserLogs = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();

        if (allLogRows.size() > 0 ) {
        }

        driver.quit();
    }

}
