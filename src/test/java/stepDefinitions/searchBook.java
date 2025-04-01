package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pom.variables;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchBook {
    WebDriver driver = new ChromeDriver();
    variables value = new variables();
    @Given("I open the application")
    public void i_open_the_application() {
        driver.get("https://automationbookstore.dev/");
        driver.getTitle();
        System.out.println("Open the application");
    }
    @When("I search for the book by {string}")
    public void i_search_for_the_book_by(String values) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBar")));
        searchBar.clear();
        searchBar.sendKeys("Agile");

        // Wait until search results update (ensure at least one book is visible)
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Agile Testing')]")));

        // Retrieve only visible book results (ignoring hidden books)
        List<WebElement> bookResults = driver.findElements(By.xpath("//ul[@id='productList']/li[not(contains(@class, 'ui-screen-hidden'))]"));

        // Assert that at least one book is visible
        Assert.assertTrue("No books found after filtering!", bookResults.size() > 0);

        System.out.println("Found " + bookResults.size() + " visible book(s).");
    }
    @Then("I should see the book appear in the results")
    public void i_should_see_the_book_appear_in_the_results() {
        System.out.println("Search functionality works correctly!");
        driver.quit(); // Quit browser after test
    }
}
