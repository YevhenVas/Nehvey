package Yevhen.PageObjects;

import Yevhen.Utils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static Yevhen.Utils.scrollDownToElement;
import static Yevhen.Utils.scrollToBottom;

public class MainPage extends AbstractPage {

    By tileBoxesSelector = By.className("wrap_desc");
    By dropdownQuantitySelector = By.cssSelector(".el-selected.open");
    By titleSelector = By.cssSelector("#searchTitleCategory");
    By categorySelector = By.xpath("//label[@for='selectType'][1]");
    By apartmentSelection = By.id("catType_1_2_1");
    By realtySelecrtion = By.xpath("//*[@id='catType_1_2_1']");
    By citySelector = By.cssSelector("[title='Винница']");
    By regionSelector = By.id("pseudomodalRegion");
    By regionDefinder = By.xpath("//label[@for='district_15109']");
    By roomsCount=By.xpath("//label[@for='rooms_count_3']");
    By additionalDataSelection = By.cssSelector(".twitter-typeahead");
    By squareFrom=By.id("characteristic_214_from");
    By squareTo=By.id("characteristic_214_to");
    By cityDefinder = By.xpath("//*[@id='autocompleteSearch']");
    By regionComfirmation = By.xpath("//label[@class='button large _blue']");
    //By apartmentRooms = By.className("mt-5 i-block mr-15");


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
    public List<WebElement> getTilesRooms() {
        return driver.findElements(roomsCount);
    }

    public List<String> getTileHeaders() {
        List<String> forReturn = new ArrayList<>();

        for (WebElement tile : getTiles()) {
            forReturn.add(tile.findElement(By.className("blue")).getText());
        }
        return forReturn;
    }
    public List<String> getTileQuantityRooms() {
        List<String> forRoomsReturn = new ArrayList<>();

        for (WebElement tile : getTilesRooms()) {
            forRoomsReturn.add(tile.findElement(By.className("blue")).getText());
        }
        return forRoomsReturn;
    }

    public MainPage setRealtyType() throws InterruptedException {
        driver.findElement(additionalDataSelection).click();
        Thread.sleep(1000);
        driver.findElement(categorySelector).click();
        Thread.sleep(1000);
        driver.findElement(realtySelecrtion).click();
        Thread.sleep(1000);
        return this;
    }

     public MainPage setGeolocation() throws InterruptedException {
            driver.findElement(cityDefinder).click();
            driver.findElement(citySelector).click();
            Thread.sleep(1000);
            driver.findElement(regionSelector).click();
            Thread.sleep(1000);
            driver.findElement(regionDefinder).click();
            driver.findElement(regionComfirmation).click();
            Thread.sleep(5000);
            return this;
        }
    public String setApartmantType() throws InterruptedException {
        driver.findElement(apartmentSelection).click();
        Thread.sleep(1000);
        driver.findElement(roomsCount).click();
        String actualQuantityOfRooms = driver.findElement(roomsCount).getText();
        Thread.sleep(1000);
        return actualQuantityOfRooms;
    }
    public MainPage setSquare() throws InterruptedException {
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
   public String getQuantityOfRooms ()throws InterruptedException {
       String apartmentRooms = driver.findElements(By.className("wrap_desc")).get(1).findElements(By.cssSelector(".mt-5.i-block.mr-15")).toString();
       return apartmentRooms;
    }
}

