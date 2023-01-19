package Setup.project.dataprovider.Account;

import Common.constants.FrameworkConstants;
import Common.helpers.ExcelHelpers;
import Common.helpers.Helpers;
import Setup.project.modals.Account.AccountModal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public final class EditAccountDataProvider {

    private EditAccountDataProvider() {
    }

    @Test(dataProvider = "getEditAccountDataHashTable")
    public void testGetAccountData(Hashtable<String, String> data) {

        System.out.println("AccountData.FirstName = " + data.get(AccountModal.getFirstName()));

    }

    
    @DataProvider(name = "getEditAccountDataHashTable")
    public static Object[][] getAccountData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Account", 1, 1);
        return data;
    }


    
}