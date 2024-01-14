package in.podtest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class HomePOM {

    WebDriver wd = null;

    String itemLink = "//a/span[text()='^^']";

    public HomePOM(WebDriver wd){
        this.wd = wd;
    }
    public HomePOM waitForPageLoad() {
        FluentWait wait2 = new FluentWait(wd);
        wait2.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/kids']")));
        return this;
    }

    public ItemPOM clickItem(String itemName) {
        String localItemLink = itemLink.replace("^^",itemName);
        System.out.println("Itemlink text is: "+localItemLink);
        wd.findElement(By.xpath(localItemLink)).click();
        return new ItemPOM(wd);
    }
}
