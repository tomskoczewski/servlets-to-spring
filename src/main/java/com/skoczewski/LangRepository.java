package com.skoczewski;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LangRepository {
    private List<Lang> languages = new ArrayList<>();

    public LangRepository() {
        languages.add(new Lang(1L, "Hello", "en"));
        languages.add(new Lang(2L, "Czesc", "pl"));
    }

    Optional<Lang> findById(Long id) {
        return languages.stream()
                .filter(lang -> lang.getId().equals(id))
                .findFirst();
    }
}
