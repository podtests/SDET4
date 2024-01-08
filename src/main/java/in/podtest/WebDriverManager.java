package in.podtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {

    private static WebDriver wd; //obj chromedriver

    public static WebDriver createSession() {
        wd=new ChromeDriver();
        return wd;
    }

    public static WebDriver getSession() {
        return wd;
    }

    public static void deleteSession() {
        wd.quit();
    }

}
