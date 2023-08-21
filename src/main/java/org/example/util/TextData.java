package org.example.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TextData {
    GOOGLE_TEXT("Google"),
    SEARCH_TOOLTIP_EN_TEXT("Search"),
    SEARCH_TOOLTIP_RU_TEXT("Поиск"),
    GOOGLE_START_URL("https://www.google.com"),
    RUSSIAN("ru"),
    ENGLISH("en");


    private final String data;
}
