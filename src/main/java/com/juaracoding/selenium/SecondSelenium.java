package com.juaracoding.selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondSelenium {
    public static void main(String[] args) {
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box");
        System.out.println("Get URL");
        driver.manage().window().maximize();


        driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("JuaraCoding");
        driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("info@juaracoding.com");
        driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("Jakarta");
        driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]")).sendKeys("Jakarta");
        js.executeScript("window.scroll(0,500)");//scroll
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        String result = driver.findElement(By.xpath("//*[@id=\"output\"]/div")).getText();
        System.out.println(result);
        driver.findElement(By.xpath("//*[@id=\"item-2\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label")).click();
        String result2 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/p")).getText();
        System.out.println(result2);


        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("EXIT");
    }
}
