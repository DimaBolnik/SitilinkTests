package ru.bolnik.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public static TestConfig config;

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
        Configuration.timeout = config.timeout();
    }
}
