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


    By searchBox =By.id("suggestion-search");


    By searchButton =By.id("suggestion-search-button");

    By menu= By.id("imdbHeader-navDrawerOpen--desktop");






    public void writeMovieName(String txt) {
        write(searchBox,txt);
    }


    public void ClickMenu(){
        click(menu);
    }
    public void ClickSearhButton(){
        click(searchButton);

    }



}
