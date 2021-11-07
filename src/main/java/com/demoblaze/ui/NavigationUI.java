package com.demoblaze.ui;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class NavigationUI extends MainPageObject {

    public static final String HOME_PAGE = "https://www.demoblaze.com/index.html";
    public static final String CATEGORY = "linkText:%s";

    @Step("Open Home page")
    public void openHomePage() {
        open(HOME_PAGE);
    }

    @Step("Navigate to product category: {categoryName}")
    public void openCategory(String categoryName) {
        String locator = String.format(CATEGORY, categoryName);
        this.waitForElementPresenceAndClick(locator);
    }
}
