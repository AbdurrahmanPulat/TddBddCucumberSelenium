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




   // @FindBy (xpath = "#main > div:nth-of-type(1)")
  //  WebElement imgFrame;

    By imgFrame= By.xpath("#main > div:nth-of-type(1)");

    private List<WebElement> getAllProducts(){
        return findAll(imgFrame);
    }



    public PhotoPage checkPhotoLink(int k) throws IOException {
        getAllProducts().get(k).click();


        List<WebElement> images = getAllProducts();
        System.out.println("Total images: " + images.size());
        for(int i=0; i<images.size(); i++) {
            WebElement element = images.get(i);
            String url = element.getAttribute("src");
            URL link = new URL(url);
            HttpURLConnection httpCon = (HttpURLConnection) link.openConnection();
            httpCon.connect();

            int rescode = httpCon.getResponseCode();
            if(rescode >= 400) {
                System.out.println(url + "-" + "is broken link");
            }
            else {
                System.out.println(url + "-" + "is valid link");
            }
        }

        return this;


    }
}
