package homework.bringiton.page;

import homework.icanwin.page.PasteBinPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasteBinAssertionPage extends PasteBinPage {


    public PasteBinAssertionPage(WebDriver driver) {

        super(driver);
    }
    public PasteBinAssertionPage open() {
        mDriver.get(PAGE_URL);
        return this;
    }

    public PasteBinAssertionPage fillSyntaxHighlighting(String fillSyntaxHighlighting){
        WebElement dropbox = waitForElementLocatedBy(By.id("select2-postform-format-container"));
        dropbox.click();

        waitForElementLocatedBy(By.xpath("//li[@class='select2-results__option'][text()='Bash']")).click();
        return this;
    }

}
