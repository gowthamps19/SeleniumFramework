package com.amazon.qa.TestCases;

import com.amazon.qa.Base.TestBase;
import com.amazon.qa.PageActions.HomePageActions;
import com.amazon.qa.PageActions.SignInPageActions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignInPageTest extends TestBase {
    SignInPageActions signInPageActions;
    HomePageActions homePageActions;

    public SignInPageTest() throws IOException {

    }

    @BeforeTest
    public void setup() throws IOException {
        initializer();
        signInPageActions = new SignInPageActions();
        homePageActions= new HomePageActions();
        homePageActions.ClickSignInLink();
    }

    @Test(priority = 1)
    public void validateIncorrectEmail() {
        signInPageActions.enterUserName(prop.getProperty("emptyUserName"));
        signInPageActions.clickContinue();
        boolean status = signInPageActions.incorrectEmail();
        Assert.assertTrue(status);
    }
    @Test(priority = 2)
    public void login(){
        signInPageActions.enterUserName(prop.getProperty("userName"));
        signInPageActions.clickContinue();
        signInPageActions.enterPassword();
        signInPageActions.clickSignInButton();
    }
    @AfterTest
    public  void tearDown(){
        driver.quit();
    }
}
