package Pom.Page;

import Pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewTheCircusPage extends BasePage {
    public NewTheCircusPage(WebDriver driver) {

        super(driver);
    }
    By directorInfoText = By.cssSelector(".sc-fa02f843-0 > .ipc-metadata-list > li:nth-of-type(1) .ipc-metadata-list-item__list-content-item");

    By writerInfoText = By.cssSelector(".sc-fa02f843-0 li:nth-of-type(2) > .ipc-metadata-list-item__content-container");
    By starInfoText = By.cssSelector(".sc-fa02f843-0 .ipc-metadata-list-item--link > .ipc-metadata-list-item__content-container");






    By photoTitle = By.xpath("//*[@class='ipc-title__text' and contains(text(), 'Photos')]");


    public NewTheCircusPage newDirectorsInfoText() {

        type(directorInfoText);
        return this;
    }

    public NewTheCircusPage newWritersInfoText() {
        type(writerInfoText);
        return this;
    }

    public NewTheCircusPage newStarsInfoText() {
        type(starInfoText);
        return this;
    }



}
