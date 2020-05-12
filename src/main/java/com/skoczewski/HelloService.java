package com.skoczewski;

import java.util.Optional;

public class HelloService {
    static final String FALLBACK_NAME = "world";
    static final Lang FALLBACK_LANG = new Lang(1L, "Hello", "en");

    private LangRepository repository = new LangRepository();

    public HelloService() { }

    public HelloService(LangRepository repository) {
        this.repository = repository;
    }

    String prepareGreeting(String name, String langId) {
        var langIdNum = Optional.ofNullable(langId).map(Long::valueOf).orElse(FALLBACK_LANG.getId());
        var welcomeMsg = repository.findById(langIdNum).orElse(FALLBACK_LANG).getWelcomeMessage();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME + "!");
        return welcomeMsg + " " + nameToWelcome  ;
    }

    String prepareGreeting(String name) {
        return prepareGreeting(name, null);
    }
}
