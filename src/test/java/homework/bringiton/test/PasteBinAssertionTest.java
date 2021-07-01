package homework.bringiton.test;

import homework.bringiton.page.PasteBinAssertionPage;
import homework.bringiton.page.SavedPastePage;
import homework.icanwin.page.PasteBinPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PasteBinAssertionTest  {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        //no remote webdriver run during this demo
        driver = new ChromeDriver();
    }

    @Test(description = "Just first test, Jira link also will be included")
    public void commonPastBinTest() {


        SavedPastePage savedPastePage = new PasteBinAssertionPage(driver).open()
                 .fillSyntaxHighlighting("Bash")
                .fillcode("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force")

                .fillPastExpiration("10 Minutes")
                .fillPasteNameTitle("how to gain dominance among developers")
                .createPaste();

        Assert.assertTrue(savedPastePage.getPageTitle().contains("how to gain dominance among developers"));
        Assert.assertEquals("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force", savedPastePage.getPasteText());

        driver.quit();

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver=null;

    }

}
