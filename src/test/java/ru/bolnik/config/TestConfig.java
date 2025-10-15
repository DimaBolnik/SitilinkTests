package ru.bolnik.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config.properties"})
public interface TestConfig extends Config {

    @Key("base.url")
    String baseUrl();

    @Key("user.email")
    String email();

    @Key("user.password")
    String password();

    @Key("name")
    String userName();

    @Key("browser")
    String browser();

    @Key("browser.size")
    String browserSize();

    @Key("page.load.strategy")
    String pageLoadStrategy();

    @Key("search.query")
    String searchQuery();

    // ❌ некорректные данные для негативной авторизации
    @Key("user.wrong.email")
    String wrongEmail();

    @Key("user.wrong.password")
    String wrongPassword();

    @Key("remote.url")
    String remoteUrl();

    @Key("remote")
    String remote();
}
