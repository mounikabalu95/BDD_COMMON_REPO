package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver = new ChromeDriver();
    public By customerlogin=(By.xpath("//input[@id='Email']"));
    
    @FindBy(xpath=("//input[@id='Password']"))
    public WebElement passwordTextbox;

    public By loginButton = (By.xpath("//input[@class='button-1 login-button']"));
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize elements        
    }
    public void enterPassword(String password) {
        passwordTextbox.sendKeys(password);
    }
}
