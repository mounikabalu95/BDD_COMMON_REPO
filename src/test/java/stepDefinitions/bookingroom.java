package stepDefinitions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class bookingroom {
    WebDriver driver = new ChromeDriver();
    @Given("Open the booking application")
    public void open_the_booking_application() {
        driver.get("https://automationintesting.online/");
        driver.getTitle();
        System.out.println("User landed on homepage");
    }
    @When("select the room")
    public void select_the_room() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bookRoomButton =  wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//*[@id=\"root\"]/body/div/div/div[4]/div/div/div[3]/button"))
        );
        bookRoomButton.click();
    }
    @When("select the date")
    public void select_the_date() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement startDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='11']")));
        WebElement endDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='13']")));
     
        Actions actions = new Actions(driver);
     
        // Click and hold on the first date
        actions.clickAndHold(startDate).pause(500)  // Hold for a short duration
     
               // Move slightly to simulate drag instead of direct jump
               .moveByOffset(20, 0)  
               .moveToElement(endDate)  
     
               // Release mouse to complete drag
               .release()
               .perform();
     
        System.out.println(" Drag and Select completed!");
    }
    @When("Enter the details")
    public void enter_the_details() {
        WebElement firstnametext = driver.findElement(By.name("firstname"));
        firstnametext.sendKeys("Mounkaahsji");
        WebElement lastnametext = driver.findElement(By.name("lastname"));
        lastnametext.sendKeys("Subash");
        WebElement emailtext = driver.findElement(By.name("email"));
        emailtext.sendKeys("mounikabajsah@gmail.com");
        WebElement phonetext = driver.findElement(By.name("phone"));
        phonetext.sendKeys("997262728282");
        System.out.println("Entered the details");
    }
    @Then("Book the ticket")
    public void book_the_ticket() {
        WebElement bookTicBut = driver.findElement(By.xpath("//*[@id=\"root\"]/body/div/div/div[4]/div/div[2]/div[3]/button[2]"));
        bookTicBut.click();
        System.out.println("Booked the ticket");
    }
    @Then("Confirm the booking")
    public void confirm_the_booking() {
        System.out.println("Boooking room is confirmed for you");
    }
}
