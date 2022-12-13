package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder = 'First Name']")
    WebElement firstNameField ;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder = 'Last Name']" )
    WebElement lastNameField ;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder = 'Post Code']")
    WebElement postCodeField ;

    @CacheLookup
    @FindBy(xpath = "//button[text()= 'Add Customer']")
    WebElement addCustomerButton ;


    public void enterFirstName(String text) {
        Reporter.log("Enter name in the First Name Field " + firstNameField.toString());
        sendTextToElement(firstNameField, text);
    }

    public void enterLastName(String text) {
        Reporter.log("Enter surname in the Last Name Field " + lastNameField.toString());
        sendTextToElement(lastNameField, text);
    }

    public void enterPostCode(String text) {
        Reporter.log("Enter postcode in the Postcode Field " + postCodeField.toString());
        sendTextToElement(postCodeField, text);
    }

    public void clickOnAddCustomerButton() {
        Reporter.log("Click on Add Customer button " + addCustomerButton.toString());
        clickOnElement(addCustomerButton);
    }

    public String verifyPopUpDisplayMessage() {
        Reporter.log("Verifying Pop up display message");
        return getTextFromAlert();
    }

    public void clickOnOkOnPopUp() {
        Reporter.log("click on Ok on pop " + firstNameField.toString());
        acceptAlert();
    }


}
