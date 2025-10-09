package ru.bolnik.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static ru.bolnik.tests.base.TestBase.config;

// страница работы со страницей Логина
public class LoginPage {

    @Step("Авторизация пользователя с email {email} и паролем {password}")
    public void login(String email, String password) {
        step("Кликаем на кнопку 'Войти по паролю'",
                () -> $$("button").findBy(text("Войти по паролю")).click());

        step("Вводим email: " + email, () -> $("input[type='email']").setValue(email));
        step("Вводим пароль: " + password, () -> $("input[type='password']").setValue(password));
        step("Нажимаем кнопку 'Войти' в форме авторизации",
                () -> $$("button").findBy(text("Войти")).shouldBe(visible, enabled).click());

    }

    @Step("Проверка сообщения об ошибке при некорректной авторизации")
    public void checkLoginError() {
        step("Убедиться, что отображается сообщение 'К сожалению, не удалось выполнить вход в учетную запись...'", () -> {
            $$("span, div, p") // ищем во всех распространённых тегах
                    .findBy(text("К сожалению, не удалось выполнить вход в учетную запись. Пожалуйста, попробуйте еще раз."))
                    .shouldBe(visible);
        });
    }


    @Step("Авторизация с дефолтным пользователем из TestConfig")
    public void loginDefaultUser() {
        login(config.email(), config.password());
    }

    @Step("Нажимаем кнопку \"Войти\" для авторизации")
    public void clickLoginButton() {
        step("Кликаем на кнопку 'Войти'",
                () -> $("[data-meta-name='UserButtonContainer']").click());
    }

    public void verifyUserName(String expectedName) {
        step("Проверяем, что отображается имя пользователя: " + expectedName, () ->
                $("div[data-meta-count='0'] span")
                        .shouldBe(visible)
                        .shouldHave(text(expectedName))
        );
    }
}
