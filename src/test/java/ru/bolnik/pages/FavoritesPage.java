package ru.bolnik.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

// страница работы с Избранным
public class FavoritesPage {

    @Step("Открываем страницу Избранного")
    public void openFavoritesPage() {
        step("Кликаем по кнопке 'Избранное' в шапке сайта",
                () -> $("span").shouldHave(text("Избранное")).click());
    }

    @Step("Проверяем, что товар {productName} присутствует в Избранном")
    public void checkProductInFavorites(String productName) {
        step("Убеждаемся, что товар отображается на странице Избранного",
                () -> $$("a[data-meta-name='Snippet__title']")
                        .findBy(text(productName))
                        .shouldBe(visible));
    }

    @Step("Удаляем все товары из Избранного")
    public void removeProductsFromFavorites() {
        step("Удаляем все продукты из избранного", () -> {
            $$("button") // получаем все кнопки на странице
                    .findBy(text("Очистить список")) // ищем кнопку с текстом
                    .shouldBe(visible, enabled)
                    .click();
        });
    }

    @Step("Проверяем, что Избранное пустое")
    public void checkFavoritesIsEmpty() {
        step("Убеждаемся, что отображается сообщение 'В избранном нет товаров'", () -> {
            $$("span").findBy(text("В избранном нет товаров"))
                    .shouldBe(visible);
        });
       }
}
