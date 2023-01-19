package Setup.project.dataprovider.Search;

import Common.constants.FrameworkConstants;
import Common.helpers.ExcelHelpers;
import Common.helpers.Helpers;
import Setup.project.modals.Account.AccountModal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class SearchDataProvider {

    private SearchDataProvider() {
    }

    @Test(dataProvider = "getSearchDataHashTable")
    public void testGetAccountData(Hashtable<String, String> data) {
    }


    @DataProvider(name = "getSearchDataHashTable")
    public static Object[][] getAccountData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Search", 1, 1);
        return data;
    }

}
