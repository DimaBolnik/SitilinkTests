package ru.bolnik.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.bolnik.config.TestBase.config;

// страница работы с Домашней страницей
public class HomePage {

    @Step("Открываем главную страницу Citilink")
    public HomePage openPage() {
        step("Открываем базовый URL: " + config.baseUrl(), () -> {
            Selenide.open(config.baseUrl());
        });
        return this;
    }

    @Step("Ищем товар: {productName}")
    public HomePage searchProduct(String productName) {
        step("Вводим название товара в поле поиска", () -> $("[name='search']").setValue(productName));
        step("Нажимаем Enter для поиска", () -> $("[name='search']").pressEnter());
        return this;
    }

    @Step("Открываем первую карточку товара из результатов поиска")
    public void openFirstProduct() {
        step("Кликаем на первую карточку товара", () -> $(".product-card__name").click());
    }

}
