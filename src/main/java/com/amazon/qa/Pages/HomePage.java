package com.amazon.qa.Pages;

import com.amazon.qa.Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends TestBase {
   // WebDriver driver = new ChromeDriver();

    @FindBy(xpath ="//a[@id=\"nav-link-accountList\"]")
    public WebElement signInLink;

    public HomePage() throws IOException {

        PageFactory.initElements(driver,this);
    }

}

