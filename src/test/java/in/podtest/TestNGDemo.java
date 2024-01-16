package in.podtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class TestNGDemo {

    public WebDriver wd ;

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
       wd = WebDriverManager.createSession("chrome");
    }

    @Parameters({"email", "pass"})
    @BeforeClass(alwaysRun = true)
    public void preSteps(String UN, String PW) throws InterruptedException {
        wd.get("https://demo.evershop.io/account/login");

        //Login
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys(UN);
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys(PW);
        wd.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(4000);
    }


    @Test(testName = "Verify View Cart Page",priority=1)
    public void testLogin() throws InterruptedException {

        //View the cart [Main TestSteps]
        wd.navigate().to("https://demo.evershop.io/cart");
        String totalAmount = wd.findElement(By.xpath("//div[contains(@class,'grand-total-value')]")).getText(); //Actual Result: coming from UI

        System.out.println("Total Amount is: "+totalAmount);
        SoftAssert s1 = new SoftAssert();
        s1.assertEquals(totalAmount,"$4,772.00" ); //failing

        //Assert.assertEquals(totalAmount,"$4,772.00" ); //Hard Assert
        System.out.println("I was Executed!");

        //Assert.assertEquals(wd.getCurrentUrl(),"https://demo.evershop.io/cart" );
        s1.assertEquals(wd.getCurrentUrl(),"https://demo.evershop.io/cart" );

        Thread.sleep(10000);

        s1.assertAll();

    }
    @Test(testName = "Verify View  Page", priority=2)
    public void test2() {
        System.out.println("test2 executed!");
    }

    @AfterSuite(alwaysRun = true)
    public void postSteps() {
        //post steps
        WebDriverManager.deleteSession();
    }


}
