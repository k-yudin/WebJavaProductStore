package com.demoblaze;

import com.demoblaze.helpers.Logger;
import com.demoblaze.ui.CartPageObject;
import com.demoblaze.ui.NavigationUI;
import com.demoblaze.ui.OrderPageObject;
import com.demoblaze.ui.ProductPageObject;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.demoblaze.CoreTest.FEATURE_PLACE_ORDER;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature(FEATURE_PLACE_ORDER)
public class PurchaseTests extends CoreTest {

    @DisplayName("User creates the order, order and total price are logged")
    @Test
    public void testCreateOrder() {
        NavigationUI navigationUI = new NavigationUI();

        navigationUI.openHomePage();
        navigationUI.openCategory("Laptops");

        ProductPageObject products = new ProductPageObject();
        products.openProductDetails("Sony vaio i5");
        products.addToCart();

        CartPageObject cart = new CartPageObject();
        cart.confirmProductWasAddedToCart();

        navigationUI.openHomePage();
        navigationUI.openCategory("Laptops");

        products.openProductDetails("Dell i7 8gb");
        products.addToCart();
        cart.confirmProductWasAddedToCart();

        String product = "Dell i7 8gb";
        cart.openShoppingCart();
        cart.deleteProduct(product);
        cart.assertProductWasDeleted(product);

        String cartValue = cart.getTotalOrderPrice();
        cart.placeOrder();

        OrderPageObject orderDetails = new OrderPageObject();
        orderDetails.assertTotalPriceEqualsTo(cartValue);
        orderDetails.specifyOrderDetails();
        orderDetails.confirmOrder();

        String orderId = orderDetails.getOrderId();
        String orderAmount = orderDetails.getOrderAmountValue();

        Logger.addOrderDetails(orderId, orderAmount);

        assertEquals(cartValue, orderAmount, "Order amount doesn't match!");
        orderDetails.closeOrderConfirmation();
    }
}
