package sharedData;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class SharedData {

    private WebDriver driver;
    private String browser;

    @BeforeMethod(alwaysRun = true)
    public void prepareEnvironment(){
       // LoggerUtility.startTest(this.getClass().getSimpleName());

        browser = "Chrome";
        switch (browser){
            case "Chrome":
                ChromeBrowser chromeBrowser = new ChromeBrowser();
                chromeBrowser.openBrowser();
                driver=chromeBrowser.getDriver();
                break;
            case "Firefox":
                FirefoxBrowser firefoxBrowser = new FirefoxBrowser();
                firefoxBrowser.openBrowser();
                driver=firefoxBrowser.getDriver();
                break;
        }

        //LoggerUtility.infoLog("The browser "+ browser+" was opend with success");
    }

    @AfterMethod(alwaysRun = true)

    public void clearEnviroment(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            //LoggerUtility.errorLog(result.getThrowable().getMessage());
        }
        driver.quit();

        //LoggerUtility.infoLog("The browser "+ browser+" was closed with success");


        //LoggerUtility.finishTest(this.getClass().getSimpleName());
    }

    public WebDriver getDriver() {
        return driver;
    }
}
