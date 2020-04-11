package pages;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;

import io.appium.java_client.pagefactory.AndroidFindBys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage extends Page {

    @Override
    public boolean isAt(){
        return this.selectedCurrency.isDisplayed();
    }


    @AndroidFindBy(id = "tiny.exchangerate:id/md_buttonDefaultNegative")
    private WebElement cancelButton;

    //

//    @AndroidFindBys({
//        @AndroidBy(id = "tiny.exchangerate:id/selectedRowView"),
//        @AndroidBy(id = "tiny.exchangerate:id/selectedFlagContainer")
//    })
//    private List<WebElement> firstCurrency;
    @AndroidFindBy(id = "tiny.exchangerate:id/selectedFlagContainer")
    private WebElement selectedCurrency;

    @AndroidFindBy(id = "tiny.exchangerate:id/action_search")
    private WebElement searchButton;

    @AndroidFindBy(id = "tiny.exchangerate:id/searchEditText")
    private WebElement searchCountry;

    @AndroidFindBy(id = "tiny.exchangerate:id/flagTextView")
    private WebElement fistFlagTextView;


    @AndroidFindBy(id = "tiny.exchangerate:id/symbol")
    private List<WebElement> secondCurrency;

    @AndroidFindBy(id = "tiny.exchangerate:id/result")
    private List<WebElement> rowList3Amount;


//    @AndroidFindBy(id = "tiny.exchangerate:id/selectedSymbol")
//    private WebElement secondCurrency;

    public BasePage(WebDriver driver)
    {
        super(driver);
    }

    //clickElement(this.cancelButton);

    public BasePage setSelectedCurrency(String countryOrCurrency){
        clickElement(this.selectedCurrency);
        clickElement(this.searchButton);
        clickElement(this.searchCountry);
        this.searchCountry.sendKeys(countryOrCurrency);
        clickElement(this.fistFlagTextView);
        return this;
    }

    public BasePage setFirstExchange(String countryOrCurrency){
        clickElement(this.secondCurrency.get(0));
        clickElement(this.searchButton);
        clickElement(this.searchCountry);
        this.searchCountry.sendKeys(countryOrCurrency);
        clickElement(this.fistFlagTextView);
        return this;
    }

    public BasePage setSecondExchange(String countryOrCurrency){
        clickElement(this.secondCurrency.get(1));
        clickElement(this.searchButton);
        clickElement(this.searchCountry);
        this.searchCountry.sendKeys(countryOrCurrency);
        clickElement(this.fistFlagTextView);
        return this;
    }

    public BasePage setThirdExchange(String countryOrCurrency){
        clickElement(this.secondCurrency.get(2));
        clickElement(this.searchButton);
        clickElement(this.searchCountry);
        this.searchCountry.sendKeys(countryOrCurrency);
        clickElement(this.fistFlagTextView);
        return this;
    }




    public double getSelectedAmount(String currency){

        System.out.println("Have " + this.rowList3Amount.get(0).getText() + " [country/currency = " + currency + " ]");
        return Double.parseDouble( this.rowList3Amount.get(0).getText().replace(",",".") );

    }

    public double getRowList1Amount(String currency){

        System.out.println("Could buy " + this.rowList3Amount.get(1).getText() + " [country/currency = " + currency + " ]");
        return Double.parseDouble( this.rowList3Amount.get(1).getText().replace(",",".") );

    }

    public double getRowList2Amount(String currency){

        System.out.println("Could buy " + this.rowList3Amount.get(2).getText() + " [country/currency = " + currency + " ]");
        return Double.parseDouble( this.rowList3Amount.get(2).getText().replace(",",".") );

    }


    public double getRowList3Amount(String currency){

        System.out.println("Could buy " + this.rowList3Amount.get(3).getText() + " [country/currency = " + currency + " ]");
        return Double.parseDouble( this.rowList3Amount.get(3).getText().replace(",",".") );

    }







}
