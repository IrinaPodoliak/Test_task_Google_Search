package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class GoogleResultPage extends GoogleStartPage {

    private SelenideElement pageTitle = $("//title");
    private SelenideElement searchResults = $("//div[@id='res']");
    private SelenideElement leftGoogleLogo = $("//div[contains(@class, 'logo')]");

    @Step("Check if page title includes search text")
    public void checkTitleIncludesSearch(String searchText) {
        pageTitle.shouldHave(Condition.text(searchText));
    }

    @Step("Check if user see results section with search results")
    public void checkResultsSection() {
        searchResults.shouldBe(Condition.visible);
    }

    @Step("Check whole search functionality")
    public void checkResultPageRedirection(String searchText) {
        checkResultsSection();
        checkTitleIncludesSearch(searchText);
    }

    public void checkLeftGoogleLogoFunctionality() {
        leftGoogleLogo.click();
        searchResults.shouldNotBe(Condition.visible);
        checkStartPageRedirection();

    }
}
