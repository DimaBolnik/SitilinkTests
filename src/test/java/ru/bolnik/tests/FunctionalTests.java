package ru.bolnik.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import ru.bolnik.tests.base.TestBase;

@Owner("Dima Bolnik")
@Epic("Functional Tests")
@DisplayName("Functional Tests")
public class FunctionalTests extends TestBase {


    @Test
    @DisplayName("CT-T8: Изменение количества товара в корзине")
    public void changeProductQuantityInCartTest() {
        homePage.openPage();
        homePage.searchProduct(config.searchQuery());
        homePage.openFirstProduct();

        productPage.addToCart();

        cartPage.openCart();
        cartPage.increaseProductQuantity();
        cartPage.checkProductQuantityIsTwo();
    }

    @Test
    @DisplayName("CT-T9: Удаление товара из корзины")
    public void removeProductFromCartTest() {
        homePage.openPage();
        homePage.searchProduct(config.searchQuery());
        homePage.openFirstProduct();

        productPage.addToCart();

        cartPage.openCart();
        cartPage.clearCart();
        cartPage.checkCartIsEmpty();
    }

    @Test
    @DisplayName("CT-T10: Авторизация с некорректным логином/паролем")
    public void invalidLoginTest() {
        homePage.openPage();

        loginPage.clickLoginButton();
        loginPage.login(config.wrongEmail(), config.wrongPassword());
        loginPage.checkLoginError();
    }

    @Test
    @DisplayName("CT-T6: Добавление товара в избранное")
    public void addProductToFavoritesTest() {
        homePage.openPage();

        loginPage.clickLoginButton();
        loginPage.login(config.email(), config.password());

        homePage.searchProduct(config.searchQuery());
        homePage.openFirstProduct();

        productPage.addToFavorites();
        productPage.goToFavoritesPage();

        favoritesPage.checkProductInFavorites(config.searchQuery());
        favoritesPage.removeProductsFromFavorites();

    }
}
