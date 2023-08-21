package org.example;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.example.pages.GoogleStartPage;
import org.example.util.TestDataProvider;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class GoogleSearchTest {

    GoogleStartPage startPage = new GoogleStartPage();

    @Step("Set up environment")
    @BeforeMethod
    public void setup() {
        Configuration.browserSize = "1920x1080";
        startPage.openStartPage();
    }

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "search inputs")
    public void checkMainPageSearch(String searchInput) {
        assertTrue(startPage.performSearch(searchInput)
                        .checkResultPageRedirection(searchInput),
                "Google search doesn't work correctly for input: " + searchInput);
    }

    @Test
    public void checkSearchTooltipPresence() {
        assertTrue(startPage.isSearchTooltipPresent(),
                "Tooltip is not shown under the search field");
    }

    @Test
    public void checkLeftLogoFunctionality() {
        String testSearchRequest = "Test search request";
        assertTrue(startPage.performSearch(testSearchRequest).checkLeftGoogleLogoFunctionality(),
                "Left google logo doesn't redirect user to the main page ");
    }
}
