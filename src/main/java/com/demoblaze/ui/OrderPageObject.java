package com.demoblaze.ui;

import com.demoblaze.UserDetails;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderPageObject extends MainPageObject {

    public static final String ORDER_DETAILS = "xpath://div[@class='modal fade show']";
    public static final String TOTAL_ORDER_PRICE_LABEL = "xpath://label[normalize-space()='Total: %s']";
    public static final String PURCHASE_BUTTON = "xpath://button[normalize-space()='Purchase']";
    public static final String ORDER_CONFIRMATION = "xpath://p[@class='lead text-muted ']";
    public static final String OK_BUTTON = "xpath://button[normalize-space()='OK']";

    @Step("Verify that total price from order popover equals to the value from cart")
    public void assertTotalPriceEqualsTo(String priceLabel) {
        this.waitForElementPresence(ORDER_DETAILS);

        String locator = String.format(TOTAL_ORDER_PRICE_LABEL, priceLabel);
        this.waitForElementPresence(locator);
    }

    @Step("Fill in order details")
    public void specifyOrderDetails() {
        this.waitForElementPresence(ORDER_DETAILS);
        this.waitForElementPresenceAndSendKeys(UserDetails.USER_NAME, "John");
        this.waitForElementPresenceAndSendKeys(UserDetails.USER_COUNTRY, "US");
        this.waitForElementPresenceAndSendKeys(UserDetails.USER_CITY, "New York");
        this.waitForElementPresenceAndSendKeys(UserDetails.USER_CARD_NUMBER, "5350287612345468");
        this.waitForElementPresenceAndSendKeys(UserDetails.USER_CARD_MONTH, "05");
        this.waitForElementPresenceAndSendKeys(UserDetails.USER_CARD_YEAR, "2025");
    }

    @Step("Click on purchase button")
    public void confirmOrder() {
        this.waitForElementPresenceAndClick(PURCHASE_BUTTON);
    }

    @Step("Get order id")
    public String getOrderId() { return this.getOrderConfirmationDetails().get(0); }

    @Step("Get order total price")
    public String getOrderAmountValue() { return this.getOrderConfirmationDetails().get(1); }

    @Step("Click on 'OK' button to close order confirmation")
    public void closeOrderConfirmation() {
        this.waitForElementPresenceAndClick(OK_BUTTON);
    }

    private ArrayList<String> getOrderConfirmationDetails() {
        this.waitForElementPresence(ORDER_CONFIRMATION);
        String orderInfo = this.getElementText(ORDER_CONFIRMATION);

        ArrayList<String> arr = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(orderInfo);
        while(matcher.find()) {
            arr.add(matcher.group());
        }
        return arr;
    }
}
