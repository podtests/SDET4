package in.podtest.pomtest;

import in.podtest.WebDriverParallelManager;
import in.podtest.utilities.ConfigReader;
import in.podtest.utilities.ExcelManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class E2ETest_Jira100 {

    public WebDriver wd ;


    @BeforeTest(alwaysRun = true)
    public void beforeTest() throws IOException {
        String browserName = ConfigReader.readConfigFile().getProperty("browseName");
        wd = WebDriverParallelManager.createDriver(browserName);
    }

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginData() throws IOException {
        //logic to read from excel & create a 2d object array


        //String : child of object class


        return ExcelManager.readData1();  //Object[][]
    }


    @Test(alwaysRun = true, dataProvider = "loginDataProvider")
    public void preSteps(String UN, String PW) throws InterruptedException {

        wd.get("https://demo.evershop.io/account/login");

        //Login
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys(UN);
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys(PW);
        wd.findElement(By.xpath("//button[@type='submit']")).click();

        Thread.sleep(4000);
        //logout
        //start wd session
    }

}
