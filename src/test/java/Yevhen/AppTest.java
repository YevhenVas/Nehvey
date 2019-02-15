package Yevhen;
import Yevhen.PageObjects.AbstractPage;
import Yevhen.PageObjects.MainPage;
import io.qameta.allure.Allure;
import io.qameta.allure.testng.AllureTestNg;
import org.aspectj.lang.annotation.Before;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.util.Strings;
import org.xml.sax.Locator;

import java.io.IOException;
import java.util.Locale;

import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
//public class AppTest
//{
    /**
     * Rigorous Test :-)
     */

    public class AppTest{
        MainPage mainPage;

    @BeforeMethod
    public void before(){
        mainPage = new MainPage("https://dom.ria.com/ru/search/");
    }

    @Test
    public void isMainPageLoaded (){
        Assert.assertEquals("Поиск недвижимости", mainPage.isMainPageLoaded());
    }

    @Test
     public void comparingFilterResults() {
        int expected = mainPage.expectedResult();
        int actual = mainPage.numberOfTiles();
        Assert.assertEquals(expected, actual, "comparing actual quantity of tiles and search");
     }




}
