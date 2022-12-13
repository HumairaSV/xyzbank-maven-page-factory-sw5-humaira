package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BankManagerLoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[@ng-click = 'addCust()']")
    WebElement addCustomerTab;

    @CacheLookup
    @FindBy(xpath = "//button[@ng-click= 'openAccount()']")
    WebElement openAccountTab;


    public void clickOnAddCustomerTab() {
        clickOnElement(addCustomerTab);
    }

    public void clickOpenAccountTab() {
        clickOnElement(openAccountTab);
    }
}
