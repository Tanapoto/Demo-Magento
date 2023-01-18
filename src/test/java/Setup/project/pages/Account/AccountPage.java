package Setup.project.pages.Account;

import Common.constants.FrameworkConstants;
import Common.handle.WebUI;
import Common.helpers.ExcelHelpers;
import Common.utilities.DataGenerateUtils;
import Common.utilities.ObjectUtils;
import Setup.project.modals.Account.*;
import Setup.project.pages.Home.*;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AccountPage {

    public By btnOpenSignUp = ObjectUtils.getByLocatorFromConfig("btnOpenSignUp");
    public By btnOpenSignIn = ObjectUtils.getByLocatorFromConfig("btnOpenSignIn");
    public By inputFirstName = ObjectUtils.getByLocatorFromConfig("inputFirstName");
    public By inputLastName = ObjectUtils.getByLocatorFromConfig("inputLastName");
    public By isSubscribed = ObjectUtils.getByLocatorFromConfig("isSubscribed");
    public By allowAssistance = ObjectUtils.getByLocatorFromConfig("allowAssistance");
    public By inputEmailSignUp = ObjectUtils.getByLocatorFromConfig("inputEmailSignUp");
    public By inputPasswordSignUp = ObjectUtils.getByLocatorFromConfig("inputPasswordSignUp");
    public By inputConfirmPasswordSignUp = ObjectUtils.getByLocatorFromConfig("inputConfirmPasswordSignUp");
    public By buttonSignUp = ObjectUtils.getByLocatorFromConfig("buttonSignUp");
    public By alertErrorMessSignUp = ObjectUtils.getByLocatorFromConfig("alertErrorMessSignUp");

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
        WebUI.clearText(inputFirstName);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(inputFirstName,"aria-required","true"));
        WebUI.setText(inputFirstName,excelHelpers.getCellData(numRow,AccountModal.getFirstName()));
        WebUI.clearText(inputLastName);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(inputLastName,"aria-required","true"));
        WebUI.setText(inputLastName,excelHelpers.getCellData(numRow,AccountModal.getLastName()));
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

        WebUI.clearText(inputEmailSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(inputEmailSignUp,"aria-required","true"));
        WebUI.setText(inputEmailSignUp,excelHelpers.getCellData(numRow,AccountModal.getEmail()));
        WebUI.clearText(inputPasswordSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(inputPasswordSignUp,"aria-required","true"));
        WebUI.setText(inputPasswordSignUp,excelHelpers.getCellData(numRow,AccountModal.getPassword()));
        WebUI.clearText(inputConfirmPasswordSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(inputConfirmPasswordSignUp,"aria-required","true"));
        WebUI.setText(inputConfirmPasswordSignUp,excelHelpers.getCellData(numRow,AccountModal.getConfirmPassword()));
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
        WebUI.getURL(FrameworkConstants.URL_PROJECT);

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

    public HomePage signInSuccessfullyAfterEditingEmailAndPassword(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Account");
        WebUI.getURL(FrameworkConstants.URL_PROJECT);

        WebUI.clickElement(btnOpenSignIn);
        WebUI.clearText(inputLoginEmail);
        WebUI.clearText(inputLoginPassword);
        WebUI.setText(inputLoginEmail,excelHelpers.getCellData(numRow, EditAccountModal.getEditEmail()));
        WebUI.setText(inputLoginPassword, excelHelpers.getCellData(numRow, EditAccountModal.getNewPassword()));
        WebUI.clickElement(btnSignIn);
        WebUI.waitForPageLoaded();
        Assert.assertFalse(WebUI.verifyElementExists(alertErrorMessLogin));
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(numRow, EditAccountModal.getUrlHomePage())));
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
        WebUI.clearText(inputFirstName);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(inputFirstName,"aria-required","true"));
        WebUI.setText(inputFirstName,excelHelpers.getCellData(numRow,AccountModal.getFirstName()));
        WebUI.clearText(inputLastName);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(inputLastName,"aria-required","true"));
        WebUI.setText(inputLastName,excelHelpers.getCellData(numRow,AccountModal.getLastName()));

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

        WebUI.clearText(inputEmailSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(inputEmailSignUp,"aria-required","true"));
        WebUI.setText(inputEmailSignUp,excelHelpers.getCellData(numRow,AccountModal.getEmail()));
        WebUI.clearText(inputPasswordSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(inputPasswordSignUp,"aria-required","true"));
        WebUI.setText(inputPasswordSignUp,excelHelpers.getCellData(numRow,AccountModal.getPassword()));
        WebUI.clearText(inputConfirmPasswordSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(inputConfirmPasswordSignUp,"aria-required","true"));
        WebUI.setText(inputConfirmPasswordSignUp,excelHelpers.getCellData(numRow,AccountModal.getConfirmPassword()));
        WebUI.clickElement(buttonSignUp);
        Assert.assertFalse(WebUI.verifyPageUrl(excelHelpers.getCellData(numRow, AccountModal.getAccountUrl())));
        return new HomePage();
    }




}
