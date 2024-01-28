package in.podtest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverParallelManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return WebDriverParallelManager.driver.get();
    }

    private static void setDriver(String browserName) throws MalformedURLException {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            driver.set(new RemoteWebDriver( new URL("http://localhost:4444/"), chromeOptions));
        } else{
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver.set(new RemoteWebDriver( new URL("http://localhost:4444/"), firefoxOptions));
        }

    }

    public static WebDriver createDriver(String browserName)  {
        try {
            setDriver(browserName);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return getDriver();
    }


    public static void closeSession() {
        getDriver().quit();
        driver.remove();
    }
}
