package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[text()= 'Logout']")
    WebElement logoutTab;

    @CacheLookup
    @FindBy(xpath = "//button[@ng-click= 'deposit()']")
    WebElement depositTab;

    @CacheLookup
    @FindBy(xpath = "//button[@ng-click= 'withdrawl()']")
    WebElement withdrawalTab;

    @CacheLookup
    @FindBy(xpath = "//input[@ng-model= 'amount']")
    WebElement amountField;

    @CacheLookup
    @FindBy(xpath = "//input[@ng-model= 'amount']")
    WebElement amountFieldWithdraw;

    @CacheLookup
    @FindBy(xpath = "//button[text()= 'Deposit']")
    WebElement depositButton;

    @CacheLookup
    @FindBy(xpath = "//span[text()= 'Deposit Successful']")
    WebElement depositSuccessfulMessage;

    @CacheLookup
    @FindBy(xpath = "//button[text()= 'Withdraw']")
    WebElement withdrawButton;

    @CacheLookup
    @FindBy(xpath = "//span[text()= 'Transaction successful']")
    WebElement withdrawSuccessfulMessage;

    public boolean verifyLogoutTabIsDisplayed() {
        Reporter.log("Verifying Logout Tab is displayed" + logoutTab.toString());
        Boolean element = logoutTab.isDisplayed();
        return true;
    }

    public void clickOnLogOutButton() {
        Reporter.log("Clicking on Logout button" + logoutTab.toString());
        clickOnElement(logoutTab);
    }


    public void clickOnDepositTab() {
        Reporter.log("Clicking on Deposit Tab" + depositTab.toString());
        clickOnElement(depositTab);
    }

    public void clickOnWithdrawalTab() {
        Reporter.log("Clicking on Withdrawal Tab" + withdrawalTab.toString());
        clickOnElement(withdrawalTab);
    }

    public void enterAmount(String amt) {
        Reporter.log("Enter amount" + amountField.toString());
        sendTextToElement(amountField, amt);
    }

    public void enterAmountToWithdraw(String amt) {
        Reporter.log("Enter amount" + amountField.toString());
        sendTextToElement(amountFieldWithdraw, amt);
    }

    public void clickOnDepositButton() {
        Reporter.log("Clicking on Deposit button" + depositButton.toString());
        clickOnElement(depositButton);
    }

    public String verifyDepositSuccessful() {
        Reporter.log("Verifying Deposit is successful" + depositSuccessfulMessage.toString());
        return getTextFromElement(depositSuccessfulMessage);
    }

    public void clickOnWithdrawButton() {
        Reporter.log("Clicking on Withdraw button" + withdrawButton.toString());
        clickOnElement(withdrawButton);
    }

    public String verifyWithdrawSuccessful() {
        Reporter.log("Verifying that Withdrawal is successful" + withdrawSuccessfulMessage.toString());
        return getTextFromElement(withdrawSuccessfulMessage);
    }
}
