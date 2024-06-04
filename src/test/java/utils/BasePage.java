package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void cargarSitio(String url){
        driver.get(url);
    }

    public void esperarxsegundos(int milisegundo){
        try {
            Thread.sleep(milisegundo);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
