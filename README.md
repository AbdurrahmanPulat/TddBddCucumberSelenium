# TddBddCucumberSelenium
<a href="https://selenium.dev"><img src="https://selenium.dev/images/selenium_logo_square_green.png" width="180" alt="Selenium"/></a>
    

# About The Project
This project tests Imdb.com using the selenium and cucumber frameworks.
## Video

https://user-images.githubusercontent.com/57863133/197215721-bf885a8d-b35a-4645-bc09-c58a04b81e54.mp4

## Project Report

![image](https://user-images.githubusercontent.com/57863133/197217790-d5aaab0f-8429-40c3-accc-9092d2ac87a2.png)
![image](https://user-images.githubusercontent.com/57863133/197217590-2679ccd9-ead7-4faf-908f-86286e562ff3.png)



# How the Project Works
 To run the project, java must be installed on your computer. In addition, one of the ide like Eclipse or Intellij Idea must be installed.
 Then you can install and run the project on your computer by typing "git clone https://github.com/AbdurrahmanPulat/TddBddCucumberSelenium.git" in the terminal.
  * [About The Project](#About-The-Project)
  * [Video](#Video)
  * [Project Report](#Project-Report)
  * [How the Project Works](#How-The-Project-Works)
  * [Steps The Circus Movie](#Steps-The-Circus-Movie)
  * [Steps The Jazz Singer Movie](#Steps-The-Jazz-Singer-Movie)
  * [Imdb_Steps Class](#Imdb_Steps-Class)
  * [TheCircus_Steps Class](#TheCirsus_Steps-Class)
  * [TheJazzSinger_Steps Class](#TheJazzSinger_Steps-Class)
  * [TestRunner Class](#TestRunner-Class)
  

## Project Details
- Search Bar with Movie Found from Menu The Movie Properties found on it should be the same.
- Description: The movie is found by going through the menu and this movie is found in the search bar.
is searched. Verify that Director, Writer, Stars information is the same.

## Steps The Circus Movie

Given Browser is open
 - Press the Menu button on the left side of the search bar.
 - On the loaded page, clicks the Oscar button under the Award & Events heading.
 - Under the Event History heading, the value 1929 is selected.
 - The Circus is selected under the Honorary Award
 - On the loaded page, the director's information, the Writer's information, and the star information of The Circus are saved.
 - Click on the IMDB button at the top left of the screen and return to the Home page.
 - Types "The Circus (1928)" to the search bar
 - Click on The Circus that appears among the results.
 - On the loaded page compares previous director, writer, and star information, and new ones belong to The Circus.
 - After the checks are done, click on the See all .. photos link. and it is checks that the links of all photos are not broken.
 - Browser is close
 
 ## Steps The Jazz Singer Movie
 
 - Browser is open
 - Press the Menu button on the left side of the search bar.
 - On the loaded page, clicks the Oscar button under the Award & Events heading.
 - Under the Event History heading, the value 1929 is selected.
 - The Jazz Singer is selected under the Honorary Award
 - On the loaded page, the director's information, the Writer's information, and the star information of The Jazz Singer are saved
 - Click on the IMDB button at the top left of the screen and return to the Home page.
 - Types "The Jazz Singer (1927)" to the search bar.
 - Click on The jazz Singer that appears among the results.
 - On the loaded page compares previous director, writer, and star information, and new ones belong to The Jazz Singer.
 - After the checks are done, click on the See all photos link. and it is checks that the links of all photos are not broken.
 - Browser is close




## Imdb_Steps Class

```java
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

```

## TheCircus_Steps Class
```java
package StepDefinitions;

import Pom.Page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static Pom.base.Hooks.driver;

public class TheCircus_Steps {


    OscarPage oscarPage;


    TheCircusPage theCircusPage;


    ResultPage resultPage;

    PhotoPage photoPage;

    @And("The Circus is selected under the Honorary Award")
    public void is_selected_under_the_honorary_award() {
        oscarPage.selectMovie();
    }

    @And("On the loaded page, the director's information, the Writer's information, and the star information of The Circus are saved.")
    public void the_loaded_page_the_director_s_information_the_writer_s_information_and_the_star_information_of_are_saved() {
        theCircusPage = new TheCircusPage(driver);
        theCircusPage.saveDirectorsInfoText();
        theCircusPage.saveWritersInfoText();
        theCircusPage.saveStarsInfoText();
        System.out.println(" information saved ");
    }

    @And("Click on The Circus that appears among the results.")
    public void click_on_that_appears_among_the_results() {
        resultPage = new ResultPage(driver);
        resultPage.selectMovie();
    }

    @Then("On the loaded page compares previous director, writer, and star information, and new ones belong to The Circus")
    public void the_loaded_page_compares_previous_director_writer_and_star_information_and_new_ones_belong_to() {
        theCircusPage.checkDirectorText();
        theCircusPage.checkWriterText();
        theCircusPage.checkStarsText();
        System.out.println("Checked");
    }

    @Then("After the checks are done, click on the See all .. photos link. and it is checks that the links of all photos are not broken.")
    public void after_the_checks_are_done_click_on_the_link_and_it_is_checks_that_the_links_of_all_photos_are_not_broken() {
        photoPage = new PhotoPage(driver);
        photoPage.clickPhotoLink();
        try {
            photoPage.checkPage1();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        photoPage.clickNextButton();
        try {
            photoPage.checkPage1();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

```


## ThejazzSinger_Steps Class
```java
package StepDefinitions;

import Pom.Page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static Pom.base.Hooks.driver;

public class TheJazzSinger_Steps {


    OscarPage oscarPage;

    TheJazzSingerPage theJazzSingerPage;

    ResultPage resultPage;

    PhotoPage photoPage;

    @And("The Jazz Singer is selected under the Honorary Award")
    public void theJazzSinger_is_selected_under_the_honorary_award() {
        oscarPage.selectMovie2();
    }

    @And("On the loaded page, the director's information, the Writer's information, and the star information of The Jazz Singer are saved.")
    public void the_loaded_page_the_director_s_information_the_writer_s_information_and_the_star_information_of_theJazzSinger_are_saved() {
        theJazzSingerPage = new TheJazzSingerPage(driver);
        theJazzSingerPage.saveDirectorsInfoText();
        theJazzSingerPage.saveWritersInfoText();
        theJazzSingerPage.saveStarsInfoText();
        System.out.println("Director, Writer, Star information saved");
    }


    @And("Click on The jazz Singer that appears among the results.")
    public void click_on_theJazzSinger_that_appears_among_the_results() {
        resultPage = new ResultPage(driver);
        resultPage.selectMovie2();
    }

    @Then("On the loaded page compares previous director, writer, and star information, and new ones belong to The Jazz Singer")
    public void the_loaded_page_compares_previous_director_writer_and_star_information_and_new_ones_belong_to_theJazzSinger() {
        theJazzSingerPage.checkDirectorText();
        theJazzSingerPage.checkWriterText();
        theJazzSingerPage.checkStarsText();
        System.out.println("Confirmed that Director, Writer, and Stars information is the same.");

    }

    @Then("After the checks are done, click on the See all photos link. and it is checks that the links of all photos are not broken.")
    public void after_the_checks_are_done_click_on_the_seeAllPhotos_link_and_it_is_checks_that_the_links_of_all_photos_are_not_broken() {
        photoPage = new PhotoPage(driver);
        photoPage.clickPhotoLink();
        try {
            photoPage.checkPage1();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}

```






## TestRunner Class

```java

package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html/index.html",
                "json:target/cucumber-reports/cucumber.json"
        },
        features = {"src/test/resources/features/IMDB.feature"},
        glue = {"StepDefinitions"}

)

public class TestRunner extends AbstractTestNGCucumberTests {


}
```

