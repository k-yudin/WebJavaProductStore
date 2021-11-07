package com.demoblaze;

import com.demoblaze.ui.NavigationUI;
import com.demoblaze.ui.ProductPageObject;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.demoblaze.CoreTest.FEATURE_CATEGORIES_NAVIGATION;

@Feature(FEATURE_CATEGORIES_NAVIGATION)
public class NavigationTests extends CoreTest{

    @DisplayName("User navigates through product categories")
    @Test
    public void testUserCategoryNavigation() {
        NavigationUI navigationUI = new NavigationUI();
        ProductPageObject products = new ProductPageObject();

        navigationUI.openHomePage();
        navigationUI.openCategory("Phones");
        products.assertProductsCountShouldBe(7);

        navigationUI.openCategory("Laptops");
        products.assertProductsCountShouldBe(6);

        navigationUI.openCategory("Monitors");
        products.assertProductsCountShouldBe(2);
    }
}
