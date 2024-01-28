package in.podtest.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ItemPOM {

    WebDriver wd = null;

    By qtyTextBox = By.cssSelector("//input[@name='qty']");

    public ItemPOM(WebDriver wd){
        this.wd = wd;
    }
    public ItemPOM waitForPageLoad() {
        FluentWait wait2 = new FluentWait(wd);
        wait2.withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(qtyTextBox));
        return this;
    }

    public ItemPOM fillOrderQty(String qtyNumber) {
        wd.findElement(qtyTextBox).sendKeys(qtyNumber);
            return this;
    }
}
