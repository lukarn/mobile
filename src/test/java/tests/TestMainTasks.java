package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import utilities.DriverManager;


public class TestMainTasks
{
    public static WebDriver driver;

    //from Jenkins
//    private String envLoginPage = System.getenv("LOGIN_PAGE");
//    private String envLoginLogin = System.getenv("LOGIN_LOGIN");
//    private String envLoginPassword = System.getenv("LOGIN_PASSWORD");
//    private int envTimeoutIsAt = Integer.parseInt(System.getenv("TEST_TIMEOUT"));

    //from here
    private String envHomeCountryOrCurrency = "Poland";
    private String envFirstExchange = "USD";
    private String envSecondExchange = "EUR";
    private String envThirdExchange = "Switzerland";
    private int envTimeoutIsAt = 60;

    // Page Objects
    private BasePage basePage;


    @DataProvider
    public Object[][] getData()
    {
        return new Object[][]{
                {1, envHomeCountryOrCurrency, "android7emulator"},
//                {2, envHomeCountryOrCurrency, "android9LGQ7realDevice"},
        };
    }

    @BeforeSuite()
    public void BeforeSuite()
    {
        System.out.println("==============================================");
        System.out.println("=Test suite parameters(env. variables)       =");
        System.out.println("==============================================");
        System.out.println("=envHomeCountryOrCurrency: " + envHomeCountryOrCurrency);
        System.out.println("=envFirstExchange: " + envFirstExchange);
        System.out.println("=envSecondExchange: " + envSecondExchange);
        System.out.println("=envThirdExchange: " + envThirdExchange);
        System.out.println("=timeoutIsAt: " + envTimeoutIsAt);
        System.out.println("==============================================");
    }

    @AfterMethod()
    public void AfterMethod()
    {
        if(driver != null)
        {
            driver.quit();
        }
        else
        {
            System.out.println("Something is wrong ---> driver = null in AfterMethod");
        }
    }

    //  , dependsOnMethods = { "loginCorrect" }
    //  , priority=1
    //  , enabled = false
    @Test(dataProvider="getData", enabled = false)
    public void launch(int p1, String p2, String p3) {
        // setup driver
        DriverManager driverManager = new DriverManager(driver);
        //usingBrowser=p3;
        driver = driverManager.getDriver(p3);

        //get to base page (from data provider)
        //driver.get(p2);
        System.out.println("-------testing www no. " + p1 + " : " + p2 + " on " + p3);

        // Page Object - assign
        basePage = new BasePage(driver);

        Assert.assertTrue(basePage.isAt(envTimeoutIsAt), "----------BasePage not loaded!");

    }

    @Test(dataProvider="getData")
    public void comb1(int p1, String p2, String p3) {
        launch(p1, p2, p3);

        basePage.setSelectedCurrency(envHomeCountryOrCurrency)
                .setFirstExchange(envFirstExchange)
                .setSecondExchange(envSecondExchange)
                .setThirdExchange(envThirdExchange);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @Test(dataProvider="getData")
    public void comb2(int p1, String p2, String p3) {
        launch(p1, p2, p3);

        basePage.setSelectedCurrency(envFirstExchange)
                .setFirstExchange(envHomeCountryOrCurrency)
                .setSecondExchange(envSecondExchange)
                .setThirdExchange(envThirdExchange);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    @Test(dataProvider="getData")
    public void comb3(int p1, String p2, String p3) {
        launch(p1, p2, p3);

        basePage.setSelectedCurrency(envSecondExchange)
                .setFirstExchange(envHomeCountryOrCurrency)
                .setSecondExchange(envFirstExchange)
                .setThirdExchange(envThirdExchange);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    @Test(dataProvider="getData")
    public void comb4(int p1, String p2, String p3) {
        launch(p1, p2, p3);

        basePage.setSelectedCurrency(envThirdExchange)
                .setFirstExchange(envHomeCountryOrCurrency)
                .setSecondExchange(envSecondExchange)
                .setThirdExchange(envFirstExchange);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



}
