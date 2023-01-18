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
    public By btnOpenEditAddress = ObjectUtils.getByLocatorFromConfig("btnOpenEditAddress");
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
    public By defaultBillingAddress = ObjectUtils.getByLocatorFromConfig("defaultBillingAddress");
    public By defaultShippingAddress = ObjectUtils.getByLocatorFromConfig("defaultShippingAddress");

    public By btnOpenNewsSub = ObjectUtils.getByLocatorFromConfig("btnOpenNewsSub");
    public By isSubContent = ObjectUtils.getByLocatorFromConfig("isSubContent");
    public By btnSubNews = ObjectUtils.getByLocatorFromConfig("btnSubNews");
    public By btnSaveSub = ObjectUtils.getByLocatorFromConfig("btnSaveSub");
    public By btnOpenManageAddress = ObjectUtils.getByLocatorFromConfig("btnOpenManageAddress");
    public By btnDeleteAddress = ObjectUtils.getByLocatorFromConfig("btnDeleteAddress");
    public By btnEditAddress = ObjectUtils.getByLocatorFromConfig("btnEditAddress");
    public By modalConfirmDelete = ObjectUtils.getByLocatorFromConfig("modalConfirmDelete");
    public By btnCancelDelete = ObjectUtils.getByLocatorFromConfig("btnCancelDelete");
    public By btnConfirmDelete = ObjectUtils.getByLocatorFromConfig("btnConfirmDelete");
    public By messDeleteSuccessfully = ObjectUtils.getByLocatorFromConfig("messDeleteSuccessfully");
    public By setDefaultBillingAddress = ObjectUtils.getByLocatorFromConfig("setDefaultBillingAddress");
    public By setDefaultShippingAddress = ObjectUtils.getByLocatorFromConfig("setDefaultShippingAddress");
    public By countNumberAddress = ObjectUtils.getByLocatorFromConfig("countNumberAddress");


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
    public AccountPage checkSubNews() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Account");
        WebUI.clickElement(customerMenu);
        WebUI.clickElement(btnMyAccount);
        WebUI.clickElement(btnOpenNewsSub);
        Assert.assertTrue(WebUI.verifyPageUrlContain(excelHelpers.getCellData(1, EditAccountModal.getUrlEditSub())));

        Assert.assertFalse(WebUI.verifyElementSelected(btnSubNews));
        WebUI.clickElement(btnSubNews);
        Assert.assertTrue(WebUI.verifyElementSelected(btnSubNews));
        WebUI.clickElement(btnSubNews);
        Assert.assertFalse(WebUI.verifyElementSelected(btnSubNews));
        WebUI.clickElement(btnSubNews);
        WebUI.clickElement(btnSaveSub);
        Assert.assertTrue(WebUI.verifyElementTextContains(isSubContent,"are subscribed"));
        return new AccountPage();
    }
    public AccountPage uncheckSubNews() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Account");
        WebUI.clickElement(btnOpenNewsSub);
        Assert.assertTrue(WebUI.verifyPageUrlContain(excelHelpers.getCellData(1, EditAccountModal.getUrlEditSub())));

        Assert.assertTrue(WebUI.verifyElementSelected(btnSubNews));
        WebUI.clickElement(btnSubNews);
        Assert.assertFalse(WebUI.verifyElementSelected(btnSubNews));
        WebUI.clickElement(btnSaveSub);
        Assert.assertTrue(WebUI.verifyElementTextContains(isSubContent,"aren't subscribed"));
        return new AccountPage();
    }
    public AccountPage editAddressAndSetDefaultAddress(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Account");
        WebUI.clickElement(customerMenu);
        WebUI.clickElement(btnMyAccount);
        WebUI.clickElement(btnOpenEditAddress);
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
    public AccountPage addNewAddressAndSetDefaultAddress(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Account");

        WebUI.clickElement(customerMenu);
        WebUI.clickElement(btnMyAccount);
        WebUI.clickElement(btnOpenManageAddress);
        WebUI.clickElement(btnOpenAddAddress);
        Assert.assertTrue(WebUI.verifyPageUrlContain(excelHelpers.getCellData(numRow, EditAccountModal.getUrlAddAddress())));

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

        Assert.assertFalse(WebUI.verifyElementSelected(setDefaultBillingAddress));
        WebUI.clickElement(setDefaultBillingAddress);
        Assert.assertTrue(WebUI.verifyElementSelected(setDefaultBillingAddress));
        Assert.assertFalse(WebUI.verifyElementSelected(setDefaultShippingAddress));
        WebUI.clickElement(setDefaultShippingAddress);
        Assert.assertTrue(WebUI.verifyElementSelected(setDefaultShippingAddress));

        WebUI.clickElement(editSaveAddress);
        Assert.assertTrue(WebUI.verifyElementExists(savingEditAccountContents));
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(numRow,EditAccountModal.getUrlAddressBook())));

        return new AccountPage();
    }
    public AccountPage verifyEditedDefaultBillingAddress(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Account");

       Assert.assertTrue(WebUI.verifyElementTextContains(defaultBillingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditCompany())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultBillingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditStress1())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultBillingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditPhoneNumber())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultBillingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditStress1())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultBillingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditStress2())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultBillingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditStress3())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultBillingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditProvince())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultBillingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditCity())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultBillingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditZipCode())));
        return new AccountPage();
    }
    public AccountPage verifyEditedDefaultShippingAddress(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Account");

       Assert.assertTrue(WebUI.verifyElementTextContains(defaultShippingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditCompany())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultShippingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditStress1())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultShippingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditPhoneNumber())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultShippingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditStress1())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultShippingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditStress2())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultShippingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditStress3())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultShippingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditProvince())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultShippingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditCity())));
        Assert.assertTrue(WebUI.verifyElementTextContains(defaultShippingAddress,excelHelpers.getCellData(numRow,EditAccountModal.getEditZipCode())));
        return new AccountPage();
    }
    public AccountPage deleteAddress(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Account");
        WebUI.clickElement(customerMenu);
        WebUI.clickElement(btnMyAccount );
        WebUI.clickElement(btnOpenManageAddress);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(numRow,EditAccountModal.getUrlManageAddress())));
        Assert.assertTrue(WebUI.verifyElementExists(countNumberAddress));

        WebUI.clickElement(btnDeleteAddress);
        Assert.assertTrue(WebUI.verifyElementExists(modalConfirmDelete));
        WebUI.clickElement(btnCancelDelete);
        Assert.assertFalse(WebUI.verifyElementExists(modalConfirmDelete));
        WebUI.clickElement(btnDeleteAddress);
        Assert.assertTrue(WebUI.verifyElementExists(modalConfirmDelete));
        WebUI.clickElement(btnConfirmDelete);
        Assert.assertTrue(WebUI.verifyElementExists(messDeleteSuccessfully));

        return new AccountPage();
    }
}
