package Yevhen;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    private static WebDriver driver=Driver.get();

    public static int substringInt(String stringInt) {
           return Integer.valueOf(stringInt.replaceAll("[^0-9]", ""));
    }

    public static void scrollToBottom(){
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void scrollDownToElement(WebElement element){
        int y= element.getLocation().getY();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.scrollTo(0, "+y+")");
    }
}
