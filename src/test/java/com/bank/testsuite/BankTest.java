package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankTest extends BaseTest {

    HomePage homePage = new HomePage();
    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;
    public static String firstName = "Linda";
    public static String lastName = "Smith";

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customerLoginPage = new CustomerLoginPage();
        accountPage = new AccountPage();

    }

    public void openNewCustomerAccount(){
        homePage.clickOnBankManagerLoginTab();
        bankManagerLoginPage.clickOnAddCustomerTab();
        addCustomerPage.enterFirstName(firstName);
        addCustomerPage.enterLastName(lastName);
        addCustomerPage.enterPostCode("M12 9AW");
        addCustomerPage.clickOnAddCustomerButton();
        addCustomerPage.clickOnOkOnPopUp();
        bankManagerLoginPage.clickOpenAccountTab();
        openAccountPage.searchAndSelectCustomerNameCreated(firstName+" "+ lastName);
        openAccountPage.selectCurrency("Pound");
        openAccountPage.clickOnProcessButton();
        openAccountPage.clickOnOkOnPopUp();
        openAccountPage.clickOnHomePageTab();
    }


    @Test(groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {

        homePage.clickOnBankManagerLoginTab();
        bankManagerLoginPage.clickOnAddCustomerTab();
        addCustomerPage.enterFirstName(firstName);
        addCustomerPage.enterLastName(lastName);
        addCustomerPage.enterPostCode("M12 9AW");
        addCustomerPage.clickOnAddCustomerButton();
        Assert.assertTrue(addCustomerPage.verifyPopUpDisplayMessage().contains("Customer added successfully"), "Unable to confirm the pop up-Customer added successfully");
        addCustomerPage.clickOnOkOnPopUp();
    }

    @Test(groups = {"smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        homePage.clickOnBankManagerLoginTab();
        bankManagerLoginPage.clickOnAddCustomerTab();
        addCustomerPage.enterFirstName(firstName);
        addCustomerPage.enterLastName(lastName);
        addCustomerPage.enterPostCode("M12 9AW");
        addCustomerPage.clickOnAddCustomerButton();
        addCustomerPage.clickOnOkOnPopUp();
        bankManagerLoginPage.clickOpenAccountTab();
        openAccountPage.searchAndSelectCustomerNameCreated(firstName + " " + lastName);
        openAccountPage.selectCurrency("Pound");
        openAccountPage.clickOnProcessButton();
        Assert.assertTrue(openAccountPage.getTextFromAlert().contains("Account created successfully"), "Unable to verify pop up - account has been created successfully");
        openAccountPage.clickOnOkOnPopUp();
    }
    @Test(groups = "regression")
    public void customerShouldLoginAndLogoutSuccessfully(){
        openNewCustomerAccount();
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.searchAndSelectCustomerName(firstName + " " + lastName);
        customerLoginPage.clickOnLoginButton();
        Assert.assertTrue(accountPage.verifyLogoutTabIsDisplayed(), "Logout Tab is not displayed");
        accountPage.clickOnLogOutButton();
        Assert.assertTrue(customerLoginPage.verifyTextYourName().contains("Your Name"), "Unable to verify your name text");

    }

    @Test(groups = "regression")
    public void customerShouldDepositMoneySuccessfully(){
        openNewCustomerAccount();
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.searchAndSelectCustomerName(firstName + " " + lastName);
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnDepositTab();
        accountPage.enterAmount("100");
        accountPage.clickOnDepositButton();
        Assert.assertEquals(accountPage.verifyDepositSuccessful(), "Deposit Successful","Unable to deposit successfully");

    }

    @Test(groups = "regression")
    public void customerShouldWithdrawMoneySuccessfully()throws InterruptedException{
        openNewCustomerAccount();
        homePage.clickOnCustomerLoginTab();
        customerLoginPage.searchAndSelectCustomerName(firstName + " " + lastName);
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnDepositTab();
        accountPage.enterAmount("100");
        accountPage.clickOnDepositButton();
        accountPage.clickOnWithdrawalTab();
        Thread.sleep(5000);
        accountPage.enterAmountToWithdraw("50");
        accountPage.clickOnWithdrawButton();
        Assert.assertEquals(accountPage.verifyWithdrawSuccessful(), "Transaction successful", "Unable to withdraw successfully");
    }
}
