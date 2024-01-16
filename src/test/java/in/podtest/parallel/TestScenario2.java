package in.podtest.parallel;

import in.podtest.WebDriverManager;
import in.podtest.WebDriverParallelManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestScenario2 {

    public WebDriver wd ;


    @Parameters({"email", "pass", "browser"})
    @BeforeClass(alwaysRun = true)
    public void preSteps(String UN, String PW, String browser) throws InterruptedException {
        wd = WebDriverParallelManager.createDriver(browser);
        wd.get("https://demo.evershop.io/account/login");

    }

    @Parameters({"email", "pass"})
    @Test(testName = "Verify View Cart Page",priority=1)
    public void testLogin2(String UN, String PW) throws InterruptedException {

        wd.get("https://demo.evershop.io/account/login");

        //Login
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys(UN);
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys(PW);
        wd.findElement(By.xpath("//button[@type='submit']")).click();

      String currentURL =  wd.getCurrentUrl();
       SoftAssert s1 = new SoftAssert();
        s1.assertEquals("https://demo.evershop.io/",currentURL );

    }


}
