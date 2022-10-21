package Pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement find(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        find(locator).click();
    }

    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    public void type(By locator) {
        find(locator).getText();
    }

    public void write(By locator, String text) {
        find(locator).sendKeys(text);
    }

    public List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

}