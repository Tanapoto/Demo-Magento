package Setup.project.pages.Account;

import Common.constants.FrameworkConstants;
import Common.handle.WebUI;
import Common.helpers.ExcelHelpers;
import Common.utilities.ObjectUtils;
import Setup.project.modals.Account.AccountModal;
import Setup.project.modals.Account.EditAccountModal;
import Setup.project.pages.Home.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class EditAccountPage {
    public By customerMenu = ObjectUtils.getByLocatorFromConfig("customerMenu");
    public By btnMyAccount = ObjectUtils.getByLocatorFromConfig("btnMyAccount");
    public By btnOpenEditContact = ObjectUtils.getByLocatorFromConfig("btnOpenEditContact");
    public By btnOpenChangePass = ObjectUtils.getByLocatorFromConfig("btnOpenChangePass");
    public By btnOpenSignUp = ObjectUtils.getByLocatorFromConfig("btnOpenSignUp");
    public By btnOpenAddAddress = ObjectUtils.getByLocatorFromConfig("btnOpenAddAddress");
    public By editFirstName = ObjectUtils.getByLocatorFromConfig("editFirstName");
    public By editLastName = ObjectUtils.getByLocatorFromConfig("editLastName");
    public By changeEmail = ObjectUtils.getByLocatorFromConfig("changeEmail");
    public By changePassword = ObjectUtils.getByLocatorFromConfig("changePassword");
    public By editAllowAssistance = ObjectUtils.getByLocatorFromConfig("editAllowAssistance");
    public By editEmailSignUp = ObjectUtils.getByLocatorFromConfig("editEmailSignUp");
    public By currentPasswordSignUp = ObjectUtils.getByLocatorFromConfig("currentPasswordSignUp");
    public By editPasswordSignUp = ObjectUtils.getByLocatorFromConfig("editPasswordSignUp");
    public By editConfirmPasswordSignUp = ObjectUtils.getByLocatorFromConfig("editConfirmPasswordSignUp");
    public By btnSaveEditAccount = ObjectUtils.getByLocatorFromConfig("btnSaveEditAccount");
    public By savingEditAccountContents = ObjectUtils.getByLocatorFromConfig("savingEditAccountContents");
    public By editCompany = ObjectUtils.getByLocatorFromConfig("editCompany");
    public By editPhoneNumber = ObjectUtils.getByLocatorFromConfig("editPhoneNumber");
    public By editStressAddress1 = ObjectUtils.getByLocatorFromConfig("editStressAddress1");
    public By editStressAddress2 = ObjectUtils.getByLocatorFromConfig("editStressAddress2");
    public By editStressAddress3 = ObjectUtils.getByLocatorFromConfig("editStressAddress3");
    public By editCountry = ObjectUtils.getByLocatorFromConfig("editCountry");
    public By editProvince = ObjectUtils.getByLocatorFromConfig("editProvince");
    public By editCity = ObjectUtils.getByLocatorFromConfig("editCity");
    public By editZipcode = ObjectUtils.getByLocatorFromConfig("editZipcode");
    public By editSaveAddress = ObjectUtils.getByLocatorFromConfig("editSaveAddress");
    public By editedAddress = ObjectUtils.getByLocatorFromConfig("editedAddress");

    ExcelHelpers excelHelpers;
    public EditAccountPage() {
        excelHelpers = new ExcelHelpers();
    }

    public AccountPage verifyCreatedAccount(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Account");
        WebUI.clickElement(btnOpenEditContact);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(1, AccountModal.getEditContactInfoUrl())));
        Assert.assertTrue(WebUI.verifyElementAttributeValue(editFirstName,"value",excelHelpers.getCellData(1,AccountModal.getFirstName())));
        Assert.assertTrue(WebUI.verifyElementAttributeValue(editLastName,"value",excelHelpers.getCellData(1,AccountModal.getLastName())));
        WebUI.clickElement(changeEmail);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(editEmailSignUp,"value",excelHelpers.getCellData(1,AccountModal.getEmail())));
        return new AccountPage();
    }

    public AccountPage editConTactInfo(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Account");
        WebUI.clickElement(customerMenu);
        WebUI.clickElement(btnMyAccount);
        WebUI.clickElement(btnOpenEditContact);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(1, EditAccountModal.getUrlEditContactInfo())));

        WebUI.clearText(editFirstName);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(editFirstName,"aria-required","true"));
        WebUI.setText(editFirstName,excelHelpers.getCellData(numRow,EditAccountModal.getEditFirstName()));

        WebUI.clearText(editLastName);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(editLastName,"aria-required","true"));
        WebUI.setText(editLastName,excelHelpers.getCellData(numRow,EditAccountModal.getEditLastName()));

        Assert.assertFalse(WebUI.verifyElementSelected(changeEmail));
        WebUI.clickElement(changeEmail);
        Assert.assertTrue(WebUI.verifyElementSelected(changeEmail));
        WebUI.clickElement(changeEmail);
        Assert.assertFalse(WebUI.verifyElementSelected(changeEmail));
        WebUI.clickElement(changeEmail);

        Assert.assertFalse(WebUI.verifyElementSelected(changePassword));
        WebUI.clickElement(changePassword);
        Assert.assertTrue(WebUI.verifyElementSelected(changePassword));
        WebUI.clickElement(changePassword);
        Assert.assertFalse(WebUI.verifyElementSelected(changePassword));
        WebUI.clickElement(changePassword);

        Assert.assertFalse(WebUI.verifyElementSelected(editAllowAssistance));
        WebUI.clickElement(editAllowAssistance);
        Assert.assertTrue(WebUI.verifyElementSelected(editAllowAssistance));
        WebUI.clickElement(editAllowAssistance);
        Assert.assertFalse(WebUI.verifyElementSelected(editAllowAssistance));
        WebUI.clickElement(editAllowAssistance);

        WebUI.clearText(editEmailSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(editEmailSignUp,"aria-required","true"));
        WebUI.setText(editEmailSignUp,excelHelpers.getCellData(numRow,EditAccountModal.getEditEmail()));

        WebUI.clearText(currentPasswordSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(currentPasswordSignUp,"aria-required","true"));
        WebUI.setText(currentPasswordSignUp,excelHelpers.getCellData(numRow,EditAccountModal.getCurrentPassword()));

        WebUI.clearText(editPasswordSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(editPasswordSignUp,"aria-required","true"));
        WebUI.setText(editPasswordSignUp,excelHelpers.getCellData(numRow,EditAccountModal.getNewPassword()));

        WebUI.clearText(editConfirmPasswordSignUp);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(editConfirmPasswordSignUp,"aria-required","true"));
        WebUI.setText(editConfirmPasswordSignUp,excelHelpers.getCellData(numRow,EditAccountModal.getConfirmNewPassword()));

        WebUI.clickElement(btnSaveEditAccount);
        Assert.assertTrue(WebUI.verifyElementExists(savingEditAccountContents));
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(1,EditAccountModal.getUrlSignIn())));
        return new AccountPage();
    }

    public AccountPage editAddress(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Account");
        WebUI.clickElement(customerMenu);
        WebUI.clickElement(btnMyAccount);
        WebUI.clickElement(btnOpenAddAddress);
        Assert.assertTrue(WebUI.verifyPageUrlContain(excelHelpers.getCellData(1, EditAccountModal.getUrlEditAddress())));

        WebUI.clearText(editCompany);
        WebUI.setText(editCompany,excelHelpers.getCellData(numRow,EditAccountModal.getEditCompany()));

        WebUI.clearText(editPhoneNumber);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(editPhoneNumber,"aria-required","true"));
        WebUI.setText(editPhoneNumber,excelHelpers.getCellData(numRow,EditAccountModal.getEditPhoneNumber()));

        WebUI.clearText(editStressAddress1);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(editStressAddress1,"aria-required","true"));
        WebUI.setText(editStressAddress1,excelHelpers.getCellData(numRow,EditAccountModal.getEditStress1()));

        WebUI.clearText(editStressAddress2);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(editStressAddress2,"aria-required","true"));
        WebUI.setText(editStressAddress2,excelHelpers.getCellData(numRow,EditAccountModal.getEditStress2()));

        WebUI.clearText(editStressAddress3);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(editStressAddress3,"aria-required","true"));
        WebUI.setText(editStressAddress3,excelHelpers.getCellData(numRow,EditAccountModal.getEditStress3()));

        WebUI.selectOptionByText(editCountry,"Benin");
        WebUI.selectOptionByText(editCountry,"Cyprus");
        WebUI.selectOptionByText(editCountry,"Turkmenistan");

        WebUI.clearText(editProvince);
        WebUI.setText(editProvince,excelHelpers.getCellData(numRow,EditAccountModal.getEditProvince()));

        WebUI.clearText(editCity);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(editCity,"aria-required","true"));
        WebUI.setText(editCity,excelHelpers.getCellData(numRow,EditAccountModal.getEditCity()));

        WebUI.clearText(editZipcode);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(editZipcode,"aria-required","true"));
        WebUI.setText(editZipcode,excelHelpers.getCellData(numRow,EditAccountModal.getEditZipCode()));

        WebUI.clickElement(editSaveAddress);
        Assert.assertTrue(WebUI.verifyElementExists(savingEditAccountContents));
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(1,EditAccountModal.getUrlAddressBook())));

       return new AccountPage();
    }

    public AccountPage verifyEditedAddress(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Account");
        Assert.assertTrue(WebUI.verifyElementTextContains(editedAddress,excelHelpers.getCellData(1,EditAccountModal.getEditFirstName())));
        Assert.assertTrue(WebUI.verifyElementTextContains(editedAddress,excelHelpers.getCellData(1,EditAccountModal.getEditLastName())));
        Assert.assertTrue(WebUI.verifyElementTextContains(editedAddress,excelHelpers.getCellData(1,EditAccountModal.getEditCompany())));
        Assert.assertTrue(WebUI.verifyElementTextContains(editedAddress,excelHelpers.getCellData(1,EditAccountModal.getEditStress1())));
        Assert.assertTrue(WebUI.verifyElementTextContains(editedAddress,excelHelpers.getCellData(1,EditAccountModal.getEditPhoneNumber())));
        Assert.assertTrue(WebUI.verifyElementTextContains(editedAddress,excelHelpers.getCellData(1,EditAccountModal.getEditStress1())));
        Assert.assertTrue(WebUI.verifyElementTextContains(editedAddress,excelHelpers.getCellData(1,EditAccountModal.getEditStress2())));
        Assert.assertTrue(WebUI.verifyElementTextContains(editedAddress,excelHelpers.getCellData(1,EditAccountModal.getEditStress3())));
        Assert.assertTrue(WebUI.verifyElementTextContains(editedAddress,excelHelpers.getCellData(1,EditAccountModal.getEditProvince())));
        Assert.assertTrue(WebUI.verifyElementTextContains(editedAddress,excelHelpers.getCellData(1,EditAccountModal.getEditCity())));
        Assert.assertTrue(WebUI.verifyElementTextContains(editedAddress,excelHelpers.getCellData(1,EditAccountModal.getEditZipCode())));
        return new AccountPage();
    }

}
