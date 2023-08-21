package org.example.pages;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.example.util.TextData.*;

public class GoogleStartPage {
    private SelenideElement searchInput = $(byXpath("//textarea[@type='search']"));
    private SelenideElement pageTitle = $(byXpath("//title"));
    private SelenideElement searchButton = $(byXpath("//input[@role='button'][1]"));
    private SelenideElement acceptCookiesButton = $(byXpath("//button[div[contains(normalize-space(), 'Accept all')]]"));
    @Step("Open page url")
    public GoogleStartPage openStartPage() {
        open(GOOGLE_START_URL.getData());
        if (acceptCookiesButton.exists()) {
            acceptCookies();
        }
        return this;
    }

    @Step("Accept browser cookies")
    public GoogleStartPage acceptCookies() {
        acceptCookiesButton.shouldBe(Condition.visible).click();
        return this;
    }

    @Step("Perform search with search request")
    public GoogleResultPage performSearch(String searchRequest) {
        searchInput.click();
        searchInput.val(searchRequest);
        Selenide.executeJavaScript("arguments[0].click();", searchButton);
        return new GoogleResultPage();
    }


    @Step("Check if search tooltip appears after hovering search input")
    public boolean isSearchTooltipPresent() {
        actions().moveToElement(searchInput).perform();
        return searchInput.shouldHave(Condition.attribute("title", SEARCH_TOOLTIP_TEXT.getData())).exists();
    }

    @Step("Check if user is redirected on start google page")
    public boolean checkStartPageRedirection() {
        return pageTitle.shouldHave(Condition.innerText(GOOGLE_TEXT.getData())).exists();
    }

}
