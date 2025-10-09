package ru.bolnik.pages;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static ru.bolnik.tests.base.TestBase.config;

// страница работы с Домашней страницей
public class HomePage {

    @Step("Открываем главную страницу Citilink")
    public void openPage() {
        step("Открываем базовый URL: " + config.baseUrl(),
                () -> Selenide.open(config.baseUrl()));
    }

    @Step("Ищем товар: {productName}")
    public void searchProduct(String productName) {
        step("Вводим название товара в поле поиска и нажимаем enter",
                () -> $("input[type='search'][name='text']")
                        .setValue(productName))
                .pressEnter();
    }

    public void verifyFirstSearchResultContains(String expectedText) {
        step("Проверяем, что первый результат содержит текст поиска: " + expectedText, () -> {
            $$("a[data-meta-name='Snippet__title']")
                    .first()
                    .shouldBe(visible)
                    .shouldHave(text(expectedText));
        });
    }

    @Step("Открываем первую карточку товара из результатов поиска")
    public void openFirstProduct() {
        step("Кликаем на первую карточку товара",
                () -> $("a[data-meta-name='Snippet__title']").click());
    }

    @Step("Проверяем отображение главных элементов главной страницы")
    public void checkMainElements() {
        step("Проверяем логотип",
                () -> $("[data-meta-name='Logo']").shouldBe(visible));
        step("Проверяем поле поиска",
                () -> $("[data-meta-name='HeaderBottom__search']").shouldBe(visible));
        step("Проверяем корзину",
                () -> $("[data-meta-name='BasketButton']").shouldBe(visible));
        step("Проверяем кнопку входа",
                () -> $("[data-meta-name='UserButtonContainer']").shouldBe(visible));
    }

}
