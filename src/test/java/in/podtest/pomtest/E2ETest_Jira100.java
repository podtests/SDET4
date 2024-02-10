package in.podtest.pomtest;

import in.podtest.WebDriverParallelManager;
import in.podtest.utilities.ConfigReader;
import in.podtest.utilities.ExcelManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.io.IOException;

public class E2ETest_Jira100 {

    public WebDriver wd ;

    private static Logger log = LogManager.getLogger(E2ETest_Jira100.class.getName());


    @BeforeTest(alwaysRun = true)
    public void beforeTest() throws IOException {
        log.info("beforeTest Method started!");
        String browserName = ConfigReader.readConfigFile().getProperty("browseName");
        wd = WebDriverParallelManager.createDriver(browserName);
        log.info("beforeTest Method completed!");
    }

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginData() throws IOException {
        //logic to read from excel & create a 2d object array


        //String : child of object class
        log.info("loginData Method completed!");

        return ExcelManager.readData1();  //Object[][]
    }


    @Test( alwaysRun = true, dataProvider = "loginDataProvider", testName = "user able to login successfully")
    public void LoginSuccessTest(String UN, String PW) throws InterruptedException {

        log.info("login user details are: "+UN + " "+PW);

        log.warn("Its a warning");
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
