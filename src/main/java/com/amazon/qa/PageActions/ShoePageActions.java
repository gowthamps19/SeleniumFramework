package com.amazon.qa.PageActions;

import com.amazon.qa.Pages.ShoesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class ShoePageActions extends ShoesPage {
    Actions act = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public ShoePageActions() throws IOException {
    }


    public void hoverToRatingIcon() {
/*
        js.executeScript("arguments[0].scrollIntoView(true);",RatingDownArrow);
        js.executeScript("arguments[0].click();",RatingDownArrow);
        act.moveToElement(RatingDownArrow).build().perform();
        js.executeScript("arguments[0].scrollIntoView(true);",TotalRatingCount);
        js.executeScript("arguments[0].click();",RatingDownArrow);*/

        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_2']//i[@class='a-icon a-icon-popover']")));
       // System.out.println("Down Arrow True");
        act.moveToElement(RatingDownArrow).click().build().perform();
       // System.out.println("Down Crossed");


    }

    public String getReviewCount() {
       myWait.until(ExpectedConditions.visibilityOf(TotalRatingCount));
       return TotalRatingCount.getText();
    }

    public ProductPageActions clickSeeMoreReview() throws IOException {
        SeeMoreReviewsLink.click();
        return new ProductPageActions();
    }

}
