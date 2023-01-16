package Setup.project.dataprovider.Account;

import Common.constants.FrameworkConstants;
import Common.helpers.ExcelHelpers;
import Common.helpers.Helpers;
import Setup.project.modals.Account.AccountModal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public final class AccountDataProvider {

    private AccountDataProvider() {
    }

    @Test(dataProvider = "getAccountDataHashTable")
    public void testGetAccountData(Hashtable<String, String> data) {
        //Sign Up
        System.out.println("AccountData.FirstName = " + data.get(AccountModal.getFirstName()));
        System.out.println("AccountData.LastName = " + data.get(AccountModal.getLastName()));
        System.out.println("AccountData.Email = " + data.get(AccountModal.getEmail()));
        System.out.println("AccountData.Password = " + data.get(AccountModal.getPassword()));
        System.out.println("AccountData.ConfirmPassword = " + data.get(AccountModal.getConfirmPassword()));
        System.out.println("AccountData.AccountPageUrl = " + data.get(AccountModal.getAccountUrl()));
        System.out.println("AccountData.ExpectedPageUrl = " + data.get(AccountModal.getSignInPageUrl()));
        //Sign In
        System.out.println("AccountData.Email = " + data.get(AccountModal.getEmail()));
        System.out.println("AccountData.Password = " + data.get(AccountModal.getPassword()));
        System.out.println("AccountData.AccountPageUrl = " + data.get(AccountModal.getHomePageUrl()));
        System.out.println("AccountData.SignOutPageUrl = " + data.get(AccountModal.getSignOutPageUrl()));
        System.out.println("AccountData.HomePageUrl = " + data.get(AccountModal.getHomePageUrl()));

    }

    
    @DataProvider(name = "getAccountDataHashTable")
    public static Object[][] getAccountData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Account", 1, 1);
        return data;
    }


    
}