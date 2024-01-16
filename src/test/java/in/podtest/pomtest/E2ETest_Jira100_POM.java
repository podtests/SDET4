package in.podtest.pomtest;

import in.podtest.WebDriverParallelManager;
import in.podtest.pom.HomePOM;
import in.podtest.pom.LoginPOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class E2ETest_Jira100_POM {

    public WebDriver wd ;
    public LoginPOM login;

    public HomePOM home;

    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void beforeTest(String browserName) {

        wd = WebDriverParallelManager.createDriver(browserName);
        login = new LoginPOM(wd);
        home = new HomePOM(wd);

    }

    @Parameters({"email", "pass", "itemName"})
    @Test(alwaysRun = true)
    public void preSteps(String UN, String PW, String itemName) throws InterruptedException {

        login.get().fillUserName(UN).fillPassword(PW).clickSubmit()
                .waitForPageLoad().clickItem(itemName)
                .waitForPageLoad().fillOrderQty("4");
    }

}
