package in.podtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGDemo {

    WebDriver wd = new ChromeDriver();

    @BeforeMethod
    public void preSteps() throws InterruptedException {
        wd.get("https://demo.evershop.io/account/login");

        //Login
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");
        wd.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(4000);
    }

    @Test(testName = "Verify View Cart Page")
    public void testLogin() throws InterruptedException {

        //View the cart [Main TestSteps]
        wd.navigate().to("https://demo.evershop.io/cart");
        String totalAmount = wd.findElement(By.xpath("//div[contains(@class,'grand-total-value')]")).getText(); //Actual Result: coming from UI

        System.out.println("Total Amount is: "+totalAmount);
        Assert.assertEquals(totalAmount,"$2,569.00" ); //

        Thread.sleep(10000);

    }

    @AfterMethod
    public void postSteps() {
        //post steps
        wd.quit();
    }


}
