package com.demoblaze;

import com.demoblaze.ui.CartPageObject;
import com.demoblaze.ui.NavigationUI;
import com.demoblaze.ui.ProductPageObject;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.demoblaze.CoreTest.FEATURE_ADD_PRODUCT_SHOPPING_CART;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.automation.remarks.junit5.Video;

@Feature(FEATURE_ADD_PRODUCT_SHOPPING_CART)
public class AddProductsToCartTests extends CoreTest {

    @DisplayName("User adds Sony product to the shopping cart")
    @Test
    @Video
    public void testAddSonyLaptopToCart() {
        NavigationUI navigationUI = new NavigationUI();

        navigationUI.openHomePage();
        navigationUI.openCategory("Laptops");

        ProductPageObject products = new ProductPageObject();
        products.openProductDetails("Sony vaio i5");
        products.addToCart();

        CartPageObject cart = new CartPageObject();

        String actualAlertText = cart.getConfirmationMessage();
        assertEquals("Product added", actualAlertText, "Alert text is: " + actualAlertText);
        cart.confirmProductWasAddedToCart();
    }

    @DisplayName("User adds Dell product to the shopping cart")
    @Test
    @Video
    public void testAddDellLaptopToCart() {
        NavigationUI navigationUI = new NavigationUI();

        navigationUI.openHomePage();
        navigationUI.openCategory("Laptops");

        ProductPageObject products = new ProductPageObject();
        products.openProductDetails("Dell i7 8gb");
        products.addToCart();

        CartPageObject cart = new CartPageObject();

        String actualAlertText = cart.getConfirmationMessage();
        assertEquals("Product added", actualAlertText, "Alert text is: " + actualAlertText);
        cart.confirmProductWasAddedToCart();
    }
}
