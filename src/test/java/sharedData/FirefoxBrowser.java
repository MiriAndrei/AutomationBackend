package sharedData;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class FirefoxBrowser implements Browser{
    private FirefoxOptions firefoxOptions;
    private WebDriver driver;


    @Override
    public void openBrowser() {
        configureBrowser();
        driver = new FirefoxDriver(firefoxOptions);
        driver.get("https://demoqa.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //LoggerUtility.startTest(this.getClass().getSimpleName());
    }

    @Override
    public void configureBrowser() {
        firefoxOptions=new FirefoxOptions();
        firefoxOptions.addArguments("window-size=1680,1050");
        firefoxOptions.addArguments("--disable-gpu");
        firefoxOptions.addArguments("--disable-infobars");
        firefoxOptions.addArguments("--disable-extensions");
        firefoxOptions.addArguments("--headless=new");
        firefoxOptions.addArguments("--incognito");

    }

    public WebDriver getDriver() {
        return driver;
    }
}
