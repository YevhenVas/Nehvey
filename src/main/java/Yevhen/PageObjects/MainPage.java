package Yevhen.PageObjects;

import Yevhen.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static Yevhen.Utils.scrollDownToElement;
import static Yevhen.Utils.scrollToBottom;

public class MainPage extends AbstractPage {

    By tileBoxesSelector=By.className("wrap_desc");
    By dropdownQuantitySelector=By.cssSelector(".el-selected.open");
    By titleSelector=By.cssSelector("#searchTitleCategory");
    By additionalDataSelection=By.cssSelector(".twitter-typeahead");
    By citySelector=By.cssSelector("[title='Винница']");
    By regionSelector=By.className("[for='district_15109']");


    public  MainPage(String URL) {
        driver.get(URL);
    }

    public boolean isMainPageLoaded (){
        return driver.findElement(titleSelector).getText().equals("Поиск недвижимости");
    }

    public MainPage setQuantityTiles (int numbers) {
        scrollToBottom();
        driver.findElement(dropdownQuantitySelector).click();
        WebElement listItem = driver.findElement(By.cssSelector("[data-value='" + numbers+ "']"));
        listItem.click();
         return this;
    }
    public int expectedResultOfTiles() {

        String stringValues = driver.findElement(dropdownQuantitySelector).getText();
        return Utils.substringInt(stringValues);
    }

    public int numberOfTiles() {

        List<WebElement> arrayTiles = driver.findElements(tileBoxesSelector);
        return arrayTiles.size();
    }

    public List<WebElement> getTiles() {
        return driver.findElements(tileBoxesSelector);
    }

    public List<String> getTileHeaders() {
        List<String> forReturn = new ArrayList<>();

        for(WebElement tile:getTiles()){
            forReturn.add(tile.findElement(By.className("blue")).getText());
        }
        return forReturn;
    }
    public MainPage setAdditioanlDataSelection () throws InterruptedException {
        driver.findElement(additionalDataSelection).click();
        driver.findElement(citySelector).click();
        //driver.findElement(regionSelector).click();
        Thread.sleep(5000);
        return this;
    }
}

