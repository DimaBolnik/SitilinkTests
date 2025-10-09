package ru.bolnik.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

// страница оформления заказа
public class CheckoutPage {

    @Step("Нажимаем кнопку 'Оформить заказ'")
    public void submitOrder() {
        step("Проверяем видимость и активность кнопки 'Оформить заказ' и кликаем",
                () -> $("button[data-meta-name='SubmitButton']")
                        .shouldBe(visible)
                        .shouldHave(attribute("data-meta-disabled", "false"))
                        .click());
    }

    @Step("Проверяем видимость кнопки 'Оформить заказ'")
    public void checkSubmitButtonVisibleAndActive() {
        step("Кнопка 'Оформить заказ' видима и активна",
                () -> $("button[data-meta-name='SubmitButton']")
                        .shouldBe(visible)
                        .shouldHave(attribute("data-meta-disabled", "false")));
    }

    @Step("Возврат в корзину")
    public void returnToCart() {
        step("Кликаем на элемент 'Вернуться в корзину'",
                () -> $$("span, a").findBy(text("Вернуться в корзину")).click());
    }

}
