package Pom.Page;

import Pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }


    By searchBox = By.id("suggestion-search");

    By searchButton = By.id("suggestion-search-button");

    By menu = By.id("imdbHeader-navDrawerOpen--desktop");

    By imdbButton = By.id("home_img_holder");


    public void writeMovieName(String txt) {
        write(searchBox, txt);
    }


    public void ClickMenu() {
        click(menu);
    }

    public void ClickSearchButton() {
        click(searchButton);
    }

    public void clickImdbButton() throws InterruptedException {
        click(imdbButton);
        Thread.sleep(2000);
    }


}
