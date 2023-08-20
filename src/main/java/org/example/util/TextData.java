package org.example.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TextData {
    GOOGLE_TEXT("Google"),
    SEARCH_TOOLTIP_TEXT("Search");

    private final String data;
}
