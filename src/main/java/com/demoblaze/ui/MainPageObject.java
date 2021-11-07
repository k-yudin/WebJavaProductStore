package com.demoblaze.ui;

import org.openqa.selenium.By;

import java.util.regex.Pattern;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class MainPageObject {

    public void waitForElementPresence(String locator) {
        By by = this.getLocatorByString(locator);
        $(by).should(appear);
    }

    public void waitForElementNotPresent(String locator) {
        By by = this.getLocatorByString(locator);
        $(by).should(disappear);
    }

    public void waitForElementPresenceAndClick(String locator) {
        By by = this.getLocatorByString(locator);
        $(by).should(appear).click();
    }

    public void waitForElementPresenceAndSendKeys(String locator, String input) {
        By by = this.getLocatorByString(locator);
            $(by).should(appear).sendKeys(input);
    }

    public String getElementText(String locator) {
        By by = this.getLocatorByString(locator);
        return $(by).text();
    }

    public void switchToAlertAndAccept() {
        webdriver().driver().switchTo().alert().accept();
    }

    public String getAlertMessage() {
        return webdriver().driver().switchTo().alert().getText();
    }

    public void assertElementsCount(String locator, int count) {
        By by = this.getLocatorByString(locator);
        $$(by).shouldHave(size(count));
    }

    private By getLocatorByString(String locatorWithType)
    {
        String[] explodedLocator = locatorWithType.split(Pattern.quote(":"), 2);
        String byType = explodedLocator[0];
        String locator = explodedLocator[1];

        if (byType.equals("xpath"))
        {
            return By.xpath(locator);
        }
        else if (byType.equals("id"))
        {
            return By.id(locator);
        }
        else if (byType.equals("linkText"))
        {
            return By.linkText(locator);
        }
        else
            throw new IllegalArgumentException("Cannot get type of locator " + locatorWithType);
    }
}
