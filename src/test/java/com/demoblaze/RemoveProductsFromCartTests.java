package com.demoblaze;

import com.demoblaze.ui.CartPageObject;
import com.demoblaze.ui.NavigationUI;
import com.demoblaze.ui.ProductPageObject;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.demoblaze.CoreTest.FEATURE_REMOVE_PRODUCT_SHOPPING_CART;

@Feature(FEATURE_REMOVE_PRODUCT_SHOPPING_CART)
public class RemoveProductsFromCartTests extends CoreTest {

    @DisplayName("User removes a product from the shopping cart")
    @Test
    public void testRemoveProductFromCart() {
        NavigationUI navigationUI = new NavigationUI();

        navigationUI.openHomePage();
        navigationUI.openCategory("Laptops");

        String product = "Dell i7 8gb";
        ProductPageObject products = new ProductPageObject();
        products.openProductDetails(product);
        products.addToCart();

        CartPageObject cart = new CartPageObject();
        cart.confirmProductWasAddedToCart();
        cart.openShoppingCart();
        cart.deleteProduct(product);
        cart.assertProductWasDeleted(product);
    }
}
