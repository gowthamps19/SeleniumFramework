package com.amazon.qa.Pages;

import com.amazon.qa.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SignInPage extends TestBase {
    public SignInPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='ap_email']")
    public WebElement emailName;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement clickContinue;
    @FindBy(xpath = "//div[contains(text(),' Enter your email or mobile phone number')]")
    public WebElement showingErrorEmail;
    @FindBy(xpath = "//input[@id='ap_password']")
    public WebElement password;
    @FindBy(xpath = "//input[@id=\"signInSubmit\"]")
    public  WebElement signButton;


}
