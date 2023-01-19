package Setup.project.pages.Search;

import Common.constants.FrameworkConstants;
import Common.handle.WebUI;
import Common.helpers.ExcelHelpers;
import Common.utilities.ObjectUtils;
import Setup.project.modals.Search.SearchModal;
import Setup.project.pages.Home.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class SearchPage {


    public By searchTbx = ObjectUtils.getByLocatorFromConfig("searchTbx");
    public By inputtedKeywordSearch = ObjectUtils.getByLocatorFromConfig("inputtedKeywordSearch");
    public By suggestedKeywordSearch = ObjectUtils.getByLocatorFromConfig("suggestedKeywordSearch");
    public By categorySearch = ObjectUtils.getByLocatorFromConfig("categorySearch");
    public By categoryOption = ObjectUtils.getByLocatorFromConfig("categoryOption");
    public By selectedCategory = ObjectUtils.getByLocatorFromConfig("selectedCategory");
    public By btnDeleteSelectedCategory = ObjectUtils.getByLocatorFromConfig("btnDeleteSelectedCategory");
    public By btnClearAllCategory = ObjectUtils.getByLocatorFromConfig("btnClearAllCategory");
    public By dropdownSort = ObjectUtils.getByLocatorFromConfig("dropdownSort");
    public By btnSort = ObjectUtils.getByLocatorFromConfig("btnSort");
    public By prodsName = ObjectUtils.getByLocatorFromConfig("prodsName");
    public By prodsPrice = ObjectUtils.getByLocatorFromConfig("prodsPrice");
    public By selectShowPageSize = ObjectUtils.getByLocatorFromConfig("selectShowPageSize");
    public By btnNextPage = ObjectUtils.getByLocatorFromConfig("btnNextPage");
    public By pageSize = ObjectUtils.getByLocatorFromConfig("pageSize");
    public By totalRows = ObjectUtils.getByLocatorFromConfig("totalRows");
    public By noResultsContents = ObjectUtils.getByLocatorFromConfig("noResultsContents");


    public By btnPrevFirstPage = ObjectUtils.getByLocatorFromConfig("btnPrevFirstPage");


    ExcelHelpers excelHelpers;

    public SearchPage() {
        excelHelpers = new ExcelHelpers();
    }

    public HomePage searchAProd(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Search");
        WebUI.getURL(FrameworkConstants.URL_PROJECT);
        WebUI.clearText(searchTbx);
        WebUI.setText(searchTbx, excelHelpers.getCellData(numRow, SearchModal.searchKeywords));
        WebUI.pressENTER();
        Assert.assertTrue(WebUI.verifyPageUrlContain(excelHelpers.getCellData(numRow, SearchModal.getUrlSearchResults())));
        Assert.assertTrue(WebUI.verifyElementTextContains(inputtedKeywordSearch, excelHelpers.getCellData(numRow, SearchModal.searchKeywords)));
        Assert.assertTrue(WebUI.checkEqualsSearchResults(excelHelpers.getCellData(1, SearchModal.getSearchKeywords()), btnNextPage, pageSize, totalRows, noResultsContents));
        return new HomePage();
    }

    public HomePage searchMultiProds(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Search");
        WebUI.getURL(FrameworkConstants.URL_PROJECT);
        WebUI.clearText(searchTbx);
        WebUI.setText(searchTbx, excelHelpers.getCellData(numRow, SearchModal.searchKeywords));
        WebUI.pressENTER();
        Assert.assertTrue(WebUI.verifyPageUrlContain(excelHelpers.getCellData(numRow, SearchModal.getUrlSearchResults())));
        Assert.assertTrue(WebUI.verifyElementTextContains(inputtedKeywordSearch, excelHelpers.getCellData(numRow, SearchModal.searchKeywords)));
        WebUI.checkEqualsSearchResults(excelHelpers.getCellData(1, SearchModal.getSearchKeywords()), btnNextPage, pageSize, totalRows, noResultsContents);
//        Assert.assertTrue(WebUI.checkEqualsSearchResults(excelHelpers.getCellData(1,SearchModal.getSearchKeywords()),btnNextPage));
        return new HomePage();
    }

    public HomePage searchMultiHints(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Search");
        WebUI.getURL(FrameworkConstants.URL_PROJECT);
        WebUI.clearText(searchTbx);
        WebUI.setText(searchTbx, excelHelpers.getCellData(numRow, SearchModal.searchKeywords));
        WebUI.pressENTER();
        Assert.assertTrue(WebUI.verifyPageUrlContain(excelHelpers.getCellData(numRow, SearchModal.getUrlSearchResults())));
        Assert.assertTrue(WebUI.verifyElementTextContains(inputtedKeywordSearch, excelHelpers.getCellData(numRow, SearchModal.searchKeywords)));
        Assert.assertTrue(WebUI.verifyElementExists(suggestedKeywordSearch));
        String suggestedKeywordText = WebUI.getTextElement(suggestedKeywordSearch);
        WebUI.clickElement(suggestedKeywordSearch);

        Assert.assertTrue(WebUI.verifyPageUrlContain(suggestedKeywordText));
        Assert.assertTrue(WebUI.verifyElementTextContains(inputtedKeywordSearch, suggestedKeywordText));
        WebUI.checkEqualsSearchResults(suggestedKeywordText, btnNextPage, pageSize, totalRows, noResultsContents);
//        Assert.assertTrue(WebUI.checkEqualsSearchResults(excelHelpers.getCellData(1,SearchModal.getSearchKeywords()),btnNextPage));
        return new HomePage();
    }

    public HomePage searchNoResults(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Search");
        WebUI.getURL(FrameworkConstants.URL_PROJECT);
        WebUI.clearText(searchTbx);
        WebUI.setText(searchTbx, excelHelpers.getCellData(numRow, SearchModal.searchKeywords));
        WebUI.pressENTER();
        Assert.assertTrue(WebUI.verifyPageUrlContain(excelHelpers.getCellData(numRow, SearchModal.getUrlSearchResults())));
        Assert.assertTrue(WebUI.verifyElementTextContains(inputtedKeywordSearch, excelHelpers.getCellData(numRow, SearchModal.searchKeywords)));
        Assert.assertTrue(WebUI.checkEqualsSearchResults(excelHelpers.getCellData(1, SearchModal.getSearchKeywords()), btnNextPage, pageSize, totalRows, noResultsContents));
        return new HomePage();
    }

    public HomePage searchAndSortByCategory(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Search");
        WebUI.getURL(FrameworkConstants.URL_PROJECT);
        WebUI.clearText(searchTbx);
        WebUI.setText(searchTbx, excelHelpers.getCellData(numRow, SearchModal.searchKeywords));
        WebUI.pressENTER();
        Assert.assertTrue(WebUI.verifyPageUrlContain(excelHelpers.getCellData(numRow, SearchModal.getUrlSearchResults())));
        Assert.assertTrue(WebUI.verifyElementTextContains(inputtedKeywordSearch, excelHelpers.getCellData(numRow, SearchModal.searchKeywords)));

        //Select category
        WebUI.clickElement(categorySearch);
        String categoryOptionText = WebUI.getTextElement(categoryOption);
        WebUI.clickElement(categoryOption);
        Assert.assertTrue(WebUI.verifyTextContains(categoryOptionText, WebUI.getTextElement(selectedCategory)));
        WebUI.checkEqualsSearchResults(excelHelpers.getCellData(1, SearchModal.getSearchKeywords()), btnNextPage, pageSize, totalRows, noResultsContents);
//        Assert.assertTrue(WebUI.checkEqualsSearchResults(excelHelpers.getCellData(1,SearchModal.getSearchKeywords()),btnNextPage));

        //Remove category
        WebUI.clickElement(btnClearAllCategory);
        Assert.assertFalse(WebUI.verifyElementExists(selectedCategory));
        if (WebUI.verifyElementExists(btnPrevFirstPage)) {
            WebUI.scrollToElement(btnPrevFirstPage);
            WebUI.clickElement(btnPrevFirstPage);
        }
        WebUI.checkEqualsSearchResults(excelHelpers.getCellData(1, SearchModal.getSearchKeywords()), btnNextPage, pageSize, totalRows, noResultsContents);
        return new HomePage();
    }

    public HomePage searchAndSortByProdsName_A_Z(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Search");
        WebUI.clearText(searchTbx);
        WebUI.setText(searchTbx, excelHelpers.getCellData(numRow, SearchModal.searchKeywords));
        WebUI.pressENTER();
        Assert.assertTrue(WebUI.verifyPageUrlContain(excelHelpers.getCellData(numRow, SearchModal.getUrlSearchResults())));
        Assert.assertTrue(WebUI.verifyElementTextContains(inputtedKeywordSearch, excelHelpers.getCellData(numRow, SearchModal.searchKeywords)));

        //Select sort by Prods Name
        WebUI.selectOptionByValue(dropdownSort, "name");
        WebUI.clickElement(btnSort);
        if (!WebUI.verifyElementAttributeValue(btnSort, "class", "action sorter-action sort-asc")) {
            WebUI.clickElement(btnSort);
        }

        Assert.assertTrue(WebUI.verifyProdsWhenSortingA_Z(btnNextPage, prodsName, pageSize, totalRows, noResultsContents));

        return new HomePage();
    }

    public HomePage searchAndSortByProdsName_Z_A(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Search");
        WebUI.clearText(searchTbx);
        WebUI.setText(searchTbx, excelHelpers.getCellData(numRow, SearchModal.searchKeywords));
        WebUI.pressENTER();
        Assert.assertTrue(WebUI.verifyPageUrlContain(excelHelpers.getCellData(numRow, SearchModal.getUrlSearchResults())));
        Assert.assertTrue(WebUI.verifyElementTextContains(inputtedKeywordSearch, excelHelpers.getCellData(numRow, SearchModal.searchKeywords)));

        //Select sort by Prods Name
        WebUI.selectOptionByValue(dropdownSort, "name");
//        WebUI.clickElement(btnSort);
        if (!WebUI.verifyElementAttributeValue(btnSort, "class", "action sorter-action sort-desc")) {
            WebUI.clickElement(btnSort);
        }

        Assert.assertTrue(WebUI.verifyProdsWhenSortingZ_A(btnNextPage, prodsName, pageSize, totalRows, noResultsContents));

        return new HomePage();
    }

    public HomePage searchAndSortByProdsPrice_Low_High(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Search");
        WebUI.clearText(searchTbx);
        WebUI.setText(searchTbx, excelHelpers.getCellData(numRow, SearchModal.searchKeywords));
        WebUI.pressENTER();
        Assert.assertTrue(WebUI.verifyPageUrlContain(excelHelpers.getCellData(numRow, SearchModal.getUrlSearchResults())));
        Assert.assertTrue(WebUI.verifyElementTextContains(inputtedKeywordSearch, excelHelpers.getCellData(numRow, SearchModal.searchKeywords)));

        //Select sort by Prods Price
        WebUI.selectOptionByValue(dropdownSort, "price");
        if (!WebUI.verifyElementAttributeValue(btnSort, "data-value", "asc")) {
            WebUI.clickElement(btnSort);
        }
        Assert.assertTrue(WebUI.verifyProdsWhenSortingLow_High(btnNextPage, prodsPrice, pageSize, totalRows, noResultsContents));
        return new HomePage();
    }

    public HomePage searchAndSortByProdsPrice_High_Low(int numRow) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Search");
        WebUI.clearText(searchTbx);
        WebUI.setText(searchTbx, excelHelpers.getCellData(numRow, SearchModal.searchKeywords));
        WebUI.pressENTER();
        Assert.assertTrue(WebUI.verifyPageUrlContain(excelHelpers.getCellData(numRow, SearchModal.getUrlSearchResults())));
        Assert.assertTrue(WebUI.verifyElementTextContains(inputtedKeywordSearch, excelHelpers.getCellData(numRow, SearchModal.searchKeywords)));

        //Select sort by Prods Price
        WebUI.selectOptionByValue(dropdownSort, "price");
        WebUI.clickElement(btnSort);
        if (!WebUI.verifyElementAttributeValue(btnSort, "data-value", "desc")) {
            WebUI.clickElement(btnSort);
        }
        Assert.assertTrue(WebUI.verifyProdsWhenSortingHigh_Low(btnNextPage, prodsPrice, pageSize, totalRows, noResultsContents));
        return new HomePage();
    }

}
