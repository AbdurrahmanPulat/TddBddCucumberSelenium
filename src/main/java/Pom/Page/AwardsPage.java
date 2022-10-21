package Pom.Page;

import Pom.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AwardsPage extends BasePage {

    By oscar = By.cssSelector(".sc-cb2ab421-0 > div:nth-of-type(3) a:nth-of-type(1) > span:nth-of-type(1)");

    public AwardsPage(WebDriver driver) {
        super(driver);
    }

    public void ClickOscar() {
        click(oscar);
    }
}
