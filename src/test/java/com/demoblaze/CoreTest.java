package com.demoblaze;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoblaze.configs.EnvironmentConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class CoreTest {

    public static final String FEATURE_CATEGORIES_NAVIGATION = "Categories navigation";
    public static final String FEATURE_ADD_PRODUCT_SHOPPING_CART = "Placing product in the shopping cart";
    public static final String FEATURE_REMOVE_PRODUCT_SHOPPING_CART = "Removing product from the shopping cart";
    public static final String FEATURE_PLACE_ORDER = "Creating order";

    private static Boolean isAllureResultFolderClear = false;

    @BeforeAll
    protected static void setUp() {
        setUpBrowserConfiguration();
        setupAllureReports();
        clearAllureResults();
    }

    @AfterAll
    protected static void tearDown() {
        closeWebDriver();
    }

    protected static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(false)
        );
    }

    protected static void setUpBrowserConfiguration() {
        Configuration.browser = EnvironmentConfig.getBrowser();
        Configuration.browserSize = "1920x1080";
        if (EnvironmentConfig.getHost().equals("MOON_CLOUD")) {
            Configuration.remote = EnvironmentConfig.getRemoteURL();
        }
    }

    private static void clearAllureResults() {
        File resultsFolder = new File("allure-results");

        if (isAllureResultFolderClear) {
            return;
        }

        if(resultsFolder.exists()) {
            for(File file : resultsFolder.listFiles()) {
                file.delete();
            }

            setResultFolderClear();
        }
    }

    private static void setResultFolderClear() {
        isAllureResultFolderClear = true;
    }
}
