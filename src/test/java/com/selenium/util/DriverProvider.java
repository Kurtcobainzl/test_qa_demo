package com.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class DriverProvider {

    public static WebDriver getFireDriver() throws IOException {
        System.setProperty("webdriver.gecko.driver", new File(".").getCanonicalPath() + "/src/test/resources/driver/geckodriver");
        return new FirefoxDriver();

    }


    public static WebDriver getChromeDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", new File(".").getCanonicalPath() + "/src/test/resources/driver/chromedriver");
        return new ChromeDriver();

    }
}
