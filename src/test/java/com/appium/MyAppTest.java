package com.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MyAppTest {


    /**
     * Appium  DesiredCapabilities 参数配置
     * https://www.cnblogs.com/wysk/p/7346659.html
     */
    public static AppiumDriver driver;

    //@BeforeClass
    public void setUp() throws IOException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10.0.0");
        capabilities.setCapability("appPackage", "com.hxcx.morefun");
        capabilities.setCapability("clearSystemFiles", false);
        capabilities.setCapability("noReset", true);//防止重安装app
        capabilities.setCapability("unicodeKeyboard", true);//使用 Unicode 输入法 ，支持中文输入
        capabilities.setCapability("app", new File(".").getCanonicalPath() + "/src/test/resources/dev-6.8.4_release.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        Thread.sleep(2000);
    }


    @Test
    public void myTest() {

        String a="123";
        String b="123";
        String c=new String("123");
        String d=new String("123");

       System.out.println(a==b);
        System.out.println(a.equals(b));
        System.out.println(c==d);
       System.out.println(a.equals(c));

    }
}
