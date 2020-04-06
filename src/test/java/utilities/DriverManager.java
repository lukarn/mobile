package utilities;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.URL;

public class DriverManager {

    private WebDriver driver;

    public DriverManager(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebDriver getDriver(String usingDevice)
    {
        if(usingDevice.equalsIgnoreCase("android7emulator"))
        {
            driver = getEmulatorDevice();
            System.out.println("testing emulator device - android 7.0 :)");
        }
        else if(usingDevice.equalsIgnoreCase("android9LGQ7realDevice"))
        {
            driver = getRealDeviceLG();
            System.out.println("testing real device - android 9.0 LGQ7 :)");
        }
        else {
            //other devices to implement!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            System.out.println("---------No config of device - need to implement in DriverManager ");
        }

        return driver;
    }

    private WebDriver getEmulatorDevice()
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

        cap.setCapability("deviceName", "emulator-5556");
        cap.setCapability("udid", "emulator-5556"); //DeviceId from "adb devices" command
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "7.0");
        cap.setCapability("skipUnlock","true");
        cap.setCapability("appPackage", "tiny.exchangerate");
        cap.setCapability("appActivity","tiny.exchangerate.ui.calculator.CalculatorActivity");
        cap.setCapability("noReset","true");
        cap.setCapability("automationName", "UiAutomator");
        cap.setCapability("autoGrantPermissions", "true");

        WebDriver driver = null;

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            //driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), options);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("---------Driver = null - problem during EmulatorDevice init in DriverManager");
        }

        return driver;
    }

    private WebDriver getRealDeviceLG()
    {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("udid", "LMQ610NR9D7LLJ7TTO"); //DeviceId from "adb devices" command
        cap.setCapability("deviceName", "LMQ610NR9D7LLJ7TTO");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "9.0");
        cap.setCapability("skipUnlock","true");
        cap.setCapability("appPackage", "tiny.exchangerate");
        cap.setCapability("appActivity","tiny.exchangerate.ui.calculator.CalculatorActivity");
        cap.setCapability("noReset","true");
        cap.setCapability("automationName", "UiAutomator");
        cap.setCapability("autoGrantPermissions", "true");


        WebDriver driver = null;

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
            //driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"), options);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("---------Driver = null - problem during RealDeviceLG init in DriverManager");
        }

        return driver;
    }




}
