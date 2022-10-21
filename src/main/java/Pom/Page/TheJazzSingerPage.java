package Pom.Page;

import Pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TheJazzSingerPage extends BasePage {
    public TheJazzSingerPage(WebDriver driver) {
        super(driver);
    }

    By directorInfoText = By.cssSelector(".sc-fa02f843-0 > .ipc-metadata-list > li:nth-of-type(1) .ipc-metadata-list-item__list-content-item");

    By writerInfoText = By.cssSelector(".sc-fa02f843-0 li:nth-of-type(2) > .ipc-metadata-list-item__content-container");
    By starInfoText = By.cssSelector(".sc-fa02f843-0 .ipc-metadata-list-item--link > .ipc-metadata-list-item__content-container");

    public TheJazzSingerPage saveDirectorsInfoText() {
        type(directorInfoText);
        return this;
    }

    public TheJazzSingerPage saveWritersInfoText() {
        type(writerInfoText);
        return this;
    }

    public TheJazzSingerPage saveStarsInfoText() {
        type(starInfoText);
        return this;
    }

    public TheJazzSingerPage newDirectorsInfoText() {

        type(directorInfoText);
        return this;
    }

    public TheJazzSingerPage newWritersInfoText() {
        type(writerInfoText);
        return this;
    }

    public TheJazzSingerPage newStarsInfoText() {
        type(starInfoText);
        return this;
    }

    public void checkDirectorText() {

        Assert.assertEquals(newDirectorsInfoText(), saveDirectorsInfoText());
    }

    public void checkWriterText() {
        Assert.assertEquals(newWritersInfoText(), saveWritersInfoText());

    }

    public void checkStarsText() {
        Assert.assertEquals(newStarsInfoText(), saveStarsInfoText());
    }


}
