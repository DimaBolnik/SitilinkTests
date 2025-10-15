package ru.bolnik.tests.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.MutableCapabilities;
import ru.bolnik.config.TestConfig;
import ru.bolnik.pages.*;

import java.util.HashMap;
import java.util.Map;

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

        // Загружаем конфигурацию из config.properties (можно переопределять через -D)
        config = ConfigFactory.create(TestConfig.class, System.getProperties());

        // Основные настройки Selenide
        Configuration.baseUrl = config.baseUrl();
        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
        Configuration.pageLoadStrategy = config.pageLoadStrategy();

        // Проверяем, включён ли удалённый запуск
        if ("on".equalsIgnoreCase(config.remote())) {
            Configuration.remote = config.remoteUrl(); // берём URL Selenoid из properties

            // 💻 capabilities для удалённого запуска
            MutableCapabilities capabilities = new MutableCapabilities();
            capabilities.setCapability("browserName", config.browser());

            Map<String, Object> selenoidOptions = new HashMap<>();
            selenoidOptions.put("enableVNC", true);
            selenoidOptions.put("enableVideo", true);
            capabilities.setCapability("selenoid:options", selenoidOptions);

            Configuration.browserCapabilities = capabilities;
        }

        // Подключаем Allure listener
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide()
                        .screenshots(true)
                        .savePageSource(true)
                        .includeSelenideSteps(true)
        );
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
