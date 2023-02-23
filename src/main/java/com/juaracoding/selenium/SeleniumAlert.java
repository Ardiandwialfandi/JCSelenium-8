package com.juaracoding.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAlert {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/alerts");
        System.out.println("Get URL");
        driver.manage().window().maximize();

        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title : "+title);
        driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
        System.out.println("Alert Accept");

        driver.findElement(By.id("timerAlertButton")).click();
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.switchTo().alert().accept();
        System.out.println("Alert 2 Accept");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().accept();
        System.out.println("Allert 3 Success");

        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("Mantap");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().alert().accept();
        System.out.println("Alert 4 Sucess");

        driver.quit();
        System.out.println("Quit");

    }
}
