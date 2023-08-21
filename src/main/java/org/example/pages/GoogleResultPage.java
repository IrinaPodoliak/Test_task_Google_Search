package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class GoogleResultPage extends GoogleStartPage {

    private SelenideElement pageTitle = $(byXpath("//title"));
    private SelenideElement searchResults = $(byXpath("//div[@id='res']"));
    private SelenideElement leftGoogleLogo = $(byXpath("//div[contains(@class, 'logo')]"));

    @Step("Check if page title includes search text")
    public boolean checkTitleIncludesSearch(String searchText) {
        return pageTitle.shouldHave(Condition.innerText(searchText), Duration.ofSeconds(3)).exists();
    }

    @Step("Check if user see results section with search results")
    public boolean checkResultsSection() {
        return searchResults.shouldBe(Condition.visible).exists();
    }

    @Step("Check whole search functionality")
    public boolean checkResultPageRedirection(String searchText) {
       return checkResultsSection() && checkTitleIncludesSearch(searchText);
    }

    @Step("Check if user is redirected to Google start page after clicking left logo on Results page and see no search results")
    public boolean checkLeftGoogleLogoFunctionality() {
        leftGoogleLogo.click();
        return searchResults.shouldNotBe(Condition.visible).exists() && checkStartPageRedirection();
    }
}
