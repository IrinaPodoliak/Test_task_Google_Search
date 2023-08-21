package org.example.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TextData {
    GOOGLE_TEXT("Google"),
    SEARCH_TOOLTIP_TEXT("Search"),
    GOOGLE_START_URL("https://www.google.com/?hl=en");

    private final String data;
}
