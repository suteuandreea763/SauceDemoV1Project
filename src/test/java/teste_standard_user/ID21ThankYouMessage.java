package teste_standard_user;

import helpMethods.AlertHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ID21ThankYouMessage {
    @Test
    public void verifyThankYouMessage() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("shopping_cart_container")).click();

        WebElement checkoutButton = driver.findElement(By.cssSelector(".btn_action.checkout_button"));
        executor.executeScript("arguments[0].click();", checkoutButton);

        driver.findElement(By.className("form_input")).sendKeys("Andreea");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        WebElement thankYouMessage = driver.findElement(By.className("complete-header"));
        String message = thankYouMessage.getText();
        if (message.equalsIgnoreCase("Thank you for your order!")) {
            System.out.println("Mesajul de confirmare este afișat corect: " + message);
        } else {
            System.out.println("Mesajul de confirmare nu este afișat corect.");
        }

        driver.quit();
    }
}

