package org.example.util;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name = "search inputs")
    public static Object[][] searchInputs() {
        return new Object[][] {
                { "Padaliak Iryna" },
                { "Kansas city tour" },
                { "Harry Potter and the Goblet of fire" }
        };
    }
}
