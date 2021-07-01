package homework.hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class FakeEmailPage {

    protected WebDriver mDriver;

    public FakeEmailPage(WebDriver driver) {
        mDriver = driver;
    }

    public void copyEmailToClipboard(){

        mDriver.findElement(By.id("copy_address")).click();

        ArrayList<String> tabs = new ArrayList<String> (mDriver.getWindowHandles());
        mDriver.switchTo().window(tabs.get(0)); //switches to new tab
    }

    public String getEstimateFromEmail() {

        //TODO write code to get estimate from received email

        return null;
    }
}
