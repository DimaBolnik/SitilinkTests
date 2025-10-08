package ru.bolnik.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

// страница работы со страницей товара
public class ProductPage {

    @Step("Добавляем товар в корзину")
    public void addToCart() {
        step("Нажимаем кнопку 'В корзину'", () -> $("#buy-button").click());
    }

    @Step("Добавляем товар в избранное")
    public void addToFavorites() {
        step("Нажимаем кнопку 'В избранное'", () -> $(".favorite-btn").click());
    }

    @Step("Проверяем наличие товара на странице")
    public void checkProductInfo() {
        step("Проверяем название товара", () -> $(".product-title").shouldBe(visible));
        step("Проверяем цену", () -> $(".product-price").shouldBe(visible));
        step("Проверяем характеристики", () -> $(".product-characteristics").shouldBe(visible));
    }

    @Step("Открываем продукт по индексу {index} в списке результатов поиска")
    public void openProductByIndex(int index) {
        step("Кликаем на карточку продукта с индексом " + index,
                () -> $(".product-card__name", index).click());
    }
}
