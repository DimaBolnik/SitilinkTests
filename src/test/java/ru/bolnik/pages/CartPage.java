package ru.bolnik.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

// страница работы с Корзиной
public class CartPage {

    @Step("Открываем корзину")
    public void openCart() {
        step("Кликаем на иконку корзины", () -> $(".cart-icon").click());
    }

    @Step("Изменяем количество товара в корзине на {quantity}")
    public void changeQuantity(int quantity) {
        step("Вводим количество товара: " + quantity, () -> $(".cart-quantity-input").setValue(String.valueOf(quantity)));
    }

    @Step("Удаляем товар из корзины")
    public void removeProduct() {
        step("Нажимаем кнопку удаления товара", () -> $(".cart-remove-btn").click());
    }

    @Step("Проверяем отображение корзины")
    public void checkCartVisible() {
        step("Убедимся, что корзина видна", () -> $(".cart-content").isDisplayed());
    }
}
