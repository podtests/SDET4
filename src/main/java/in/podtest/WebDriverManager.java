package in.podtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    private static WebDriver wd; //obj chromedriver

    public static WebDriver createSession(String browserName) {
        if (browserName.equals("chrome")) {
            wd = new ChromeDriver();
        }
        else {
            wd = new FirefoxDriver();
        }
        return wd;
    }

    public static WebDriver getSession() {
        return wd;
    }

    public static void deleteSession() {
        wd.quit();
    }

}
