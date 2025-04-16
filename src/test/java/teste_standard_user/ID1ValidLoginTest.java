package teste_standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ID1ValidLoginTest {
 public WebDriver driver;

 @Test
    public void verifyLoginValid(){

     driver=new ChromeDriver();
     driver.get("https://www.saucedemo.com/v1/index.html");
     driver.manage().window().maximize();

     WebElement usernameElement=driver.findElement(By.id("user-name"));
     String usernameValue="standard_user";
     usernameElement.sendKeys(usernameValue);

     WebElement passwordElement=driver.findElement(By.id("password"));
     String passwordValue="secret_sauce";
     passwordElement.sendKeys(passwordValue);

     WebElement loginButtonElement=driver.findElement(By.id("login-button"));
     loginButtonElement.click();

 }

}
