package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class computerDatabase {
     WebDriver driver = new ChromeDriver();
    @Given("the user opens the computer database application")
    public void the_user_opens_the_computer_database_application() {
        driver.get("https://computer-database.gatling.io/computers");
        driver.getTitle();
    }
    @When("the list of computers is displayed")
    public void the_list_of_computers_is_displayed() {
        WebElement getComputers = driver.findElement(By.xpath("//a[text()='ACE']"));
        if(getComputers == null) {
            System.out.println("Database is empty");
        }
        System.out.println("Computers fetched successfully");
    }
    @When("the user searches for a computer by name")
    public void the_user_searches_for_a_computer_by_name() {
        driver.findElement(By.id("searchbox")).sendKeys("ARRA");
        driver.findElement(By.id("searchsubmit")).click();
    }
    @Then("the search results should display the correct computer")
    public void the_search_results_should_display_the_correct_computer() {
        WebElement getSearch = driver.findElement(By.xpath("//a[text()='ARRA']"));
        if(getSearch == null) {
            System.out.println("Search is not working as expected");
        }
        System.out.println("Computers fetched successfully");
    }
}
