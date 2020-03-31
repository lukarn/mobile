package utilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.URL;
import java.util.HashMap;

public class DriverManager {

    private WebDriver driver;

    public DriverManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebDriver getDriver(String usingBrowser)
    {
        if(usingBrowser.equalsIgnoreCase("chrome"))
        {
            //run chromedriver
            driver = getChromeDriver();
            System.out.println("start with chromedriver :)");
        }
        else if(usingBrowser.equalsIgnoreCase("firefox"))
        {
            //run firefox
            driver = getFirefoxDriver();
            System.out.println("start with firefoxdriver :)");
        }
        else {
            //other drivers to implement!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            System.out.println("---------other driver to implement");
        }

        return driver;
    }

    private WebDriver getChromeDriver()
    {
//        HashMap<String, Object> chromePrefs = new HashMap<>();
//        chromePrefs.put("profile.default_content_settings.popups", 0);
//        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + "\\screenShots");
//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("prefs", chromePrefs);
//        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--window-size=1920,1080");

        DesiredCapabilities cap = new DesiredCapabilities();
        //cap.setCapability("udid", "LMQ610NR9D7LLJ7TTO"); //DeviceId from "adb devices" command
        cap.setCapability("deviceName", "emulator-5556");
//        cap.setCapability("udid", "emulator-5556"); //DeviceId from "adb devices" command
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "7.0");
        cap.setCapability("skipUnlock","true");
        //cap.setCapability("appPackage", "pl.kamsoft.wizyta");
        cap.setCapability("appPackage", "com.eworld.mobile");
        //cap.setCapability("appActivity","pl.kamsoft.wizytalibrary.Activities.SplashScreenActivity");
        //MainActivity
        cap.setCapability("appActivity","com.eworld.mobile.activities.MainActivity");
        cap.setCapability("noReset","false");
        //cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("autoGrantPermissions", "true");
        //cap.setCapability("language", "pl");


        WebDriver driver = null;

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            //driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), options);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("---------Driver = null - problem during chrome init in DriverManager");
        }

        return driver;
    }

    private WebDriver getFirefoxDriver()
    {
        FirefoxOptions options = new FirefoxOptions();
        FirefoxProfile myProfile = new FirefoxProfile();
        myProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
        myProfile.setPreference("pdfjs.disabled", true);
        myProfile.setPreference("browser.download.folderList", 2);
        myProfile.setPreference("browser.download.manager.showWhenStarting", false);
        myProfile.setPreference("browser.download.dir", System.getProperty("user.dir") + "\\screenShots");
        options.setProfile(myProfile);
        options.setHeadless(true);
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");


        WebDriver driver = null;

        try {
            driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), options);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("---------Driver = null - problem during firefox init in DriverManager");
        }

        return driver;
    }




}
