package com.juaracoding.selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSelenium {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        driver.quit();
        System.out.println("EXIT");

        driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("JuaraCoding");
        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("info@juaracoding.com");
        driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Jakarta");
        driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]")).sendKeys("Jakarta");
        js.executeScript("window.scroll(0,500)");//scroll
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}