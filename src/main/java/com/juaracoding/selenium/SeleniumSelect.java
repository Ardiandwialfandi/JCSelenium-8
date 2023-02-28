package com.juaracoding.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumSelect {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        String url = "https://demoqa.com/select-menu";
        driver.get(url);
        System.out.println("Get URL : "+url);
        driver.manage().window().maximize();

        String title = driver.findElement(By.className("main-header")).getText();
        System.out.println("Title : "+title);

        js.executeScript("window.scroll(0,300)");

        WebElement selectColor = driver.findElement(By.id("oldSelectMenu"));
        Select color = new Select(selectColor);
        color.selectByValue("10");
        color.selectByIndex(10);
        color.selectByVisibleText("Black");
        System.out.println("Test Select");
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
