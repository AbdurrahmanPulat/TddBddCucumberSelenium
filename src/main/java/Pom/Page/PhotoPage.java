package Pom.Page;

import Pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class PhotoPage extends BasePage {
    public PhotoPage(WebDriver driver) {
        super(driver);
    }

    By nextButton = By.cssSelector("#media_index_content > div:nth-of-type(3) .prevnext");

    By photoTitle = By.xpath("//*[@class='ipc-title__text' and contains(text(), 'Photos')]");

    public void clickPhotoLink() {
        click(photoTitle);
    }

    public PhotoPage checkPage1() throws IOException {

        List<WebElement> images = driver.findElements(By.tagName("img"));
        System.out.println("Total images: " + images.size());
        for (int i = 0; i < images.size(); i++) {
            WebElement element = images.get(i);
            String url = element.getAttribute("src");
            URL link = new URL(url);
            HttpURLConnection httpCon = (HttpURLConnection) link.openConnection();
            httpCon.connect();

            int rescode = httpCon.getResponseCode();
            if (rescode >= 400) {
                System.out.println(url + "-" + "is broken link");
            } else {
                System.out.println(url + "-" + "is valid link");
            }
        }
        return this;
    }

    public void clickNextButton() {
        click(nextButton);
    }

}
