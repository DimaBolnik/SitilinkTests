package ru.bolnik.tests.base;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.bolnik.config.TestConfig;
import ru.bolnik.pages.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

    public static TestConfig config;

    protected HomePage homePage;
    protected ProductPage productPage;
    protected CartPage cartPage;
    protected LoginPage loginPage;
    protected CheckoutPage checkoutPage;
    protected FavoritesPage favoritesPage;

    @BeforeAll
    static void setupAll() {

        // Инициализация конфигурации через Owner
        config = ConfigFactory.create(TestConfig.class);

        // Настройки Selenide берутся из Owner
        // Значения могут быть переопределены через системные свойства (-D)
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
        Configuration.pageLoadStrategy = config.pageLoadStrategy();
      }
    @BeforeEach
    public void setUpPages() {
        homePage = new HomePage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        loginPage = new LoginPage();
        checkoutPage = new CheckoutPage();
        favoritesPage = new FavoritesPage();
    }


    @AfterEach
    public void closeBrowser() {
        closeWebDriver();
    }
}
