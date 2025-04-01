package stepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PollTest {
    WebDriver driver = new ChromeDriver();

    
@Given("I logged into the application")
public void i_logged_into_the_application() {
    driver.get("https://demowebshop.tricentis.com/");
    driver.manage().window().maximize();  
    driver.getTitle();
}
@When("I have choosen the option for community poll")
public void i_have_choosen_the_option_for_community_poll() {
    WebElement PollText = driver.findElement(By.xpath("//input[@id='pollanswers-1']"));
    PollText.click();
}
@Then("I can submit the vote button")
public void i_can_submit_the_vote_button() {
    WebElement SubmitBtn = driver.findElement(By.xpath("//input[@class='button-2 vote-poll-button']"));
    SubmitBtn.click();
    driver.quit();
}
}