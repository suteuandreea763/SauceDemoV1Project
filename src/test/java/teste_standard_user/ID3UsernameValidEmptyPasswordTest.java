package teste_standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ID3UsernameValidEmptyPasswordTest {
    public WebDriver driver;

    @Test
    public void verifyLoginInvalid() {

        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.manage().window().maximize();


        WebElement usernameElement=driver.findElement(By.id("user-name"));
        String usernameValue="standard_user";
        usernameElement.sendKeys(usernameValue);

        WebElement passwordElement=driver.findElement(By.id("password"));
        String passwordValue="";
        passwordElement.sendKeys(passwordValue);

        WebElement loginButtonElement=driver.findElement(By.id("login-button"));
        loginButtonElement.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-button")));

        String errorMessage = errorMessageElement.getText();
        System.out.println("Epic sadface: Password is required " + errorMessage);


    }
}
