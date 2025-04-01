package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoApp {
    
WebDriver driver = new ChromeDriver();

@Given("The app url should be loaded properly")
public void the_app_url_should_be_loaded_properly() {
    driver.get("https://codebase.show/projects/realworld");
    driver.manage().window().maximize();  
    driver.getTitle();
}
@When("I navigated the hover")
public void i_navigated_the_hover() {
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement hoverElement = wait.until(
            ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Backend']"))
        );
        hoverElement.click();
//   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    WebElement hover= wait.until(driver.findElement(By.xpath("//div[text()='Backend']")));
//       hover.click();
}
@Then("I can able to see all the apps")
public void i_can_able_to_see_all_the_apps() {
   driver.close();
}
}
