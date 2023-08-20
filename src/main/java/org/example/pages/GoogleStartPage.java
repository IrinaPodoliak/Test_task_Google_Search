package org.example.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static org.example.util.TextData.*;

public class GoogleStartPage {
    private SelenideElement searchInput = $("//textarea[@type='search']");
    private SelenideElement pageTitle = $("//title");
    @Step("Open page url")
    public void openUrl(String url) {
        open(url);
    }

    @Step("Perform search with search request")
    public GoogleResultPage performSearch(String searchRequest) {
        searchInput.click();
        searchInput.sendKeys(searchRequest);
        searchInput.pressEnter();
        return new GoogleResultPage();
    }


    @Step("Check if search tooltip appears after hovering search input")
    public void isSearchTooltipPresent() {
        actions().moveToElement(searchInput).perform();
        searchInput.shouldHave(Condition.attribute("title", SEARCH_TOOLTIP_TEXT.getData()));
    }

    @Step("Check if user is redirected on start google page")
    public void checkStartPageRedirection() {
        pageTitle.shouldHave(Condition.text(GOOGLE_TEXT.getData()));
    }

}
