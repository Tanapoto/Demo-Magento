package Setup.project.pages.Account;

import Common.constants.FrameworkConstants;
import Common.handle.WebUI;
import Common.helpers.ExcelHelpers;
import Common.utilities.ObjectUtils;
import Setup.project.modals.Account.*;
import Setup.project.pages.Home.*;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AccountPage {

    public By btnOpenSignUp = ObjectUtils.getByLocatorFromConfig("btnOpenSignUp");
    public By btnOpenSignIn = ObjectUtils.getByLocatorFromConfig("btnOpenSignIn");
    public By firstName = ObjectUtils.getByLocatorFromConfig("firstName");
    public By lastName = ObjectUtils.getByLocatorFromConfig("lastName");
    public By isSubscribed = ObjectUtils.getByLocatorFromConfig("isSubscribed");
    public By allowAssistance = ObjectUtils.getByLocatorFromConfig("allowAssistance");
    public By emailSignUp = ObjectUtils.getByLocatorFromConfig("emailSignUp");
    public By passwordSignUp = ObjectUtils.getByLocatorFromConfig("passwordSignUp");
    public By confirmPasswordSignUp = ObjectUtils.getByLocatorFromConfig("confirmPasswordSignUp");
    public By buttonSignUp = ObjectUtils.getByLocatorFromConfig("buttonSignUp");

    public By inputLoginEmail = ObjectUtils.getByLocatorFromConfig("inputLoginEmail");
    public By inputLoginPassword = ObjectUtils.getByLocatorFromConfig("inputLoginPassword");
    public By alertErrorMessLogin = ObjectUtils.getByLocatorFromConfig("alertErrorMessLogin");
    public By btnSignIn = ObjectUtils.getByLocatorFromConfig("btnSignIn");
    public By customerMenu = ObjectUtils.getByLocatorFromConfig("customerMenu");
    public By btnSignOut = ObjectUtils.getByLocatorFromConfig("btnSignOut");





    ExcelHelpers excelHelpers;
    public AccountPage() {
        excelHelpers = new ExcelHelpers();
    }

    public HomePage signUpSuccessfully(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Account");
        WebUI.getURL(FrameworkConstants.URL_PROJECT);
        WebUI.clickElement(btnOpenSignUp);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(numRow, AccountModal.getSignUpPageUrl())));
        WebUI.clearText(firstName);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(firstName,"aria-required","true"));
        WebUI.setText(firstName,excelHelpers.getCellData(numRow,AccountModal.getFirstName()));
        WebUI.clearText(lastName);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(lastName,"aria-required","true"));
        WebUI.setText(lastName,excelHelpers.getCellData(numRow,AccountModal.getLastName()));
        Assert.assertFalse(WebUI.verifyElementSelected(isSubscribed));
        WebUI.clickElement(isSubscribed);
        Assert.assertTrue(WebUI.verifyElementSelected(isSubscribed));
        WebUI.clickElement(isSubscribed);
        Assert.assertFalse(WebUI.verifyElementSelected(isSubscribed));

        Assert.assertFalse(WebUI.verifyElementSelected(allowAssistance));
        WebUI.clickElement(allowAssistance);
        Assert.assertTrue(WebUI.verifyElementSelected(allowAssistance));
        WebUI.clickElement(allowAssistance);
        Assert.assertFalse(WebUI.verifyElementSelected(allowAssistance));


        WebUI.clearText(emailSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(emailSignUp,"aria-required","true"));
        WebUI.setText(emailSignUp,excelHelpers.getCellData(numRow,AccountModal.getEmail()));
        WebUI.clearText(passwordSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(passwordSignUp,"aria-required","true"));
        WebUI.setText(passwordSignUp,excelHelpers.getCellData(numRow,AccountModal.getPassword()));
        WebUI.clearText(confirmPasswordSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(confirmPasswordSignUp,"aria-required","true"));
        WebUI.setText(confirmPasswordSignUp,excelHelpers.getCellData(numRow,AccountModal.getConfirmPassword()));
        WebUI.clickElement(buttonSignUp);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(numRow, AccountModal.getAccountUrl())));
        return new HomePage();
    }

    public AccountPage signOutAccount(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Account");
        WebUI.clickElement(customerMenu);
        WebUI.clickElement(btnSignOut);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(numRow, AccountModal.getSignOutPageUrl())));
        WebUI.sleep(6);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(numRow, AccountModal.getHomePageUrl())));
        return new AccountPage();
    }

    public HomePage signInSuccessfullyByCreatedAccount(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Account");
        WebUI.clickElement(btnOpenSignIn);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(numRow, AccountModal.getSignInPageUrl())));
        WebUI.clearText(inputLoginEmail);
        WebUI.clearText(inputLoginPassword);
        WebUI.setText(inputLoginEmail,excelHelpers.getCellData(numRow, AccountModal.getEmail()));
        WebUI.setText(inputLoginPassword, excelHelpers.getCellData(numRow, AccountModal.getPassword()));
        WebUI.clickElement(btnSignIn);
        WebUI.waitForPageLoaded();
        Assert.assertFalse(WebUI.verifyElementExists(alertErrorMessLogin));
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(numRow, AccountModal.getHomePageUrl())));
        return new HomePage();
    }

    public HomePage signInFailure(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Account");
        WebUI.getURL(FrameworkConstants.URL_PROJECT);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(numRow, AccountModal.getSignInPageUrl())));
        WebUI.clearText(inputLoginEmail);
        WebUI.clearText(inputLoginPassword);
        WebUI.setText(inputLoginEmail,excelHelpers.getCellData(numRow, AccountModal.getEmail()));
        WebUI.setText(inputLoginPassword, excelHelpers.getCellData(numRow, AccountModal.getPassword()));
        WebUI.clickElement(btnSignIn);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyElementExists(alertErrorMessLogin));
        Assert.assertFalse(WebUI.verifyPageUrl(excelHelpers.getCellData(numRow, AccountModal.getHomePageUrl())));
        return new HomePage();
    }

    public HomePage signUpFailure(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Account");
        WebUI.getURL(FrameworkConstants.URL_PROJECT);
        WebUI.clickElement(btnOpenSignUp);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(numRow, AccountModal.getSignUpPageUrl())));
        WebUI.clearText(firstName);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(firstName,"aria-required","true"));
        WebUI.setText(firstName,excelHelpers.getCellData(numRow,AccountModal.getFirstName()));
        WebUI.clearText(lastName);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(lastName,"aria-required","true"));
        WebUI.setText(lastName,excelHelpers.getCellData(numRow,AccountModal.getLastName()));

        Assert.assertFalse(WebUI.verifyElementSelected(isSubscribed));
        WebUI.clickElement(isSubscribed);
        Assert.assertTrue(WebUI.verifyElementSelected(isSubscribed));
        WebUI.clickElement(isSubscribed);
        Assert.assertFalse(WebUI.verifyElementSelected(isSubscribed));

        Assert.assertFalse(WebUI.verifyElementSelected(allowAssistance));
        WebUI.clickElement(allowAssistance);
        Assert.assertTrue(WebUI.verifyElementSelected(allowAssistance));
        WebUI.clickElement(allowAssistance);
        Assert.assertFalse(WebUI.verifyElementSelected(allowAssistance));

        WebUI.clearText(emailSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(emailSignUp,"aria-required","true"));
        WebUI.setText(emailSignUp,excelHelpers.getCellData(numRow,AccountModal.getEmail()));
        WebUI.clearText(passwordSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(passwordSignUp,"aria-required","true"));
        WebUI.setText(passwordSignUp,excelHelpers.getCellData(numRow,AccountModal.getPassword()));
        WebUI.clearText(confirmPasswordSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(confirmPasswordSignUp,"aria-required","true"));
        WebUI.setText(confirmPasswordSignUp,excelHelpers.getCellData(numRow,AccountModal.getConfirmPassword()));
        WebUI.clickElement(buttonSignUp);
        Assert.assertFalse(WebUI.verifyPageUrl(excelHelpers.getCellData(numRow, AccountModal.getAccountUrl())));
        return new HomePage();
    }




}
