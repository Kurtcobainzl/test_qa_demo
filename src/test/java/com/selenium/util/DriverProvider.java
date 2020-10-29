package com.selenium.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class DriverProvider {

    public static WebDriver getFireDriver() throws IOException {
        System.setProperty("webdriver.gecko.driver", new File(".").getCanonicalPath() + "/src/test/resources/driver/geckodriver");
        return new FirefoxDriver();
    }


    public static WebDriver getChromeDriver() throws IOException {
        System.setProperty("webdriver.chrome.driver", new File(".").getCanonicalPath() + "/src/test/resources/driver/chromedriver");
        return new ChromeDriver();
    }


    /**
     * @param oldSet 跳转新页面之前的Handle集合
     * @param driver 打开新页面之后，通过driver获取最新的handle集合
     * @return 通过比较差集，取出新页面的handle
     */
    public static String getDiff(Set<String> oldSet, WebDriver driver) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String string : oldSet) {
            if (windowHandles.contains(string)) {
                windowHandles.remove(string);
            } else {
                return string;
            }
        }

        if (windowHandles.size() > 0) {
            return new ArrayList<String>(windowHandles).get(0);
        }

        return "";
    }
}
