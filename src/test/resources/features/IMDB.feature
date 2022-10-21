Feature: TesterYou IMDB

  Scenario: check The Circus information and whether photos have been opened
    Given Browser is open
    Given Press the Menu button on the left side of the search bar.
    And On the loaded page, clicks the Oscar button under the Award & Events heading.
    And Under the Event History heading, the value 1929 is selected.
    And The Circus is selected under the Honorary Award
    And The loaded page, the director's information, the Writer's information, and the star information of The Circus are saved.
    And Click on the IMDB button at the top left of the screen and return to the Home page.
    And Types "The Circus (1928)" to the search bar
    And Click on The Circus that appears among the results.
    Then The loaded page compares previous director, writer, and star information, and new ones belong to The Circus
    Then After the checks are done, click on the See all .. photos link. and it is checks that the links of all photos are not broken.
    Then Browser is close

  Scenario: check The Jazz Singer information and whether photos have been opened
    Given Browser is open
    Given Press the Menu button on the left side of the search bar.
    And On the loaded page, clicks the Oscar button under the Award & Events heading.
    And Under the Event History heading, the value 1929 is selected.
    And The Jazz Singer is selected under the Honorary Award
    And The loaded page, the director's information, the Writer's information, and the star information of The Jazz Singer are saved.
    And Click on the IMDB button at the top left of the screen and return to the Home page.
    And Types "The Jazz Singer (1927)" to the search bar
    And Click on The jazzSinger that appears among the results.
    Then The loaded page compares previous director, writer, and star information, and new ones belong to The Jazz Singer
    Then After the checks are done, click on the See all photos link. and it is checks that the links of all photos are not broken.
    Then Browser is close
