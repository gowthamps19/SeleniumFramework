package com.amazon.qa.Pages;

import com.amazon.qa.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ProductPage extends TestBase {
    @FindBy(xpath = "//*[@id=\"cm_cr_dp_d_rating_histogram\"]//child::div[3]/span")
    public WebElement ProductRatingCount;

    @FindBy(xpath = "//*[@id=\"reviews-medley-footer\"]//following::a[contains(text(),\"See more reviews\")]")
    public WebElement SeeMoreReviewLink;


    //FacebookPage for Data driven Testing



    public ProductPage() throws IOException {
        PageFactory.initElements(driver,this);
    }
}
