package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class BasePage extends Page {

    @Override
    public boolean isAt(){
        return this.loginButton.isDisplayed();
    }

    //@AndroidFindBy(id = "pl.kamsoft.wizyta:id/demo_button")
    //@AndroidFindBy(xpath = "//*[@resource-id='login_section_btn']")
    @AndroidFindBy(id = "login_section_btn")
    private WebElement loginButton;


    @AndroidFindBy(id = "#bestForm>button[type='submit']")
    private WebElement zalogujButton;

    @AndroidFindBy(id = "registeredPlayerLogin")
    private WebElement loginInput;

    @AndroidFindBy(id = "registeredPlayerPassword")
    private WebElement passwordInput;

    /////////////////////////////////////////
    @AndroidFindBy(id = "tiny.exchangerate:id/md_buttonDefaultNegative")
    private WebElement cancelButton;

//    @AndroidFindBys({
//        @AndroidBy(id = "tiny.exchangerate:id/selectedRowView"),
//        @AndroidBy(id = "tiny.exchangerate:id/selectedFlagContainer")
//    })
//    private List<WebElement> firstCurrency;
    @AndroidFindBy(id = "tiny.exchangerate:id/selectedFlagContainer")
    private WebElement firstCurrency;

    @AndroidFindBy(id = "tiny.exchangerate:id/action_search")
    private WebElement searchButton;

    @AndroidFindBy(id = "tiny.exchangerate:id/searchEditText")
    private WebElement searchCountry;

    @AndroidFindBy(id = "tiny.exchangerate:id/flagTextView")
    private WebElement fistFlagTextView;


    @AndroidFindBy(id = "tiny.exchangerate:id/symbol")
    private List<WebElement> secondCurrency;




//    @AndroidFindBy(id = "tiny.exchangerate:id/selectedSymbol")
//    private WebElement secondCurrency;

    public BasePage(WebDriver driver)
    {
        super(driver);
    }


    public void setLoginButton()
    {
        //clickElement(this.cancelButton);
        //clickElement(this.firstCurrency.get(0));
        clickElement(this.firstCurrency);

        clickElement(this.searchButton);

        clickElement(this.searchCountry);

        this.searchCountry.sendKeys("Poland");

        clickElement(this.fistFlagTextView);

        //////////////////////
        clickElement(this.secondCurrency.get(0));

        clickElement(this.searchButton);

        clickElement(this.searchCountry);

        this.searchCountry.sendKeys("USA");

        clickElement(this.fistFlagTextView);

        //////////////////////
        clickElement(this.secondCurrency.get(1));

        clickElement(this.searchButton);

        clickElement(this.searchCountry);

        this.searchCountry.sendKeys("EUR");

        clickElement(this.fistFlagTextView);

        //////////////////////
        clickElement(this.secondCurrency.get(2));

        clickElement(this.searchButton);

        clickElement(this.searchCountry);

        this.searchCountry.sendKeys("Switzerland");

        clickElement(this.fistFlagTextView);





    }



    public BasePage setLoginInput(String text)
    {
        clickElement(this.loginInput);
        this.loginInput.clear();
        this.loginInput.sendKeys(text);
        return this;
    }

    public BasePage setPasswordInput(String text)
    {
        clickElement(this.passwordInput);
        this.passwordInput.clear();
        this.passwordInput.sendKeys(text);
        return this;
    }


}
