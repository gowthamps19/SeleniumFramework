package com.amazon.qa.PageActions;

import com.amazon.qa.Pages.ProductPage;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;

public class ProductPageActions extends ProductPage {
    public ProductPageActions() throws IOException {
    }

    public  String GetProductRatingCount(){
       return ProductRatingCount.getText();
    }
    public  void clickSeeMoreReviewLink() throws InterruptedException {
        JavascriptExecutor js  = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",SeeMoreReviewLink);
        js.executeScript("arguments[0].click();",SeeMoreReviewLink);
        Thread.sleep(5000);


    }
}
