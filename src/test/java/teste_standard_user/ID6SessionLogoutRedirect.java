package teste_standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ID6SessionLogoutRedirect {
    public WebDriver driver;

    @Test
    public void LogoutRedirect(){

        driver=new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        JavascriptExecutor executor = (JavascriptExecutor) driver;


        WebElement usernameElement=driver.findElement(By.id("user-name"));
        String usernameValue="standard_user";
        usernameElement.sendKeys(usernameValue);

        WebElement passwordElement=driver.findElement(By.id("password"));
        String passwordValue="secret_sauce";
        passwordElement.sendKeys(passwordValue);

        WebElement loginButtonElement=driver.findElement(By.id("login-button"));
        loginButtonElement.click();

        WebElement burgerMenuElement= driver.findElement(By.className("bm-burger-button"));
        burgerMenuElement.click();

        WebElement logoutElement=driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        executor.executeScript("arguments[0].click();",logoutElement);


        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/")) {
            System.out.println("Logout successful: The user has been redirected to the login page.");
        } else {
            System.out.println("Logout failed: The user was not redirected to the login page.");
        }

         driver.quit();

    }
}
