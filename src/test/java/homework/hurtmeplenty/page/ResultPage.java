package homework.hurtmeplenty.page;

import homework.icanwin.page.PasteBinPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage {

    private WebDriver mDriver;

    public ResultPage(WebDriver driver){
        mDriver=driver;
    }

    public ResultPage findSearchResult(String google_cloud_platform_pricing_calculator) {
        return this;
    }

    public CloudPricingCalculatorPage clickSearchReasult() {

        mDriver.findElement(By.xpath("//b[text()='Google Cloud Platform Pricing Calculator']//parent::a")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CloudPricingCalculatorPage(mDriver);
    }


}
