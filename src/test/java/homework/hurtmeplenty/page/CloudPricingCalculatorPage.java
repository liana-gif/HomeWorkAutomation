package homework.hurtmeplenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CloudPricingCalculatorPage {
    private WebDriver mDriver;

    public CloudPricingCalculatorPage(WebDriver driver){
        mDriver=driver;

    }
    public CloudPricingCalculatorPage activateEngine(String compute_engine) {
        return this ;
    }


    public CloudPricingCalculatorPage fillRequiredFields(String nOfInstances,
                                                         String operatingSystems,
                                                         String wmClass,
                                                         String nodeType,
                                                         String numberOfGPU,
                                                         String gPUType,
                                                         String localSSD,
                                                         String dataCenter,
                                                         String commitedUsage) {
        mDriver.switchTo().frame(0);
        mDriver.switchTo().frame(0);


        mDriver.findElement(By.id("input_65")).sendKeys(nOfInstances);
        mDriver.findElement(By.id("select_77")).click();
        mDriver.findElement(By.xpath("//*[contains(text(), '" + operatingSystems + "')]//parent::md-option")).click();

        mDriver.findElement(By.id("select_81")).sendKeys(wmClass);
        mDriver.findElement(By.id("select_89")).sendKeys("N1");


        mDriver.findElement(By.id("select_91")).click();
        mDriver.findElement(By.xpath("//*[contains(text(), '" + nodeType + "')]//parent::md-option")).click();

        mDriver.findElement(By.xpath("//*[@class='md-label'][contains(text(), 'Add GPUs.')]")).click();
        mDriver.findElement(By.xpath("//md-select[@placeholder='Number of GPUs']")).sendKeys(numberOfGPU);
        mDriver.findElement(By.xpath("//md-select[@placeholder='GPU type']")).click();
        mDriver.findElement(By.xpath("//*[contains(text(), '" + gPUType + "')]//parent::md-option")).click();


        mDriver.findElement(By.xpath("//md-select[@placeholder='Local SSD']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mDriver.findElement(By.xpath("//*[contains(text(), '" + localSSD + "')]//parent::md-option")).click();

        mDriver.findElement(By.id("select_93")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mDriver.findElements(By.xpath("//*[contains(text(), '" + dataCenter + "')]//parent::md-option")).get(2).click();

        mDriver.findElement(By.id("select_100")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mDriver.findElements(By.xpath("//*[contains(text(), '" + commitedUsage + "')]//parent::md-option")).get(1).click();


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return this;

    }

    public EstimatePage addToEstimate() {
        mDriver.findElement(By.xpath("//button[@aria-label='Add to Estimate'][not(@disabled = 'disabled')]")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new EstimatePage(mDriver);
    }

}