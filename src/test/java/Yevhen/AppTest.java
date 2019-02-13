package Yevhen;
import Yevhen.PageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

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
    @Test
    public void GetURL ()throws IOException{
    MainPage mainPage = new MainPage();
    mainPage.openPage("https://dom.ria.com/ru/search/");

}


}
