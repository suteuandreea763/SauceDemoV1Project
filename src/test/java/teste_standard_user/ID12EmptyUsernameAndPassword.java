package teste_standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ID12EmptyUsernameAndPassword {
    public WebDriver driver;

    @Test
    public void verifyLoginInvalid() {

        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();


        WebElement usernameElement=driver.findElement(By.id("user-name"));
        String usernameValue="";
        usernameElement.sendKeys(usernameValue);

        WebElement passwordElement=driver.findElement(By.id("password"));
        String passwordValue="";
        passwordElement.sendKeys(passwordValue);

        WebElement loginButtonElement=driver.findElement(By.id("login-button"));
        loginButtonElement.click();


        WebElement errorMessageElement = driver.findElement(By.cssSelector("[data-test='error']"));
        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = "Username and password are required";


        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "Test eșuat: Mesajul de eroare nu este cel așteptat!");

        driver.quit();

    }
}
