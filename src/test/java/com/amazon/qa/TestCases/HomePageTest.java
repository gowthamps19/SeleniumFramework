package com.amazon.qa.TestCases;

import com.amazon.qa.Base.TestBase;
import com.amazon.qa.PageActions.HomePageActions;
import com.amazon.qa.Pages.SignInPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends TestBase {
    HomePageActions homePageActions;
    SignInPage signInPage;

    public HomePageTest() throws IOException {
        super();
    }

    @BeforeTest
    public void setup() throws IOException {
        initializer();
        homePageActions = new HomePageActions();
    }
    @Test
    public void ClickSignInLinkTest() throws IOException {
        System.out.println();
        homePageActions.ClickSignInLink();
    }
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}

