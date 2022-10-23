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
