package homework.hurtmeplenty.page;
import homework.bringiton.page.PasteBinAssertionPage;
import homework.hardcore.page.EmailEstimatePage;
import homework.hardcore.test.EmailEstimateTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public  class EstimatePage {
    protected WebDriver mDriver;
    public EstimatePage(WebDriver driver ){
        mDriver=driver;

    }
    public String getWmClass() {

        return  mDriver.findElements(By.xpath("//div[@class = 'md-list-item-text ng-binding']")).get(1).getText();
    }
    public String getInstanceType() {

        return  mDriver.findElements(By.xpath("//div[@class = 'md-list-item-text ng-binding']")).get(2).getText();
    }
    public String getRegion() {

        return  mDriver.findElements(By.xpath("//div[@class = 'md-list-item-text ng-binding']")).get(3).getText();
    }
    public String getLocalSSD() {

        return  mDriver.findElements(By.xpath("//div[@class = 'md-list-item-text ng-binding']")).get(4).getText();

    }
    public String getCommitmentTerm() {

        return  mDriver.findElements(By.xpath("//div[@class = 'md-list-item-text ng-binding']")).get(5).getText();

    }
    public String getTotalCost(){
       String costText = mDriver.findElement(By.xpath("//*[contains(text(),'Total Estimated Cost')]")).getText();
        Pattern p = Pattern.compile("-?\\d+(,\\d+)*?\\.?\\d+\\d+?");
        Matcher m = p.matcher(costText);
        m.find();
        return m.group();
    }

    public EmailEstimatePage emailEstimate() {


        mDriver.findElement(By.id("email_quote")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new EmailEstimatePage(mDriver);
    }


}
