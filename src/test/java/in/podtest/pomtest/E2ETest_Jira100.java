package in.podtest.pomtest;

import in.podtest.WebDriverParallelManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class E2ETest_Jira100 {

    public WebDriver wd ;

    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest(String browserName) {
        wd = WebDriverParallelManager.createDriver(browserName);
    }

    @Parameters({"email", "pass"})
    @Test(alwaysRun = true)
    public void preSteps(String UN, String PW) throws InterruptedException {

        wd.get("https://demo.evershop.io/account/login");

        //Login
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys(UN);
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys(PW);
        wd.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(4000);
    }

}
