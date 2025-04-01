package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.PageObjects;

public class Login {
    public WebDriver driver;
    private PageObjects po;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        po = new PageObjects(driver); // Initialize PageObjects after driver is created
    }

    @Given("I want to login to the application")
    public void i_want_to_login_to_the_application() {
        driver.get("https://www.saucedemo.com/");
        po.login("standard_user", "secret_sauce");
    }

    @Given("Select the products")
    public void select_the_products() {
        po.selectProduct();
    }

    @Then("Enter the customer details")
    public void enter_the_customer_details() {
        po.enterCustomerDetails("zayn", "malik", "897098");
    }

    @Then("Confirm the order")
    public void confirm_the_order() {
        po.orderCheck();
    }
}
