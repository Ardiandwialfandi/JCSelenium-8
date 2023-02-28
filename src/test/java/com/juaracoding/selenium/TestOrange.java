package com.juaracoding.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestOrange {

    WebDriver driver;
    JavascriptExecutor js;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ARDI\\.cache\\selenium\\chromedriver\\win32\\110.0.5481.77\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
    }


    @Test(priority = 1)
    public void testURL() {
        delay(1);
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
        driver.get(url);
        System.out.println("Get URL : " + url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Title : " + title);
        Assert.assertEquals(title, "OrangeHRM");
    }

    @Test(priority = 2)
    public void testLogin() {
        delay(1);
        userPass("Admin","admin123");
        System.out.println("Button login success");
        String dashboard = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
        Assert.assertEquals(dashboard, "Dashboard");
    }

    @Test(priority = 3)
        public void testLogout(){
        delay(1);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span")).click();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a")).click();

        delay(1);
        String title = driver.getTitle();
        System.out.println("Title : " + title);
        Assert.assertEquals(title, "OrangeHRM");
    }

    @Test(priority = 4)
    public void testInvalidLogin() {
        delay(1);
        userPass("dsfsf","admin123");
        System.out.println("Button login Invalid");
        String dashboard = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText();
        Assert.assertEquals(dashboard, "Invalid credentials");
    }

    @Test(priority = 5)
    public void testInvalidLogin2() {
        driver.navigate().refresh();
        delay(1);
        userPass("","");
        System.out.println("Button login Invalid");
        String dashboard = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span")).getText();
        Assert.assertEquals(dashboard, "Required");
    }
    @AfterClass
    public void quit() {
        delay(3);
        driver.quit();
        System.out.println("Quit");
    }

    static void delay(long detik) {
        System.out.println("Delay out 3 second");
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void userPass(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
    }

}