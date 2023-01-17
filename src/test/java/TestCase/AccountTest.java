package TestCase;

import Setup.baseSetUp.BaseTest;
import Setup.project.dataprovider.Account.AccountDataProvider;
import Setup.project.dataprovider.Account.EditAccountDataProvider;
import Setup.project.pages.Account.AccountPage;
import Setup.project.pages.Account.EditAccountPage;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AccountTest extends BaseTest {

    AccountPage accountPage;
    EditAccountPage editAccountPage;
    public AccountTest() {
        accountPage = new AccountPage();
        editAccountPage = new EditAccountPage();
    }

    @Test(priority = 1, dataProvider = "getAccountDataHashTable", dataProviderClass = AccountDataProvider.class)
    public void testSignUp_SignInSuccessfully(Hashtable<String, String> data) {
        accountPage.signUpSuccessfully(1);
        editAccountPage.verifyCreatedAccount(1);
        accountPage.signOutAccount(1);
        accountPage.signInSuccessfullyByCreatedAccount(1);
    }

    @Test(priority = 2, dataProvider = "getEditAccountDataHashTable", dataProviderClass = EditAccountDataProvider.class)
    public void testEditContactInfo_Address(Hashtable<String, String> data) {
        accountPage.signInSuccessfullyByCreatedAccount(1);
        editAccountPage.editConTactInfo(1);
        accountPage.signInSuccessfullyAfterEditingEmailAndPassword(1);
        editAccountPage.editAddress(1);
        editAccountPage.verifyEditedAddress(1);
    }

    @Test(priority = 3, dataProvider = "getAccountDataHashTable", dataProviderClass = AccountDataProvider.class)
    public void signInFailure(Hashtable<String, String> data) {
        accountPage.signInFailure(2);
    }

    @Test(priority = 4, dataProvider = "getAccountDataHashTable", dataProviderClass = AccountDataProvider.class)
    public void signUpFailureWithEmptyData(Hashtable<String, String> data) {
        accountPage.signUpFailure(3);
    }

    @Test(priority = 5, dataProvider = "getAccountDataHashTable", dataProviderClass = AccountDataProvider.class)
    public void signUpFailureWithExistedData(Hashtable<String, String> data) {
        accountPage.signUpFailure(4);
    }

}

