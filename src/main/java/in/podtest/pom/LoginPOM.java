package in.podtest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPOM {

     WebDriver wd = null;

     By userName = By.cssSelector("//input[@name='email']");
     By password =  By.xpath("//input[@name='password']");

     By submitButton = By.xpath("//button[@type='submit']");

     public void fillUserName(String email) {
          wd.findElement(userName).sendKeys(email);
     }

     public void fillPassword(String pwd) {
          wd.findElement(password).sendKeys(pwd);
     }

     public void clickSubmit() {
          wd.findElement(submitButton).click();
     }



     //wd session mgt
     //constructor
     //chain methods
     //this keyword

}
