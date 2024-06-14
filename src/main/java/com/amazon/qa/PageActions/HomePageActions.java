package com.amazon.qa.PageActions;

import com.amazon.qa.Base.TestBase;
import com.amazon.qa.Pages.HomePage;
import com.amazon.qa.Pages.SignInPage;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePageActions extends HomePage {
    HomePage homePage;
    SignInPage signInPage;

    public HomePageActions() throws IOException {
        super();
    }

    public SignInPageActions ClickSignInLink() throws IOException {
        System.out.println(signInLink);
        signInLink.click();
        return new SignInPageActions();


    }
}
