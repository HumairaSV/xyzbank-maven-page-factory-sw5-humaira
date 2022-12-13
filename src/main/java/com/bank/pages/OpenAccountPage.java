package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class OpenAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerNameField;

    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyField;

    @CacheLookup
    @FindBy(xpath = "//button[text()= 'Process']")
    WebElement processButton;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Home')]")
    WebElement homepagetab;


    public void searchAndSelectCustomerNameCreated(String text){
        selectByVisibleTextFromDropDown(customerNameField, text);
    }

    public void selectCurrency(String text){
        selectByVisibleTextFromDropDown(currencyField, text);
    }

    public void clickOnProcessButton(){
        clickOnElement(processButton);
    }

    public void verifyPopUpDisplayMessage(){
        getTextFromAlert();
    }

    public void clickOnOkOnPopUp(){
        acceptAlert();
    }

    public void clickOnHomePageTab() {
        clickOnElement(homepagetab);
    }
}
