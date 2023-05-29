package tests;

import lib.CoreTestCase;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Ex8PageObject extends CoreTestCase
{
    // Задание 2
    @Test
    public void Test2()
    {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("Object-oriented programming language");
        SearchPageObject.waitForSearchResult("Island of Indonesia, Southeast Asia");
        SearchPageObject.clickCancelSearch();
        SearchPageObject.waitForCancelButtonToDisappear();



    }


}
