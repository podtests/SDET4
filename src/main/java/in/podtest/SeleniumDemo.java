package in.podtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SeleniumDemo {

    /*

    SelectorHub Pop up - done
    Iframes - done
    Wait Mechansims: Implicit, Explicit, FluentWait - done
    TestNg
     */

    //Work with Different web elements:
        /*
        Input box:
        Button
        Dropdown: 2 ways : collection
        Radio Buttons
        Checkboxes
        Web Tables : Read, click
        Popups:
        Tabs
        Iframe

        Wait Mechanism:

        TestNG: testing framework
        */
    static ChromeOptions option = new ChromeOptions();

    static WebDriver wd ;

    static WebDriverWait wait;

    static String cartURL = "https://demo.evershop.io/cart";

    static String popURL ="http://127.0.0.1:5500/htmlcssjspage.html";
    static String tabURL ="http://127.0.0.1:5500/htmlpage.html";
    static String loginURL = "https://demo.evershop.io/account/login";

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
       wd = new RemoteWebDriver(new URL("http://127.0.0.1:4444"),option);

       /*
       openURL(loginURL);
      fillCredentials();
      clickLogin();
      Thread.sleep(10000);
      navigateToURL(cartURL);
      Thread.sleep(10000);
        readWebTableRows();
        removeItem("Mix and match chuck taylor all star");
        */
        //openURL(tabURL);
        //tabs();
        //selectorhubPopup();
        iFrames();


    }

    public static void implicitWait() { //global all elements
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        wd.findElement(By.xpath("")).click();
    }

    public static void explicitWait() { //per element
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        wd.findElement(By.xpath("")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        wd.findElement(By.xpath("")).click();

    }

    public static void fluentWait() { //per element
        FluentWait wait2 = new FluentWait(wd);
            wait2.withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
        wd.findElement(By.xpath("")).click();


    }



    public static void iFrames() throws InterruptedException {
        wd.get("https://selectorshub.com/iframe-scenario/");
        wd.manage().window().maximize();

        FluentWait wait3 = new FluentWait(wd);
        wait3.withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='hfe-menu-item' and contains(text(),'Help')]")));


        wd.switchTo().frame("pact1");
        wd.findElement(By.xpath("//input[@id='inp_val']")).sendKeys("Akhil");
        wd.switchTo().frame("pact2");
        wd.findElement(By.xpath("//input[@id='jex']")).sendKeys("Jain");
        wd.switchTo().parentFrame();
        wd.findElement(By.xpath("//input[@id='inp_val']")).clear();
        wd.findElement(By.xpath("//input[@id='inp_val']")).sendKeys("Akhil Jain");
    }
    public static void closePopup() throws InterruptedException {

        wd.findElement(By.xpath("//input[@id='submit']")).click();
        Thread.sleep(5000);
        System.out.println(wd.switchTo().alert().getText());
        wd.switchTo().alert().accept();

    }

    public static void tabs() throws InterruptedException {
        String defaultWindow = wd.getWindowHandle();
        System.out.println("Default Window id:"+defaultWindow);
        wd.findElement(By.xpath("//a[@id='youtube']")).click();
        wd.findElement(By.xpath("//a[@id='podtest']")).click();

        Set<String> tabIDs = wd.getWindowHandles(); //3

        Iterator<String> i1 = tabIDs.iterator();
        String tabId;
        String title;

        while(i1.hasNext()) {
            tabId = i1.next();
            title = wd.switchTo().window(tabId).getTitle();
            System.out.println(title+":"+tabId);
            if(title.equals("PodTest - Learning Platform for SDET")) {
                System.out.println("I am inside the If loop");
                Thread.sleep(10000);
                wd.findElement(By.xpath("//button[text()='Contact']")).click();
                Thread.sleep(10000);
            }

        }
        //wd.switchTo().window(defaultWindow);

    }

    public static void navigateToURL(String URL) {
        wd.navigate().to(URL);
    }

    public static void openURL(String urlToBeOpened) {
        wd.get(urlToBeOpened);
    }


    public static void readWebTableColumns() {
       List<WebElement> colList = wd.findElements(By.xpath("//table[@class='items-table listing']/thead//td"));
        Iterator<WebElement> i1 = colList.iterator();

        while(i1.hasNext()) {
            System.out.println(i1.next().getText());
        }

    }

    public static void readWebTableRows() {

        /*
        WebElement cell1 = wd.findElement(By.xpath("//table[@class='items-table listing']/tbody/tr[2]/td[1]//div[@class='cart-tem-info']/a"));
        WebElement cell2 = wd.findElement(By.xpath("//table[@class='items-table listing']/tbody/tr[2]/td[2]/div"));
        WebElement cell3 = wd.findElement(By.xpath("//table[@class='items-table listing']/tbody/tr[2]/td[3]"));
        WebElement cell4 = wd.findElement(By.xpath("//table[@class='items-table listing']/tbody/tr[2]/td[4]"));

        System.out.println(cell1.getText());
        System.out.println(cell2.getText());
        System.out.println(cell3.getText());
        System.out.println(cell4.getText());
*/
        List<WebElement> rowsList =wd.findElements(By.xpath("//table[@class='items-table listing']/tbody/tr"));
        int size = rowsList.size(); //2
        for(int i =1; i <=size; i++) {

            System.out.println(wd.findElement(By.xpath("//table[@class='items-table listing']/tbody/tr["+i+"]/td[1]//div[@class='cart-tem-info']/a")).getText());
            System.out.println(wd.findElement(By.xpath("//table[@class='items-table listing']/tbody/tr["+i+"]/td[2]/div")).getText());
            System.out.println(wd.findElement(By.xpath("//table[@class='items-table listing']/tbody/tr["+i+"]/td[3]")).getText());
            System.out.println(wd.findElement(By.xpath("//table[@class='items-table listing']/tbody/tr["+i+"]/td[4]")).getText());
        }

        ////table[@class='items-table listing']/tbody/tr[1]/td[1]//div[@class='cart-tem-info']/a[text()='Nike air zoom pegasus 35']/following-sibling::div/a/span[text()='Remove']
    }


    public static void removeItem(String itemName) {
        wd.findElement(By.xpath("//table[@class='items-table listing']/tbody/tr/td[1]//div[@class='cart-tem-info']/a[text()='"+itemName+"']/following-sibling::div/a/span[text()='Remove']")).click();
    }

    public static void selectorhubPopup() {
        wd.get("https://selectorshub.com/xpath-practice-page/");
        wait = new WebDriverWait(wd, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sgpb-popup-close-button-6")));
        wd.findElement(By.cssSelector(".sgpb-popup-close-button-6")).click();




        //System.out.println("IsDisplayed:"+wd.findElement(By.cssSelector(".sgpb-popup-close-button-6")).isDisplayed());
        //System.out.println("IsDisplayed:"+wd.findElement(By.cssSelector(".sgpb-popup-close-button-6")).isEnabled());



        //System.out.println("IsDisplayed2:"+wd.findElement(By.cssSelector(".sgpb-popup-close-button-6")).isDisplayed());
        //System.out.println("IsDisplayed2:"+wd.findElement(By.cssSelector(".sgpb-popup-close-button-6")).isEnabled());



        //System.out.println("IsDisplayed3:"+wd.findElement(By.cssSelector(".sgpb-popup-close-button-6")).isDisplayed());
        //System.out.println("IsDisplayed3:"+wd.findElement(By.cssSelector(".sgpb-popup-close-button-6")).isEnabled());
        //wait.until(ExpectedConditions.domPropertyToBe(By.xpath("//button[text()='Checkout here']")));

    }

    public static void fillCredentials() {
        wd.findElement(By.xpath("//input[@name='email']")).sendKeys("akhiljda@gmail.com");
        wd.findElement(By.xpath("//input[@name='password']")).sendKeys("Password");
    }

    public static void clickLogin() {


        String s = wd.findElement(By.xpath("//button[@type='submit']")).getText();
        String s1 = wd.findElement(By.xpath("//button[@type='submit']")).getAttribute("class");

        System.out.println(s1);
        wd.findElement(By.xpath("//button[@type='submit']")).click();

    }

    public static void dropdownUsingSelect() {
        WebElement dropdownElement = wd.findElement(By.xpath("//select[contains(@id,'address') and contains(@name,'country')]"));
        Select s1 = new Select(dropdownElement);

        int length = s1.getOptions().size();

        s1.selectByIndex(0);
        s1.selectByIndex(1);
        s1.selectByIndex(2);
        s1.selectByValue("IN");
    }

    public static void dropdownUsingApproach() {
        //click on dropdown --> will be able to the see options visually.
        wd.findElement(By.xpath("//select[contains(@id,'address') and contains(@name,'country')]")).click();

        List<WebElement> l1=  wd.findElements(By.xpath("//select[contains(@id,'address') and contains(@name,'country')]/option"));
          //  l1.get(1).click(); //WebELement.click()


        //select item based on value
        Iterator<WebElement> i1 = l1.iterator();

        WebElement e1 ;
        while(i1.hasNext()) {
            e1 = i1.next();

            System.out.println(e1.getAttribute("value"));
            if (e1.getAttribute("value").equals("IN")) {
                e1.click();

            }
        }





    }


}
