package ru.bolnik.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

// страница работы со страницей товара
public class ProductPage {

    @Step("Добавляем товар в корзину")
    public void addToCart() {
        step("Нажимаем кнопку 'Добавить в корзину'",
                () -> $("button[data-meta-name='BasketDesktopButton']").click());
    }

    @Step("Добавляем товар в избранное")
    public void addToFavorites() {
        step("Нажимаем кнопку 'В избранное'",
                () -> $("button[data-meta-name='Snippet__wishlist-button']").click());
    }

    @Step("Проверяем наличие товара на странице")
    public void checkProductInfo() {
        step("Проверяем название товара",
                () -> $("[data-meta-name='ProductHeaderLayout__title']").shouldBe(visible));
        step("Проверяем цену",
                () -> $("[data-meta-name='PriceBlock__price']").shouldBe(visible));
        step("Проверяем характеристики",
                () -> $("[data-meta-name='ProductHeaderContentLayout__second-column']").shouldBe(visible));
    }

    @Step("Открываем продукт по индексу {index} в списке результатов поиска")
    public void openProductByIndex(int index) {
        step("Кликаем на карточку продукта с индексом " + index,
                () -> $(".product-card__name", index).click());
    }

    @Step("Переходим на страницу 'Избранное'")
    public void goToFavoritesPage() {
        step("Кликаем по кнопке 'Избранное' в шапке сайта", () -> {
            $("div[data-meta-name='WishlistButton']").shouldBe(visible, enabled).click();
        });
    }
}
