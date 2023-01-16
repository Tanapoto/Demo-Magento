package TestCase;

import Setup.baseSetUp.BaseTest;
import Setup.project.dataprovider.Account.AccountDataProvider;
import Setup.project.pages.Account.AccountPage;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AccountTest extends BaseTest {

    AccountPage accountPage;
    public AccountTest() {
        accountPage = new AccountPage();
    }

    @Test(priority = 1, dataProvider = "getAccountDataHashTable", dataProviderClass = AccountDataProvider.class)
    public void signInSuccessfully(Hashtable<String, String> data) {
        accountPage.signUpSuccessfully(1);
        accountPage.signOutAccount(1);
        accountPage.signInSuccessfullyByCreatedAccount(1);
    }

    @Test(priority = 2, dataProvider = "getAccountDataHashTable", dataProviderClass = AccountDataProvider.class)
    public void signInFailure(Hashtable<String, String> data) {
        accountPage.signInFailure(2);
    }

    @Test(priority = 3, dataProvider = "getAccountDataHashTable", dataProviderClass = AccountDataProvider.class)
    public void signUpFailure(Hashtable<String, String> data) {
        accountPage.signUpFailure(3);
    }

}

