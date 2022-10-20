package StepDefinitions;

import Pom.Page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Pom.base.BaseTest.driver;

public class Imdb_Steps {

    HomePage homePage;
    OscarPage oscarPage;
    AwardsPage avardsPage;

    TheCircusPage theCircusPage;

    ResultPage resultPage;

    PhotoPage photoPage;

    NewTheCircusPage newTheCircusPage;




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

    @Given("On the loaded page, clicks the {string} button under the {string} heading.")
    public void on_the_loaded_page_clicks_the_button_under_the_heading(String string, String string2) {
        avardsPage = new AwardsPage(driver);
        oscarPage = new OscarPage(driver);
        avardsPage.ClickOscar();
        Assert.assertTrue(oscarPage.ValidateOscar(), "Not on oscar page");
    }

    @Given("Under the {string} heading, the value {string} is selected.")
    public void under_the_heading_the_value_is_selected(String string, String string2) {
        oscarPage = new OscarPage(driver);
        oscarPage.selectYear();
    }

    @Given("{string} is selected under the “Honorary Award”")
    public void is_selected_under_the_honorary_award(String string) {
        oscarPage.selectMovie();
    }

    @Given("The loaded page, the director's information, the Writer's information, and the star information of {string} are saved.")
    public void the_loaded_page_the_director_s_information_the_writer_s_information_and_the_star_information_of_are_saved(String string) {
        theCircusPage = new TheCircusPage(driver);
        System.out.println(" information saved ");
        theCircusPage.saveDirectorsInfoText();
        theCircusPage.saveWritersInfoText();
        theCircusPage.saveStarsInfoText();
    }

    @Given("Click on the IMDB button at the top left of the screen and return to the Home page.")
    public void click_on_the_imdb_button_at_the_top_left_of_the_screen_and_return_to_the_home_page() throws InterruptedException {
        theCircusPage.clickImdbButton();

    }

    @Given("Types {string} to the search bar")
    public void types_to_the_search_bar(String string) {
        homePage.writeMovieName(string);
        homePage.ClickSearhButton();
    }

    @Given("Click on {string} that appears among the results.")
    public void click_on_that_appears_among_the_results( String string) {
        resultPage = new ResultPage(driver);
        resultPage.selectMovie(string);
    }

    @Then("The loaded page compares previous director, writer, and star information, and new ones belong to {string}")
    public void the_loaded_page_compares_previous_director_writer_and_star_information_and_new_ones_belong_to(String string) {
        newTheCircusPage = new NewTheCircusPage(driver);
        theCircusPage.checkDirectorText();
        theCircusPage.checkWriterText();
        theCircusPage.checkStarsText();
    }

    @Then("After the checks are done, click on the See all .. photos link. and it is checks that the links of all photos are not broken.")
    public void after_the_checks_are_done_click_on_the_link_and_it_is_checks_that_the_links_of_all_photos_are_not_broken(int k) {
        photoPage = new PhotoPage(driver);
        try {
            photoPage.checkPhotoLink(k);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
