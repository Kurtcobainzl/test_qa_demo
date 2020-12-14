package com.selenium;

import com.selenium.util.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class DriverTest {

    @Test
    public void runFireFoxDriver() throws IOException, InterruptedException {
        WebDriver driver = DriverProvider.getFireDriver();
        driver.get("https://blog.csdn.net/weixin_30312557/article/details/99571342");
        Thread.sleep(3000);
        driver.get("https://www.baidu.com/");
        Thread.sleep(3000);
        driver.navigate().back();  //后退键
        Thread.sleep(3000);
        driver.navigate().forward();//前进键
        Thread.sleep(3000);
        driver.navigate().refresh();//刷新键
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
        Thread.sleep(5000);
        driver.findElement(By.xpath("/html/body/div[2]/div[9]/div/div[2]/div/ul/li[6]")).click();
        windowHandles = driver.getWindowHandles();//获取当前handle集合，即将跳转。
        System.out.println(driver.getWindowHandle() + "windowHandles====:" + driver.getWindowHandles().size());
        driver.findElement(By.linkText("立即学习")).click();//return1
        Thread.sleep(2000);
        driver.switchTo().window(DriverProvider.getDiff(windowHandles, driver));//把句柄切到心打开到页面
        System.out.println(driver.getWindowHandle() + "windowHandles====:" + driver.getWindowHandles().size());
        windowHandles = driver.getWindowHandles();
        //ruturn 2
        driver.findElement(By.xpath("/html/body/div[2]/div[10]/div/form/div[2]/div[2]/div[4]/div/div[1]/div/table/tbody/tr[2]/td[2]")).click();
        Thread.sleep(2000);
        driver.switchTo().window(DriverProvider.getDiff(windowHandles, driver));
        System.out.println(driver.getWindowHandle() + "windowHandles====:" + driver.getWindowHandles().size());
        driver.findElement(By.id("btnStartStudy")).click();
    }

}

