package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public abstract class Page {

    static AppiumDriver driver;
    static WebDriverWait wait;

    Page(WebDriver driver)
    {
        Page.driver = (AppiumDriver) driver;
        Page.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }




//    public Page(AppiumDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, 20);
//        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
//        g = new General(driver);
//    }

    public abstract boolean isAt();
    public boolean isAt(long timeout){
        try{
            await().atMost(timeout, TimeUnit.SECONDS).ignoreExceptions().until(this::isAt);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    void clickElement(WebElement clickLocator)
    {
        wait.until(ExpectedConditions.elementToBeClickable(clickLocator));

        String myTime = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        System.out.print(myTime + " Clicking locator: " + clickLocator);


        for(int i=0; i<10000; i++) {
            try {
                Thread.sleep(1);
                clickLocator.click();
                i=10000;
            } catch (Exception ignored) {
            }
        }

        System.out.println(" [OK]");
    }




}
