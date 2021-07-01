package homework.icanwin.page;

import homework.bringiton.page.SavedPastePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinPage {

    protected WebDriver mDriver;
    public static final String PAGE_URL = "https://pastebin.com";


    public PasteBinPage(WebDriver driver) {
        mDriver = driver;
    }

    public PasteBinPage open() {
        mDriver.get(PAGE_URL);
        return this;
    }

    public PasteBinPage fillcode(String code) {
        WebElement codeFiled = waitForElementLocatedBy(By.id("postform-text"));
        codeFiled.sendKeys(code);

        return this;
    }

    public PasteBinPage fillPastExpiration(String expiration) {

        WebElement dropbox = waitForElementLocatedBy(By.id("select2-postform-expiration-container"));
        dropbox.click();

        waitForElementLocatedBy(By.xpath("//li[@class='select2-results__option'][text()='10 Minutes']")).click();

        return this;
    }

    public PasteBinPage fillPasteNameTitle(String title) {
        WebElement fillName = waitForElementLocatedBy(By.id("postform-name"));
        fillName.sendKeys(title);

        return this;
    }

    public SavedPastePage createPaste() {
        WebElement clickCreateNewPaste= waitForElementLocatedBy(By.xpath("//button[@type='submit']"));
        clickCreateNewPaste.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SavedPastePage(mDriver);
    }

    protected   WebElement waitForElementLocatedBy ( By by){
        return new WebDriverWait(mDriver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }
}
