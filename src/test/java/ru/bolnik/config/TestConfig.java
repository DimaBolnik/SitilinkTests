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

    @Key("browser")
    String browser();

    @Key("browser.size")
    String browserSize();

    @Key("page.load.strategy")
    String pageLoadStrategy();

    @Key("timeout")
    int timeout();

    @Key("search.query")
    String searchQuery();
}
