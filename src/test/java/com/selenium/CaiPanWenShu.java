package com.selenium;

import com.selenium.util.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CaiPanWenShu {


    private static final String url = "https://wenshu.court.gov.cn/website/wenshu/181010CARHS5BS3C/index.html?open=login";
    private static String Main_handle = "";//主浏览页句柄
    private static String save_path = "";

    @Test
    public void runMsg() throws Exception {
        File directory = new File(".");
        save_path = directory.getCanonicalPath() + "/src/test/resources/pa_chong/";
        Set<String> windowHandles;
        WebDriver driver = DriverProvider.getFireDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//隐式等待
        driver.get(url);
        WebElement iframe = driver.findElements(By.tagName("iframe")).get(0);
        Main_handle = driver.getWindowHandle();
        driver.switchTo().frame(iframe);
        driver.findElement(By.className("phone-number-input")).sendKeys("18910904090");
        driver.findElement(By.className("password")).sendKeys("zhanglin0514A");

        driver.findElement(By.className("login-button-container")).click();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        Thread.sleep(1000);
        windowHandles = driver.getWindowHandles();
        driver.findElement(By.linkText("民事案件")).click();
        Thread.sleep(5000);
        Main_handle = DriverProvider.getDiff(windowHandles, driver);
        driver.switchTo().window(Main_handle);

        int page = 0;
        while (page++ < 100) {
            List<WebElement> lm_list = driver.findElements(By.className("LM_list"));
            for (WebElement element : lm_list) {
                windowHandles = driver.getWindowHandles();
                element.findElement(By.className("caseName")).click();
                Thread.sleep(2000);
                driver.switchTo().window(DriverProvider.getDiff(windowHandles, driver));
                List<WebElement> div = driver.findElement(By.className("PDF_pox")).findElements(By.tagName("div"));
                StringBuffer sb = new StringBuffer();
                for (WebElement el : div) {
                    sb.append(el.getText() + "\n");
                }
                String name = driver.findElement(By.className("PDF_title")).getText();
                writeFile(save_path + name + (System.currentTimeMillis() % 10000) + ".txt", sb.toString());
                driver.close();
                System.out.println("\n\n\n");
                driver.switchTo().window(Main_handle);
            }
            Thread.sleep(1000);
            driver.findElement(By.linkText("下一页")).click();
            Thread.sleep(2000);
        }
    }


    /**
     * 写入本地
     *
     * @param path
     * @param content
     */
    private static void writeFile(String path, String content) {
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file, true);
            fileOutputStream.write(content.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
