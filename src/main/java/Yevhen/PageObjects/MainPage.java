package Yevhen.PageObjects;

import Yevhen.Driver;
import okhttp3.internal.connection.RouteSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.URL;

public class MainPage extends AbstractPage {
    public MainPage openPage(String URL) {
        driver.get(URL);
        return this;
    }
    public boolean isMainPageLoaded (){
       String title= (String) driver.findElement(By.id("searchTitleCategory")).getText();
       return title.equals("Поиск недвижимости");
    }
    public MainPage setQuantityTiles (int numbers) {
        Select dropdown = new Select(driver.findElement(By.className("el-selected open")));
        dropdown.selectByValue(String.valueOf(numbers));
        return this;
    }
  }

