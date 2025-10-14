package ru.bolnik.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import ru.bolnik.tests.base.TestBase;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Owner("Dima Bolnik")
@Disabled
public class UITests extends TestBase {

    @Test
    @Order(1)
    @DisplayName("CT-T13: Проверка отображения главных элементов главной страницы")
    public void checkMainElementsOnHomePageTest() {
        homePage.openPage();
        homePage.checkMainElements();
    }

    @Test
    @Order(2)
    @DisplayName("CT-T15: Проверка отображения информации о товаре на странице продукта")
    public void checkProductInfoOnProductPageTest() {
        homePage.openPage();
        homePage.searchProduct(config.searchQuery());
        homePage.openFirstProduct();

        productPage.checkProductInfo();
    }
}
