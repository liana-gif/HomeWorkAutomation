package homework.hurtmeplenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleCloudPage {

    private WebDriver mDriver;
    public static final String PAGE_URL = "https://cloud.google.com";
    public GoogleCloudPage(WebDriver driver) {
        mDriver= driver;
    }

    public GoogleCloudPage open() {
        mDriver.get(PAGE_URL);
        return  this;
    }

    public ResultPage searchText(String text) {
        mDriver.findElement(By.name("q")).sendKeys(text +"\n");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResultPage(mDriver);

    }
}


