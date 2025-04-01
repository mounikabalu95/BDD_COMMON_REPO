package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {
	private WebDriver driver;

	// Constructor to initialize driver and elements
	public PageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Login Elements
	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement username;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	@FindBy(xpath = "//input[@id='login-button']")
	private WebElement loginButton;

	// Product Selection Elements
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	private WebElement addToCart;

	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement shoppingCart;

	@FindBy(xpath = "//button[@id='checkout']")
	private WebElement checkout;

	// Customer Details Elements
	@FindBy(id = "first-name")
	private WebElement firstName;

	@FindBy(id = "last-name")
	private WebElement lastName;

	@FindBy(id = "postal-code")
	private WebElement postCode;

	@FindBy(id = "continue")
	private WebElement continueButton;

	// Order Confirmation Elements
	@FindBy(id = "finish")
	private WebElement finish;

	@FindBy(xpath = "//h2[contains(text(),'Thank you for your order!')]")
	private WebElement orderConfirm;

	// Login Method
	public void login(String userName, String passWord) {
		username.sendKeys(userName);
		password.sendKeys(passWord);
		loginButton.click();
	}

	// Product Selection Method
	public void selectProduct() {
		addToCart.click();
		shoppingCart.click();
		checkout.click();
	}

	// Enter Customer Details Method
	public void enterCustomerDetails(String first, String last, String pin) {
		firstName.sendKeys(first);
		lastName.sendKeys(last);
		postCode.sendKeys(pin);
		continueButton.click();
	}

	// Order Confirmation Method
	public void orderCheck() {
		finish.click();
		if (orderConfirm.isDisplayed()) {
			System.out.println(" Order is placed successfully!");
		} else {
			System.out.println(" Order placement failed!");
		}
	}
}
