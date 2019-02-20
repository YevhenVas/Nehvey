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
import java.util.List;
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
        Assert.assertTrue(mainPage.isMainPageLoaded(),"Wrong page or main page should be loaded");
    }

    @Test
     public void comparingFilterResults() {
        int expected = mainPage.expectedResultOfTiles();
        int actual = mainPage.numberOfTiles();
        Assert.assertEquals(expected, actual, "comparing actual quantity of tiles and search");
     }

     @Test
     public void comparingChangedValues () throws InterruptedException {
        mainPage.setQuantityTiles(50);
        Thread.sleep(5000);
        int expected = mainPage.expectedResultOfTiles();
        int actual = mainPage.numberOfTiles();
        Assert.assertEquals(expected, actual, "comparing actual quantity of tiles and search");
     }
     @Test
     public void comparingChangedDataSelection () throws InterruptedException {

        List<String> titels= mainPage.setAdditioanlDataSelection().getTileHeaders();
        for(String title:titels){
            Assert.assertTrue(title.toLowerCase().contains("винница"), "винница not found in: "+title);
        }
         for(String title:titels){
            Assert.assertTrue(title.toLowerCase().contains("вишенка"), "message");
        }
     }

}
