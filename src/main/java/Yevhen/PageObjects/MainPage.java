package Yevhen.PageObjects;

import Yevhen.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static Yevhen.Utils.scrollDownToElement;ye;yj
import static Yevhen.Utils.scrollToBottom;

public class MainPage extends AbstractPage {

    By tileBoxesSelector = By.className("wrap_desc");
    By dropdownQuantitySelector = By.cssSelector(".el-selected.open");
    By titleSelector = By.cssSelector("#searchTitleCategory");
    By categorySelector = By.xpath("//label[@for='selectType']");
    By additionalDataSelection = By.cssSelector(".twitter-typeahead");
    By citySelector = By.cssSelector("[title='Винница']");
    By regionSelector = By.id("pseudomodalRegion");
    By regionDefinder = By.xpath("//label[@for='district_15109']");
    By realtySelecrtion = By.xpath("//label[@for='selectType'][1]");
    By apartmentSelection = By.id("catType_1_2_1");
    By roomsCount=By.xpath("//label[@for='rooms_count_3']");
    By squareFrom=By.id("characteristic_214_from");
    By squareTo=By.id("characteristic_214_to");
    By apartmentRooms = By.className("mt-5 i-block mr-15");


    public MainPage(String URL) {
        driver.get(URL);
    }

    public boolean isMainPageLoaded() {
        return driver.findElement(titleSelector).getText().equals("Поиск недвижимости");
    }

    public MainPage setQuantityTiles(int numbers) {
        scrollToBottom();
        driver.findElement(dropdownQuantitySelector).click();
        WebElement listItem = driver.findElement(By.cssSelector("[data-value='" + numbers + "']"));
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

        for (WebElement tile : getTiles()) {
            forReturn.add(tile.findElement(By.className("blue")).getText());
        }
        return forReturn;
    }

    public MainPage setAdditioanlDataSelection() throws InterruptedException {
        driver.findElement(additionalDataSelection).click();
        Thread.sleep(1000);
        driver.findElement(citySelector).click();
        Thread.sleep(1000);
        driver.findElement(regionSelector).click();
        Thread.sleep(1000);
        driver.findElement(regionDefinder).click();
        Thread.sleep(5000);
        driver.findElement(categorySelector).click();
        Thread.sleep(1000);
        driver.findElement(realtySelecrtion).click();
        Thread.sleep(1000);
        driver.findElement(apartmentSelection).click();
        Thread.sleep(1000);
        driver.findElement(roomsCount).click();
        Thread.sleep(1000);
        driver.findElement(squareFrom).sendKeys("60");
        Thread.sleep(1000);
        driver.findElement(squareTo).sendKeys("100");
        Thread.sleep(1000);

        return this;
    }
    public MainPage getSquareOfRooms ()throws InterruptedException {
        String[] strings = driver.findElements(By.className("wrap_desc")).get(1).findElements(By.cssSelector(".mt-5.i-block.mr-15")).get(1).getText().split("/");
        return this;
    }
    public MainPage getQuantityOfRooms ()throws InterruptedException {
        driver.findElements(By.className("wrap_desc")).get(1).findElements(By.cssSelector(".mt-5.i-block.mr-15"));
        return this;
    }

}

