package ru.bolnik.utils;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class AllureScreenshotTest {

    @Test
    public void takeAllureReportScreenshot() {
        Configuration.browser = "chrome";
        Configuration.headless = true; // чтобы не открывалось окно
        Configuration.timeout = 10000;

        open("http://localhost:8080/job/SitilinkTests/lastBuild/allure/"); // URL твоего отчета

        // Делаем скриншот всей страницы
        String  screenshot = screenshot("allure-summary"); // сохранится в target/screenshots/allure-summary.png
        System.out.println("Screenshot saved: " + screenshot);
    }
}
