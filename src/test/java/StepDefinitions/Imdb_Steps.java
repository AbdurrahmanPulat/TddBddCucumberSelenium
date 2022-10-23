package StepDefinitions;

import Pom.Page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

import static Pom.base.Hooks.driver;

public class Imdb_Steps {

    HomePage homePage;
    OscarPage oscarPage;
    AwardsPage avardsPage;

    @Given("Browser is open")
    public void browser_is_open() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.imdb.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Given("Press the Menu button on the left side of the search bar.")
    public void press_the_menu_button_on_the_left_side_of_the_search_bar() {
        homePage = new HomePage(driver);
        homePage.ClickMenu();

    }

    @And("On the loaded page, clicks the Oscar button under the Award & Events heading.")
    public void on_the_loaded_page_clicks_the_button_under_the_heading() {
        avardsPage = new AwardsPage(driver);
        oscarPage = new OscarPage(driver);
        avardsPage.ClickOscar();
        Assert.assertTrue(oscarPage.ValidateOscar(), "Not on oscar page");
    }

    @And("Under the Event History heading, the value 1929 is selected.")
    public void under_the_heading_the_value_is_selected() {
        oscarPage = new OscarPage(driver);
        oscarPage.selectYear();
    }


    @And("Click on the IMDB button at the top left of the screen and return to the Home page.")
    public void click_on_the_imdb_button_at_the_top_left_of_the_screen_and_return_to_the_home_page() throws InterruptedException {
        homePage.clickImdbButton();

    }

    @And("Types {string} to the search bar")
    public void types_to_the_search_bar(String string) {
        homePage.writeMovieName(string);
        homePage.ClickSearchButton();
    }

    @Then("Browser is close")
    public void browser_is_close() {
        driver.quit();
    }


}
