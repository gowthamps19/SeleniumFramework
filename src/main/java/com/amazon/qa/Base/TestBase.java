package com.amazon.qa.Base;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static Properties prop;
    public static WebDriver driver;

    public TestBase() throws IOException {
        prop = new Properties();
        FileReader propFile = new FileReader("C:\\Users\\gowth\\IdeaProjects\\AmazonTest\\src\\main\\java\\com\\amazon\\qa\\Config\\config.properties");
        prop.load(propFile);
    }

    public void initializer(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        String url = prop.getProperty("url");
        System.out.println(url);
        driver.get(url);

    }


}

