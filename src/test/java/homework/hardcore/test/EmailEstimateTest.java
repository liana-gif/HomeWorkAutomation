package homework.hardcore.test;

import homework.hardcore.page.EmailEstimatePage;
import homework.hardcore.page.FakeEmailPage;
import homework.hurtmeplenty.page.CloudPricingCalculatorPage;
import homework.hurtmeplenty.page.EstimatePage;
import homework.hurtmeplenty.page.GoogleCloudPage;
import homework.hurtmeplenty.page.ResultPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmailEstimateTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        //no remote webdriver run during this demo
        driver = new ChromeDriver();
    }

    @Test(description = "Just first test, Jira link also will be included")
    public void commonGoogleCloudFill() {

        ResultPage searchResultsPage = new GoogleCloudPage(driver).open()
                .searchText("Google Cloud Platform Pricing Calculator");

        //Now will switch to the new opened page
        CloudPricingCalculatorPage cloudPricingCalculator = searchResultsPage.findSearchResult("Google Cloud Platform Pricing Calculator")
                .clickSearchReasult();
        EstimatePage estimatePage = cloudPricingCalculator.activateEngine("COMPUTE ENGINE")
                .fillRequiredFields("4",
                        "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS",
                "Regular",
                        "n1-standard-8 (vCPUs: 8, RAM: 30GB)",
                        "1",
                        "NVIDIA Tesla V100",
                        "2x375 GB",
                        "Frankfurt (europe-west3)",
                        "1 Year").addToEstimate();



        EmailEstimatePage emailEstimatePage = estimatePage.emailEstimate();

        FakeEmailPage fakeEmailPage = emailEstimatePage.openFakeEmail();

        fakeEmailPage.copyEmailToClipboard();

        emailEstimatePage.sendEmail();

       // Assert.assertEquals("1,082.77", fakeEmailPage.getEstimateFromEmail());



//        Assert.assertEquals("VM class: regular", estimatePage.getWmClass());
//        Assert.assertEquals("Instance type: n1-standard-8", estimatePage.getInstanceType());
//        Assert.assertEquals("Region: Frankfurt", estimatePage.getRegion());
//        Assert.assertEquals("Total available local SSD space 2x375 GiB", estimatePage.getLocalSSD());
//        Assert.assertEquals("Commitment term: 1 Year", estimatePage.getCommitmentTerm());
//        Assert.assertEquals("1,082.77", estimatePage.getTotalCost());

      //  driver.quit();

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        //driver.quit();
        driver=null;

    }

}
