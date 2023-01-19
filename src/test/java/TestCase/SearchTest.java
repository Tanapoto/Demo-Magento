package TestCase;

import Setup.baseSetUp.BaseTest;
import Setup.project.dataprovider.Search.SearchDataProvider;
import Setup.project.pages.Account.AccountPage;
import Setup.project.pages.Search.SearchPage;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class SearchTest extends BaseTest {

    AccountPage accountPage;
    SearchPage searchPage;

    public SearchTest() {
        accountPage = new AccountPage();
        searchPage = new SearchPage();
    }

    @Test(priority = 1, dataProvider = "getSearchDataHashTable", dataProviderClass = SearchDataProvider.class)
    public void testSearch(Hashtable<String, String> data) {
        accountPage.signInSuccessfullyAfterEditingEmailAndPassword(1);
        searchPage.searchAProd(1);
        searchPage.searchMultiProds(2);
        searchPage.searchMultiHints(3);
        searchPage.searchNoResults(4);
    }

    @Test(priority = 2, dataProvider = "getSearchDataHashTable", dataProviderClass = SearchDataProvider.class)
    public void testSearchAndSortByCategory(Hashtable<String, String> data) {
        accountPage.signInSuccessfullyAfterEditingEmailAndPassword(1);
        searchPage.searchAndSortByCategory(2);
    }

    @Test(priority = 3, dataProvider = "getSearchDataHashTable", dataProviderClass = SearchDataProvider.class)
    public void testSortName_Price(Hashtable<String, String> data) {
        accountPage.signInSuccessfullyAfterEditingEmailAndPassword(1);
        searchPage.searchAndSortByProdsName_A_Z(2);
        searchPage.searchAndSortByProdsName_Z_A(2);
        searchPage.searchAndSortByProdsPrice_Low_High(2);
        searchPage.searchAndSortByProdsPrice_High_Low(2);
    }
}
