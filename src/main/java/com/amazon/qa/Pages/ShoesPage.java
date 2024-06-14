package com.amazon.qa.Pages;

import com.amazon.qa.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShoesPage extends TestBase {
   @FindBy(xpath = "//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2']//i[@class='a-icon a-icon-popover']")
   public WebElement RatingDownArrow;


    @FindBy(xpath = "//span[@class='a-size-base a-color-secondary totalRatingCount']")
    public WebElement TotalRatingCount;

    @FindBy(xpath = "//a[contains(text(),\"See customer reviews\" )]")
    public WebElement SeeMoreReviewsLink;


    public ShoesPage() {
        PageFactory.initElements(driver,this
        );
    }
}
