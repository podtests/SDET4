package in.podtest.runners;

import in.podtest.WebDriverParallelManager;
import in.podtest.pom.HomePOM;
import in.podtest.pom.LoginPOM;
import in.podtest.utilities.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginStepDef {

    public WebDriver wd ;
    public LoginPOM login;

    public HomePOM home;

    private static Logger log = LogManager.getLogger(LoginStepDef.class.getName());


    @Given("User is on Login Screen")
    public void useropenLoginPage() throws IOException {
        log.info("beforeTest Method started!");
        String browserName2 = ConfigReader.readConfigFile().getProperty("browseName");
        wd = WebDriverParallelManager.createDriver(browserName2);
        login = new LoginPOM(wd);
        home = new HomePOM(wd);
        login.get();
        log.info("beforeTest Method completed!");

    }

    @When("User fills credentials username as {string}")
    public void user_fills_credentials_username_as(String UN) {
        // Write code here that turns the phrase above into concrete actions
        login.fillUserName(UN);
    }
    @When("password is filled as {string}")
    public void password_is_filled_as(String PW) {
        // Write code here that turns the phrase above into concrete actions
       login.fillPassword(PW);
    }
    @When("User click on Submit button")
    public void user_click_on_submit_button() {
        // Write code here that turns the phrase above into concrete actions
       login.clickSubmit();
    }
    @Then("User should be able to login")
    public void user_should_be_able_to_login() {
        // Write code here that turns the phrase above into concrete actions
       home.waitForPageLoad();
    }
}
