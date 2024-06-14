package com.amazon.qa.Base;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static Properties prop;
    public static WebDriver driver;
    public static WebDriverWait myWait;


    public TestBase() {
        prop = new Properties();
        FileReader propFile = null;
        try {
            propFile = new FileReader("C:\\Users\\gowth\\IdeaProjects\\AmazonTest\\src\\main\\java\\com\\amazon\\qa\\Config\\config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(propFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void initializer(){
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
       // driver.manage().window().setSize(new Dimension(1536, 731));
       myWait = new WebDriverWait(driver,Duration.ofSeconds(20));

       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        String url = prop.getProperty("url1");
        System.out.println(url);
        driver.get(url);

    }


}

