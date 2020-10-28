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

//        driver.findElement(By.partialLinkText("/kng/kngindex.htm")).click();
//        Thread.sleep(1000);
//        System.out.println("77777");
//        driver.findElement(By.linkText("如何制定产品策略）")).click();
//        System.out.println("88888");
    }


    @Test
    public void runChromeDriver() throws IOException, InterruptedException {
        WebDriver driver = DriverProvider.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://baicm.yunxuetang.cn/login.htm");
        Thread.sleep(3000);
        String handle1 = driver.getWindowHandle();
        System.out.println("主页面1句柄：" + handle1);
        driver.findElement(By.id("methodDesktop")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("txtUserName2")).sendKeys("05301117");
        Thread.sleep(500);
        driver.findElement(By.id("txtPassword2")).sendKeys("zhanglin0514");
        Thread.sleep(500);
        driver.findElement(By.id("btnSetNoPatt")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("课程资源")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("0fc5e5a3-59eb-42ea-9508-1b993f196383")).click();
        Thread.sleep(4000);

        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> arrayList = new ArrayList<String>(windowHandles);
        arrayList.remove(driver.getWindowHandle());
        driver.close();
        driver.switchTo().window(arrayList.get(0));

        Thread.sleep(2000);
        List<WebElement> elements = driver.findElements(By.cssSelector(".font-size-14.hand.text-normal"));
        System.out.println(elements.size());
        elements.get(0).click();
        Thread.sleep(2000);
        windowHandles = driver.getWindowHandles();
        arrayList = new ArrayList<String>(windowHandles);
        System.out.println(arrayList.size());
        arrayList.remove(driver.getWindowHandle());
        driver.switchTo().window(arrayList.get(0));


        driver.findElement(By.id("btnStartStudy")).click();


    }

}

