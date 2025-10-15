package ru.bolnik.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.bolnik.tests.base.ApiTestBase;

import static io.restassured.RestAssured.given;

@Owner("Dima Bolnik")
@Epic("API Tests")
@DisplayName("API Tests")
public class ApiTests extends ApiTestBase {

    @Test
    @DisplayName("CT-API1: Проверка, что главная страница Citilink возвращает статус 200")
    public void checkHomePageIsAvailable() {
        given()
                .spec(requestSpec)
                .when()
                .get("/")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("CT-API2: Проверка, что несуществующая страница возвращает 404")
    public void checkNotFoundPageReturns404() {
        given()
                .spec(requestSpec)
                .when()
                .get("/nonexistent-page-12345")
                .then()
                .statusCode(404);
    }
}
