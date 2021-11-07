package com.demoblaze.ui;

import io.qameta.allure.Step;

public class CartPageObject extends MainPageObject {

    public static final String CART = "linkText:Cart";
    public static final String DELETE_PRODUCT_LINK = "xpath://tr[@class='success']//td[normalize-space()='%s']/../td/a['Delete']";
    public static final String PRODUCT = "xpath://td['%s']";
    public static final String TOTAL_PRICE = "xpath://h3[@id='totalp']";
    public static final String PLACE_ORDER_BUTTON = "xpath://button[normalize-space()='Place Order']";

    @Step("Get confirmation text from alert message")
    public String getConfirmationMessage() {
        return this.getAlertMessage();
    }

    @Step("Click to close confirmation alert")
    public void confirmProductWasAddedToCart() {
        this.switchToAlertAndAccept();
    }

    @Step("Go to the shopping cart")
    public void openShoppingCart() {
        this.waitForElementPresenceAndClick(CART);
    }

    @Step("Delete product {productName} from the cart")
    public void deleteProduct(String productName) {
        String locator = String.format(DELETE_PRODUCT_LINK, productName);
        this.waitForElementPresenceAndClick(locator);
    }

    @Step("Verify that product was deleted from the cart")
    public void assertProductWasDeleted(String productName) {
        String locator = String.format(PRODUCT, productName);
        this.waitForElementNotPresent(locator);
    }

    @Step("Get total price value from shopping cart")
    public String getTotalOrderPrice() {
        this.waitForElementPresence(TOTAL_PRICE);
        return this.getElementText(TOTAL_PRICE);
    }

    @Step("Click to place the order")
    public void placeOrder() {
        this.waitForElementPresenceAndClick(PLACE_ORDER_BUTTON);
    }
}
