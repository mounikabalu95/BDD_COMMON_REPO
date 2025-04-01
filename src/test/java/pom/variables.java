package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class variables {
    WebDriver driver;

    public By searchBox=(By.xpath("//*[@id='searchBar']"));

    public By bookvalue = By.xpath("//ul[@id='productList']/li");

}
