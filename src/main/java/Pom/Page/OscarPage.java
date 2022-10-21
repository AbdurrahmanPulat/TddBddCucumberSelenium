package Pom.Page;

import Pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class OscarPage extends BasePage {

    By year = By.cssSelector("div:nth-of-type(16) > span:nth-of-type(5) > a");

    By oscar = By.cssSelector("#main > div:nth-of-type(1) h3");

    By theCircus = By.cssSelector(".event-widgets__award-list div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) div:nth-of-type(1) a:nth-of-type(1)");

    By theJazzSinger = By.cssSelector(".event-widgets__award-list h3:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(2) a:nth-of-type(1)");

    public OscarPage(WebDriver driver) {
        super(driver);
    }

    public void selectYear() {
        click(year);
    }

    public boolean ValidateOscar() {
        return isDisplayed(oscar);
    }

    public void selectMovie() {
        click(theCircus);
    }

    public void selectMovie2() {
        click(theJazzSinger);
    }


}
