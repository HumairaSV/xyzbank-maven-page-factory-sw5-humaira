package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends Utility {

    @CacheLookup
    @FindBy(id = "userSelect")
    WebElement yourNameField;

    @CacheLookup
    @FindBy(xpath = "//button[text()= 'Login']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//label[text()= 'Your Name :']")
    WebElement yourNameText;


    public void searchAndSelectCustomerName(String text) {
        selectByVisibleTextFromDropDown(yourNameField, text);
    }


    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String verifyTextYourName() {
        return getTextFromElement(yourNameText);
    }
}
