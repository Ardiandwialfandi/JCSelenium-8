package com.juaracoding.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreeSelenium {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");
        System.out.println("Get URL");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"item-1\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button")).click();
        driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/label/span[1]")).click();
        String result = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        System.out.println(result);
    }
}
