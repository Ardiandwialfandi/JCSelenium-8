package com.juaracoding.selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TestAdd {
    WebDriver driver;
    JavascriptExecutor js;


    @BeforeClass
    public void setUpAdd() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARDI\\.cache\\selenium\\chromedriver\\win32\\110.0.5481.77\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
        System.out.println("Get URL : " + url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123",Keys.ENTER);
        }


    @Test(priority = 2)
    public void testAddRecruitment(){
        delay(4);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[5]/a[1]")).click();
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]")).click();
        driver.findElement(By.name("firstName")).sendKeys("Juara");
        driver.findElement(By.name("middleName")).sendKeys("cod");
        driver.findElement(By.name("lastName")).sendKeys("dingg");

        driver.findElement(By.xpath("//div[@class='oxd-select-text-input']")).sendKeys("Software");
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[1]/div[1]/div[2]/input[1]")).sendKeys("dyugdfdsy@gmail.com");
        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[2]/input[1]")).sendKeys("087899847080");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("F:\\Download\\IMK_LIA APRILIA_201743601900_R61.docx");
        js.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.xpath("//input[@placeholder='Enter comma seperated words...']")).sendKeys("Test");
        DateFormat tanggal = new SimpleDateFormat("MM-dd-yyyy");
        Date hariini = new Date();
        String dateNow = tanggal.format(hariini);
        driver.findElement(By.tagName("input")).sendKeys(dateNow);
        driver.findElement(By.tagName("textarea")).sendKeys("Noted");
        driver.findElement(By.xpath("//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")).click();
        driver.findElement(By.xpath(" //button[normalize-space()='Save']")).click();

        String asser= driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/h6")).getText();
        Assert.assertEquals(asser, "Application Stage");
    }

    @AfterClass
    public void close(){
        delay(1);
        driver.quit();
        System.out.println("System Quit");
    }
    static void delay(long detik) {
        System.out.println("Delay out 3 second");
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

