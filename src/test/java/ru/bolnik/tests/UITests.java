package ru.bolnik.tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import ru.bolnik.tests.base.TestBase;

@Owner("Dima Bolnik")
@Epic("UI Tests")
@DisplayName("UI Tests")
public class UITests extends TestBase {

    @Test
    @DisplayName("CT-T13: Проверка отображения главных элементов главной страницы")
    public void checkMainElementsOnHomePageTest() {
        homePage.openPage();
        homePage.checkMainElements();
    }

    @Test
    @DisplayName("CT-T15: Проверка отображения информации о товаре на странице продукта")
    public void checkProductInfoOnProductPageTest() {
        homePage.openPage();
        homePage.searchProduct(config.searchQuery());
        homePage.openFirstProduct();

        productPage.checkProductInfo();
    }
}
