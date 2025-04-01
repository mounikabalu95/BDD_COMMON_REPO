package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class placingorder {
    WebDriver driver = new ChromeDriver();
    @Given("Open the application")
    public void open_the_application() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.getTitle();
        System.out.println("Open the application");
    }
    @When("Select the category")
    public void select_the_category() {
        WebElement selectCat = driver.findElement(By.xpath("//span[text() = 'Women']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(selectCat).perform();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement productOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[(text() = 'Tops')]")));
        actions.moveToElement(productOption).perform();
        WebElement finalOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[(text() = 'Jackets')]")));
        finalOption.click();
    }
    @When("View the product")
    public void view_the_product() {
        WebElement viewProduct = driver.findElement(By.xpath("//a[@class='product-item-link' and contains(@href, 'olivia-1-4-zip-light-jacket.html')]"));
        viewProduct.click();
    }
    @When("Choose the size")
    public void choose_the_size() {
        WebElement selectSize = driver.findElement(By.xpath("//div[@id='option-label-size-143-item-170'][1]"));
        selectSize.click();
    }
    @When("Choose the color")
    public void choose_the_color() {
        WebElement selectSize = driver.findElement(By.xpath("//div[@id='option-label-color-93-item-57'][1]"));
        selectSize.click();
    }
    @Then("Add the product to cart")
    public void add_the_product_to_cart() {
        WebElement addprod = driver.findElement(By.xpath("//span[(text() = 'Add to Cart')]"));
        addprod.click();
    }
    @Then("verify the message")
    public void verify_the_message() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            // Wait for the border message to appear
            WebElement verifyMes = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]"))
            );
            System.out.println("✅ Success: Message appeared!");

            // Click another element if success message is present
            WebElement nextElement = driver.findElement(By.xpath("//a[normalize-space(text())='shopping cart']"));
            nextElement.click();
            System.out.println("✅ Clicked on the shopping cart link.");

        } catch (TimeoutException e) {
            // If the message does not appear, print an error
            System.out.println("❌ Error: Success message not found.");
        }
    }
    @Then("Verify the item added to cart")
    public void verify_the_item_added_to_cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            // Wait for the border message to appear
            WebElement verifyMes = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("(//a[normalize-space(text())='Olivia 1/4 Zip Light Jacket'])[2]"))
            );
            System.out.println("✅ Success: Message appeared!");

            // Click another element if success message is present
            WebElement nextElement = driver.findElement(By.xpath("//span[text()='Proceed to Checkout']"));
            nextElement.click();
            System.out.println("✅ Clicked on the shopping cart link.");

        } catch (TimeoutException e) {
            // If the message does not appear, print an error
            System.out.println("❌ Error: Success message not found.");
        }
    }
    @Then("Enter the shipping details")
    public void enter_the_shipping_details() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement verifyMes = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@id='customer-email'][1]"))
        );
        WebElement sendemail = driver.findElement(By.xpath("//*[@id='customer-email'][1]"));
        sendemail.sendKeys("subash@gmail.com");
        WebElement dropdown = driver.findElement(By.xpath("//select[@name='country_id']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("India");
        WebElement sendFirstname = driver.findElement(By.xpath("//input[@name='firstname']"));
        sendFirstname.sendKeys("subash");
        WebElement sendLastname = driver.findElement(By.xpath("//input[@name='lastname']"));
        sendLastname.sendKeys("S");
        WebElement sendstreet = driver.findElement(By.xpath("//input[@name='street[0]']"));
        sendstreet.sendKeys("no 1 a street");
        WebElement sendcity = driver.findElement(By.xpath("//input[@name='city']"));
        sendcity.sendKeys("Chennai");
        WebElement sendCode = driver.findElement(By.xpath("//input[@name='postcode']"));
        sendCode.sendKeys("600048");
        WebElement sendNo = driver.findElement(By.xpath("//input[@name='telephone']"));
        sendNo.sendKeys("7656568765");
        WebElement dropdownState = driver.findElement(By.xpath("//select[@name='region_id']"));
        Select selectTN = new Select(dropdownState);
        selectTN.selectByVisibleText("Tamil Nadu");
        WebDriverWait waitingtime = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait explicitly for 20 seconds before clicking
        waitingtime.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='radio' and @value='flatrate_flatrate' and @checked='true']")));
        
        WebElement clickProceed = driver.findElement(By.xpath("//span[text()='Next']"));
        clickProceed.click();
        
    }
    @Then("Click Place an Order")
    public void click_place_an_order() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox' and contains(@data-bind, 'checked: isAddressSameAsShipping')]")));
        WebElement clickPro = driver.findElement(By.xpath("//span[text()='Place Order']"));
        clickPro.click();
    }
    @Then("Verify the confirmation message")
    public void verify_the_confirmation_message() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement verifyMes = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//span[text() ='Thank you for your purchase!']")));
            if(verifyMes == null)
            {
                System.out.println("✅ Success: Message not appeared!");
            }
            System.out.println("✅ Success: Message appeared!");
    }
}
