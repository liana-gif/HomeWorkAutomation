package homework.hardcore.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class EmailEstimatePage {

    WebDriver mDriver;

    public EmailEstimatePage(WebDriver driver) {
        mDriver = driver;
    }

    public FakeEmailPage openFakeEmail(){


        ((ChromeDriver) mDriver).executeScript(("window.open('https://10minutemail.com','_blank');"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<String> tabs = new ArrayList<String> (mDriver.getWindowHandles());
        mDriver.switchTo().window(tabs.get(1)); //switches to new tab
        return new FakeEmailPage(mDriver);
    }

    public EmailEstimatePage sendEmail(){
        mDriver.switchTo().frame(0);
        mDriver.switchTo().frame("myFrame");
        mDriver.findElement(By.xpath("//input[@name='description'][@id='input_498']")).sendKeys(Keys.chord(Keys.CONTROL, "v"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mDriver.findElement(By.xpath("//button[@aria-label='Send Email']")).click();
        return this;
    }
}
