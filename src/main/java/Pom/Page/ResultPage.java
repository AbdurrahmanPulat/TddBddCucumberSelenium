package Pom.Page;

import Pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage extends BasePage {

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    By movieTitle = By.partialLinkText("The Circus");

    By movieTitle2 = By.partialLinkText("The Jazz Singer");

    public void selectMovie() {
        click(movieTitle);
    }

    public void selectMovie2() {
        click(movieTitle2);
    }

}
