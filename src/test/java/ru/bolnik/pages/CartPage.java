package ru.bolnik.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

// страница работы с Корзиной
public class CartPage {

    @Step("Открываем корзину")
    public void openCart() {
        step("Кликаем на иконку корзины", () -> $("div[data-meta-name='BasketButton']").click());
    }

    public void verifyProductInCart(String productName) {
        step("Проверяем, что товар в корзине: " + productName, () ->
                $$("a").findBy(text(productName))
                        .shouldBe(visible)
        );
    }

    @Step("Изменяем количество товара в корзине на {quantity}")
    public void changeQuantity(int quantity) {
        step("Вводим количество товара: " + quantity, () -> $(".cart-quantity-input").setValue(String.valueOf(quantity)));
    }

    @Step("Удаляем товар из корзины")
    public void removeProduct() {
        step("Нажимаем кнопку удаления товара", () -> $(".cart-remove-btn").click());
    }

    @Step("Нажимаем кнопку \"Перейти к оформлению\"")
    public void goToCheckout() {
        step("Кликаем на кнопку \"Перейти к оформлению\"",
                () -> $("button[title='Перейти к оформлению']").click());
    }

    @Step("Проверяем отображение корзины")
    public void checkCartVisible() {
        step("Убедимся, что корзина видна", () -> $(".cart-content").isDisplayed());
    }

    @Step("Увеличиваем количество товара в корзине на 1")
    public void increaseProductQuantity() {
        step("Кликаем по кнопке '+' для увеличения количества товара", () -> {
            $("button[data-meta-name='Count__button-plus']")
                    .shouldBe(visible)
                    .shouldBe(enabled)
                    .click();
        });
    }

    @Step("Проверяем, что количество товара изменилось на 2")
    public void checkProductQuantityIsTwo() {
        step("Убеждаемся, что поле количества товара имеет значение 2", () -> {
            $("input[data-meta-name='Count__input']")
                    .shouldBe(visible)
                    .shouldHave(value("2"));
        });
    }

    @Step("Очищаем корзину")
    public void clearCart() {
        sleep(1000);
        step("Скроллим страницу немного вниз", () -> {
            executeJavaScript("window.scrollBy(0, 500);"); // скролл на 500 пикселей
        });
        step("Удаляем все товары из корзины", () -> {
            $(byText("Очистить корзину")).closest("button").shouldBe(visible).click();
        });
    }

    @Step("Проверяем, что корзина пуста")
    public void checkCartIsEmpty() {
        step("Убеждаемся, что отображается сообщение 'В корзине нет товаров'", () -> {
            $$("span").findBy(text("В корзине нет товаров"))
                    .shouldBe(visible);
        });
    }
}
