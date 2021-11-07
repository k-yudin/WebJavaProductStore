package com.demoblaze.ui;

import io.qameta.allure.Step;

public class ProductPageObject extends MainPageObject {

    public static final String PRODUCT_LIST_ITEM = "id:article";
    public static final String PRODUCT_ITEM = "linkText:%s";
    public static final String ADD_TO_CART_BUTTON = "linkText:Add to cart";

    @Step("Click to open product details for: {productName}")
    public void openProductDetails(String productName) {
        String locator = String.format(PRODUCT_ITEM, productName);
        this.waitForElementPresenceAndClick(locator);
    }

    @Step("Click to add to the shopping cart")
    public void addToCart() {
        this.waitForElementPresenceAndClick(ADD_TO_CART_BUTTON);
    }

    @Step("Verify products count on the page equals to: {expectedProductCount}")
    public void assertProductsCountShouldBe(int expectedProductCount) {
        this.assertElementsCount(PRODUCT_LIST_ITEM, expectedProductCount);
    }
}
