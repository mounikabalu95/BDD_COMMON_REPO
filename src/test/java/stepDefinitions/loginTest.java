
package stepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import pom.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
public class loginTest {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);

    @FindBy(xpath="//input[@class='button-1 login-button']")
    WebElement loginbtn;

@Given("I enter the url of domain login")
public void i_enter_the_url_of_domain_login() {
    driver.get("https://demowebshop.tricentis.com/login");
    driver.manage().window().maximize();  
        driver.getTitle();

}
@When("I enter customer credential")
public void i_enter_customer_credential() {
    WebElement EmailtextBox =driver.findElement(loginPage.customerlogin);    
    EmailtextBox.sendKeys("muthu2@gmail.com");
    //WebElement PasswordText = driver.findElement(By.xpath("//input[@id='Password']"));
    
    loginPage.enterPassword("muthu123"); //using @FindBy
    //WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
    WebElement loginBtn = driver.findElement(loginPage.loginButton);
    loginBtn.click(); //using @FindBy locally
}

@Then("can login domain successfully")
public void can_login_domain_successfully() {
    //boolean isLoginSuccessful = driver.findElement(By.id("logoutButton")).isDisplayed();
    boolean isLoginSuccessful = driver.findElement(By.linkText("Log out")).isDisplayed();
            
    if (isLoginSuccessful) {
        System.out.println("Login successful!");
    } else {
        System.out.println("Login failed!");
    }
        driver.quit();
}
}


 
 