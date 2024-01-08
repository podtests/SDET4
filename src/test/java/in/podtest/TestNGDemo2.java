package in.podtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo2 {

    //WebDriver wd = WebDriverManager.getSession();

    @BeforeMethod(alwaysRun = true)
    public void preSteps() throws InterruptedException {
        WebDriverManager.getSession().get("https://demo.evershop.io/account/login");

        //Login


        Thread.sleep(4000);
    }


    //Postive/Negative
    //Sanity/Regression /Both

    @Test(testName = "Negative Login Test", groups = {"Negative", "Sanity"}, priority = -1)
    public void testNegativeLogin() throws InterruptedException {
        WebDriver wd = WebDriverManager.getSession();
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys("hdgwdg");
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }




}
