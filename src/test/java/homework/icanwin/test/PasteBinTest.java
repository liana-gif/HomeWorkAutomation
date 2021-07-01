package homework.icanwin.test;

import homework.icanwin.page.PasteBinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PasteBinTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        //no remote webdriver run during this demo
        driver = new ChromeDriver();
    }

    @Test(description = "Just first test, Jira link also will be included")
    public void commonPastBinTest() {



        new PasteBinPage(driver).open().
                fillcode("Hello from WebDriver")
                .fillPastExpiration("10 Minutes")
                .fillPasteNameTitle("helloweb")
                .createPaste();

        driver.quit();

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;

    }

}
