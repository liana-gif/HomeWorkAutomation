package homework.bringiton.page;

import org.openqa.selenium.WebDriver;

public class SavedPastePage {
    protected WebDriver mDriver;

    public SavedPastePage(WebDriver driver) {
        mDriver = driver;
    }

    public String getPageTitle(){
        return mDriver.getTitle();
    }

    public String getPasteText() {
        //TODO  Add code to get code text from Saved Page

      return null;
    }
}
