package Pom.Page;

import Pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage extends BasePage {

    public ResultPage(WebDriver driver) {
        super(driver);
    }



    By movieTitle = By.partialLinkText("The Circus");

    By getMovieTitle = By.xpath("//a[@href=\"/title/tt0018773/?ref_=fn_al_tt_2\"]");






    public void selectMovie(String string) {
        if (isDisplayed(getMovieTitle)){
            click(getMovieTitle);
        }
        click(movieTitle);
    }

}
