package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pom.ParaBankBillPayment;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BankBillPayment {
    WebDriver driver = new ChromeDriver();
    
    ParaBankBillPayment bankpayee = new ParaBankBillPayment(driver);
    

    @Given("I enter the url of bank domain")
    public void i_enter_the_url_of_bank_domain() {
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://parabank.parasoft.com/parabank");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        username.sendKeys("muthu3");
        password.sendKeys("muthu3");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button']"));
        loginButton.click();
        WebElement element = driver.findElement(By.xpath("//a[text()='Bill Pay']"));
        element.click();
        driver.getTitle();
    }

    @When("I enter customer details to pay")
    public void i_enter_customer_details_to_pay() {

        bankpayee.enterPayeeName("Muthulakshmi");
        bankpayee.enterPhone("9876543210");
        bankpayee.enterAddress("Avadi");
        bankpayee.enterCity("Chennai");
        bankpayee.enterState("TamilNadu");
        bankpayee.enterZip("600062");
        bankpayee.enterAccount("123456789");
        bankpayee.enterVerifyAccount("123456789");
        bankpayee.enterAmount("1000");
        // bankpayee.FromAccount.sendKeys(null);
        bankpayee.enterBillPaymentConfirmation();

    }

    @Then("I can able to pay the amount successfully")
    public void i_can_able_to_pay_the_amount_successfully() {

        boolean isLoginSuccessful = (bankpayee.BillPaymentConfirmation).isDisplayed();
        if (isLoginSuccessful) {
            System.out.println("Bill Payment successful!");
        } else {
            System.out.println("Bill Payment failed!");
        }
        driver.quit();
    }

}