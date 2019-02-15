package Yevhen.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.URL;

public class MainPage extends AbstractPage {

    WebElement TileBox;
    Select dropdownQuantity;
    WebElement title;

    public  MainPage(String URL) {
        driver.get(URL);
        TileBox = driver.findElements(By.xpath("//*[contains(@id,'search-realt')]"));
        dropdownQuantity = new Select(driver.findElement(By.id("countOnPage")));
        title=driver.findElement(By.cssSelector("#searchTitleCategory"));

    }

    public boolean isMainPageLoaded (){
        return title.getText().equals("Поиск недвижимости");
    }
    public MainPage setQuantityTiles (int numbers) {
                dropdownQuantity.selectByValue(String.valueOf(numbers));
        return this;
    }
    public int expectedResult() {
        return Integer.valueOf(dropdownQuantity.getFirstSelectedOption().getText());
    }

    public int numberOfTiles() {

        return TileBox;
    }


}

