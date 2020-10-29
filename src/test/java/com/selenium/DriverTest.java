package com.selenium;

import com.selenium.util.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverTest {

    @Test
    public void runFireFoxDriver() throws IOException, InterruptedException {
        WebDriver driver = DriverProvider.getFireDriver();
    }


    @Test
    public void runChromeDriver() throws IOException, InterruptedException {
        Set<String> windowHandles;
        WebDriver driver = DriverProvider.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//隐式等待
        driver.get("http://baicm.yunxuetang.cn/login.htm");
        String handle1 = driver.getWindowHandle();
        System.out.println("主页面1句柄：" + handle1);
        driver.findElement(By.id("methodDesktop")).click();
        driver.findElement(By.id("txtUserName2")).sendKeys("05301117");
        driver.findElement(By.id("txtPassword2")).sendKeys("zhanglin0514");
        driver.findElement(By.id("btnSetNoPatt")).click();
        driver.findElement(By.linkText("课程资源")).click();
        windowHandles = driver.getWindowHandles();//获取当前handle集合，即将跳转。
        driver.findElement(By.id("0fc5e5a3-59eb-42ea-9508-1b993f196383")).click();
        driver.switchTo().window(DriverProvider.getDiff(windowHandles, driver));//把句柄切到心打开到页面
        windowHandles = driver.getWindowHandles();
        List<WebElement> elements = driver.findElements(By.cssSelector(".font-size-14.hand.text-normal"));
        elements.get(0).click();
        driver.switchTo().window(DriverProvider.getDiff(windowHandles, driver));
        driver.findElement(By.id("btnStartStudy")).click();
    }

}

