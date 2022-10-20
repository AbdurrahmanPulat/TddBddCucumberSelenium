package Pom.Page;

import Pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OscarPage extends BasePage {
    WebDriver driver;


    By year = By.cssSelector("div:nth-of-type(16) > span:nth-of-type(5) > a");



    By oscar = By.cssSelector("#main > div:nth-of-type(1) h3");



    By theCircus = By.cssSelector(".event-widgets__award-list div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) div:nth-of-type(1) a:nth-of-type(1)");

    public OscarPage(WebDriver driver) {
        super(driver);
    }


    public void selectYear(){
        click(year);
    }






    public  boolean ValidateOscar(){
        return isDisplayed(oscar);
    }

    public void selectMovie(){
        click(theCircus);
    }






}
