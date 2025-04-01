package stepDefinitions;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class linkSite {
    ChromeDriver driver = new ChromeDriver();

    @Given("I enter the element link url of domain")
    public void i_enter_the_element_link_url_of_domain() {
        driver.get("https://demoqa.com/links");
        System.out.println("Page Title: " + driver.getTitle());
    }

    // @When("I click links")
    // public void i_click_links() {
    //     WebElement homeLink = driver.findElement(By.id("simpleLink"));
    //     WebElement dynamicLink = driver.findElement(By.id("simpleLink"));


    //     // Scroll into view
    //     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homeLink);
    //     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dynamicLink);

    //     try {
    //         homeLink.click();
    //         dynamicLink.click();
    //     } catch (ElementClickInterceptedException e) {
    //         System.out.println("Element is intercepted, clicking using JavaScript...");
    //         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeLink);
    //     }

    //     // Wait for the new URL to load
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    //     wait.until(ExpectedConditions.urlContains("https://demoqa.com/"));

    //     // Take a screenshot
      //   takeScreenshot("LinkOpenedScreenshot");
    // }

    // public void takeScreenshot(String fileName) {
    //     // Define the directory path
    //     String directoryPath = System.getProperty("user.dir") + "/screenshots/";
    //     File directory = new File(directoryPath);
    
    //     // Create the directory if it doesn't exist
    //     if (!directory.exists()) {
    //         directory.mkdirs();  // Create directory and parent directories if needed
    //     }
    
    //     // Define the screenshot file path
    //     File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    //     File destFile = new File(directoryPath + fileName + ".png");
    
    //     try {
    //         FileHandler.copy(srcFile, destFile);
    //         System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
    //     } catch (IOException e) {
    //         System.out.println("Error capturing screenshot: " + e.getMessage());
    //     }
    // }
    

    

    @When("I click links")
    public void i_click_links() {
        // Links that open a new page
        WebElement homeLink = driver.findElement(By.id("simpleLink"));
        WebElement dynamicLink = driver.findElement(By.id("dynamicLink"));

        // Links that show a message on the same page
        WebElement createdLink = driver.findElement(By.id("created"));
        WebElement noContentLink = driver.findElement(By.id("no-content"));
        WebElement movedLink = driver.findElement(By.id("moved"));
        WebElement badrequestLink = driver.findElement(By.id("bad-request"));
        WebElement unauthorisedLink = driver.findElement(By.id("unauthorized"));
        WebElement forbiddwnLink = driver.findElement(By.id("forbidden")); 
        WebElement invalidLink = driver.findElement(By.id("invalid-url"));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", homeLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dynamicLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createdLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", noContentLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", movedLink);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", badrequestLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", unauthorisedLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", forbiddwnLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", invalidLink);
        
        

        // Click new page links
        try {
            homeLink.click();
            dynamicLink.click();
        } catch (ElementClickInterceptedException e) {
            System.out.println("Element is intercepted, clicking using JavaScript...");
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", homeLink);
        }

        // Wait for page load
        WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://demoqa.com/"));

        // Take a screenshot
        takeScreenshot("LinkOpenedScreenshot");

        // Click in-page response links
        createdLink.click();
        noContentLink.click();
        movedLink.click();
        badrequestLink.click();
        unauthorisedLink.click();
        forbiddwnLink.click();
        badrequestLink.click();
        invalidLink.click();

        // Wait for and verify response message
        WebElement responseMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("linkResponse")));
        String messageText = responseMessage.getText();
        System.out.println("Response Message: " + messageText);

        // Validate expected response messages
        Assert.assertTrue("Expected response message not found!", 
            messageText.contains("204") || messageText.contains("201")|| messageText.contains("404") || messageText.contains("301")|| messageText.contains("400")||messageText.contains("404")|| messageText.contains("401")||messageText.contains("403")|| messageText.contains("No Content"));
    }

    // ✅ Define the takeScreenshot method inside the class
    public void takeScreenshot(String fileName) {
        // Define the directory path
        String directoryPath = System.getProperty("user.dir") + "/screenshots/";
        File directory = new File(directoryPath);

        // Create the directory if it doesn't exist
        if (!directory.exists()) {
            directory.mkdirs();  // Create directory and parent directories if needed
        }

        // Define the screenshot file path
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(directoryPath + fileName + ".png");

        try {
            FileUtils.copyFile(srcFile, destFile);  // ✅ Corrected method
            System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error capturing screenshot: " + e.getMessage());
        }
    }

@Then("I open link successfully")
    public void i_open_link_successfully() {
        // driver.quit();
    }

}
