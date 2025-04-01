package stepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class addtocart {
    WebDriver driver = new ChromeDriver();
    @Given("User is on the homepage")
    public void User_is_on_the_homepage() 
    {
        driver.get("https://demowebshop.tricentis.com/");
        driver.getTitle();
        System.out.println("User landed on homepage");
    }
    @When("User clicks on the category")
    public void User_Clicks_on_the_Category()
    {
        WebElement selectBook = driver.findElement(By.xpath("//ul[@class='top-menu']//following-sibling::a[contains(text(),'Books')]   "));
        selectBook.click();
        System.out.println("User clicks on the Books category successfully");
    }
    @And("User selects a book from the list")
    public void User_Selects_a_book_from_the_list()
    {
        WebElement selectBookItem = driver.findElement(By.xpath("//h2[@class='product-title']//following-sibling::a[contains(text(),'Health Book')] "));
        selectBookItem.click();
        System.out.println("User selects a book from the list successfully");
    }
    @And("User clicks on the cart button")
    public void User_clicks_on_the_cart_button()
    {
        WebElement addtoCartButton = driver.findElement(By.id("add-to-cart-button-22"));
        addtoCartButton.click();
        System.out.println("User clicks on the Add to Cart button successfully");
    }
    @Then("The book should be added to the cart")
    public void The_book_should_be_added_to_the_cart()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));  
        WebElement content = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("content")));
        String text = (String) ((JavascriptExecutor) driver).executeScript(
            "return arguments[0].childNodes[0].nodeValue;", content);
        System.out.println(text.trim()); // Output: Your item added to cart
    }
    @And("The cart should display the selected book")
    public void The_cart_should_display_the_selected_book()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the border notification to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("content")));

        // Now proceed with clicking the shopping cart
        WebElement checkCart = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='ico-cart']//following-sibling::span[contains(text(),'Shopping cart')]")));
        checkCart.click();

        try {
            WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='product']/a[contains(text(),'Health Book')]")));
            System.out.println("Item added to cart: " + cartItem.isDisplayed());
        } catch (Exception e) {
            System.out.println("Item not found in cart.");
        }
        driver.quit();
    }
}
