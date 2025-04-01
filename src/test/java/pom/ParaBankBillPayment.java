package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ParaBankBillPayment {
    WebDriver driver = new ChromeDriver();
    @FindBy(name="payee.name")
    public WebElement PayeeName;

    @FindBy(xpath=("//input[@name='payee.address.street']"))
    public WebElement Address;

    public void enterAddress(String address) {
        Address.sendKeys(address);
    }
    @FindBy(xpath=("//input[@name='payee.address.city']"))
    public WebElement City;

    public void enterCity(String city) {
        City.sendKeys(city);
    }
    @FindBy(xpath=("//input[@name='payee.address.state']"))
    public WebElement State;

    public void enterState(String state) {
        State.sendKeys(state);
    }
    @FindBy(xpath=("//input[@name='payee.address.zipCode']"))
    public WebElement Zip;

    public void enterZip(String zip) {
        Zip.sendKeys(zip);
    }
    @FindBy(xpath=("//input[@name='payee.phoneNumber']"))
    public WebElement Phone;

    public void enterPhone(String phone) {
        Phone.sendKeys(phone);
    }
    @FindBy(xpath=("//input[@name='payee.accountNumber']"))
    public WebElement Account;

    public void enterAccount(String account) {
        Account.sendKeys(account);
    }

    @FindBy(xpath=("//input[@name='verifyAccount']"))
    public WebElement VerifyAccount;

    public void enterVerifyAccount(String VAccount) {
        VerifyAccount.sendKeys(VAccount);
    }
    @FindBy(xpath=("//input[@name='amount']"))
    public WebElement Amount;


    public void enterAmount(String amount) {
        Amount.sendKeys(amount);
    }
    /*@FindBy(xpath=("//select[@name='fromAccountId']"))
    public WebElement FromAccount;*/

    @FindBy(xpath=("//input[@class='button']"))
    public WebElement SendPaymentButton;
    public void enterSendPaymentButton(String paybutton) {
        SendPaymentButton.sendKeys(paybutton);
    }

    @FindBy(xpath=("//input[@value='Send Payment']"))
    public WebElement BillPaymentConfirmation;
    public void enterBillPaymentConfirmation() {
        BillPaymentConfirmation.click();
    }

    public ParaBankBillPayment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);  // Initialize elements        
    }
    public void enterPayeeName(String PName) {
        PayeeName.sendKeys(PName);
    }
}
