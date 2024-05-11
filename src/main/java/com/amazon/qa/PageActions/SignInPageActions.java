package com.amazon.qa.PageActions;

import com.amazon.qa.Base.TestBase;
import com.amazon.qa.Pages.SignInPage;

import java.io.IOException;

public class SignInPageActions extends SignInPage {
    public SignInPageActions() throws IOException {
    }

    public String getSignInPageTitle(){
       return driver.getTitle();
    }
    public void enterUserName(String un){
    emailName.sendKeys(un);
    }
    public void clickContinue(){
        clickContinue.click();

    }
    public boolean incorrectEmail(){
        return showingErrorEmail.isDisplayed();
    }
    public void enterPassword(){
        password.sendKeys(prop.getProperty("password"));
    }
    public void clickSignInButton(){
        signButton.click();

    }
}

