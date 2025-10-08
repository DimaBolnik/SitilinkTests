package ru.bolnik.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static ru.bolnik.config.TestBase.config;

// страница работы со страницей Логина
public class LoginPage {

    @Step("Авторизация пользователя с email {email} и паролем {password}")
    public void login(String email, String password) {
        step("Вводим email: " + email, () -> $("#login").setValue(email));
        step("Вводим пароль: " + password, () -> $("#password").setValue(password));
        step("Нажимаем кнопку 'Войти'", () -> $("#loginBtn").click());
    }

    @Step("Проверка сообщения об ошибке при некорректной авторизации")
    public void checkLoginError() {
        step("Убедиться, что появилось сообщение об ошибке", () -> $(".login-error").shouldBe(visible));
    }


    @Step("Авторизация с дефолтным пользователем из TestConfig")
    public void loginDefaultUser() {
        login(config.email(), config.password());
    }
}
