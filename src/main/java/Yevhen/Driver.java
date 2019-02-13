package Yevhen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;
    public static WebDriver get() {
        if(driver==null){
            new Driver();
        }
        return driver;
    }

    private Driver() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver=new ChromeDriver();
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }
}
