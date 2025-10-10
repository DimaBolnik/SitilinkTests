package ru.bolnik.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import ru.bolnik.tests.base.TestBase;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Owner("Dima Bolnik")
public class FunctionalTests extends TestBase {


    @Test
    @Order(1)
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
    @Order(2)
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
    @Order(3)
    @DisplayName("CT-T10: Авторизация с некорректным логином/паролем")
    public void invalidLoginTest() {
        homePage.openPage();

        loginPage.clickLoginButton();
        loginPage.login(config.wrongEmail(), config.wrongPassword());
        loginPage.checkLoginError();
    }

    @Test
    @Order(4)
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
