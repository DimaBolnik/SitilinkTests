package ru.bolnik.tests.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import ru.bolnik.config.TestConfig;

public class ApiTestBase {

    protected static TestConfig config;
    protected static RequestSpecification requestSpec;

    @BeforeAll
    static void setupAll() {
        // Инициализация конфигурации через Owner
        config = ConfigFactory.create(TestConfig.class);

        // Базовый URL для всех запросов API
        RestAssured.baseURI = config.baseUrl();

        // Создаём стандартный RequestSpecification для всех тестов
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(config.baseUrl())
                .setContentType("application/json")
                .build();

    }
}