package com.juaracoding.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumFrame {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        String url = "https://demoqa.com/frames";
        driver.get(url);
        System.out.println("Get URL : "+url);
        driver.manage().window().maximize();

        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title : "+title);

        //frame
        WebElement frameSamleSwitch = driver.findElement(By.id("frame1"));
        driver.switchTo().frame(frameSamleSwitch);

        String frame = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(frame);

        //keluar dari frame
        driver.switchTo().defaultContent();
        String descFrame = driver.findElement(By.xpath("//*[@id=\"framesWrapper\"]/div[1]")).getText();
        System.out.println(descFrame);

        js.executeScript("window.scroll(0,500)");
        System.out.println("scroll");

        driver.findElement(By.xpath("//div[@class='element-list collapse show']//li[@id='item-4']")).click();
        System.out.println("Modal dialog click");

        driver.findElement(By.id("showSmallModal")).click();
        System.out.println("Click Small");
        String smallDialog = driver.findElement(By.xpath("/html/body/div[5]/div/div/div[2]")).getText();
        System.out.println(smallDialog);
        driver.findElement(By.id("closeSmallModal")).click();
        System.out.println("click close");

        System.out.println("===Delay 3 Second");
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }



        driver.quit();
        System.out.println("Quit");
    }
}
