package ru.bolnik.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import ru.bolnik.tests.base.TestBase;

@Owner("Dima Bolnik")
@Epic("Smoke Tests")
@DisplayName("Smoke Tests")
public class SmokeTests extends TestBase {

    @Test
    @DisplayName("CT-T1: Поиск товара в каталоге")
    public void searchProductTest() {
        homePage.openPage();
        homePage.searchProduct(config.searchQuery());
        homePage.verifyFirstSearchResultContains(config.searchQuery());
    }

    @Test
    @DisplayName("CT-T2: Добавление товара в корзину")
    public void addToCartTest() {
        homePage.openPage();
        homePage.searchProduct(config.searchQuery());
        homePage.openFirstProduct();

        productPage.addToCart();

        cartPage.openCart();
        cartPage.verifyProductInCart(config.searchQuery());
    }

    @Test
    @DisplayName("CT-T3: Авторизация пользователя")
    public void loginTest() {
        homePage.openPage();

        loginPage.clickLoginButton();
        loginPage.login(config.email(), config.password());
        loginPage.verifyUserName(config.userName());
    }

    @Test
    @DisplayName("CT-T5: Оформление заказа без оплаты")
    public void checkoutTest() {
        homePage.openPage();

        loginPage.clickLoginButton();
        loginPage.login(config.email(), config.password());

        homePage.searchProduct(config.searchQuery());
        homePage.openFirstProduct();

        productPage.addToCart();

        cartPage.openCart();
        cartPage.goToCheckout();

        checkoutPage.checkSubmitButtonVisibleAndActive();
        checkoutPage.returnToCart();

        cartPage.clearCart();
    }
}
