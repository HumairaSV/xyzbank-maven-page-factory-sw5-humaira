package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLoginTab;

    @CacheLookup
    @FindBy(xpath = "//button[text()= 'Customer Login']")
    WebElement customerLoginTab;

    public void clickOnBankManagerLoginTab() {
        clickOnElement(bankManagerLoginTab);
    }

    public void clickOnCustomerLoginTab() {
        clickOnElement(customerLoginTab);
    }

}
