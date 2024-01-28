package in.podtest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPOM {

     WebDriver wd = null;

     public LoginPOM(WebDriver wd){
          this.wd = wd;
     }

     By userName = By.xpath("//input[@name='email']");
     By password =  By.xpath("//input[@name='password']");

     By submitButton = By.xpath("//button[@type='submit']");


     public LoginPOM get() {
          wd.get("https://demo.evershop.io/account/login");
          return this;

     }
     public LoginPOM fillUserName(String email) {
          wd.findElement(userName).sendKeys(email);
          return this;
     }

     public LoginPOM fillPassword(String pwd) {

          wd.findElement(password).sendKeys(pwd);
          return this;
         // return new LoginPOM();
     }

     public HomePOM clickSubmit() {

          wd.findElement(submitButton).click();
          return new HomePOM(wd);
     }



     //wd session mgt : Done
     //overload constructor : to achieve wd session mgt
     //chain methods: done
     //this keyword: to cahin our methods

}
