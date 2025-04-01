package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenuHover {
    WebDriver driver = new ChromeDriver();

@Given("Menu items should be loaded properly")
public void menu_items_should_be_loaded_properly() {
    driver.get("https://demowebshop.tricentis.com/");
    driver.manage().window().maximize();
    driver.getTitle(); 
}
@When("I have to hover the menu")
public void i_have_to_hover_the_menu() {
    WebElement HoverMenu = driver.findElement(By.xpath("//ul[@class='top-menu']//following-sibling::a[contains(text(),'Computers')]"));
    Actions actions = new Actions(driver);
    actions.moveToElement(HoverMenu).perform();
    //Thread.sleep(2000);
    System.out.println("Hovered the menu");
}
@Then("I can able to select the submenu")
public void i_can_able_to_select_the_submenu() {
    WebElement SubMenu = driver.findElement(By.xpath("//a[@href='/notebooks']"));
    SubMenu.click();
    System.out.println("Selected the submenu");
    driver.quit();
}

}
