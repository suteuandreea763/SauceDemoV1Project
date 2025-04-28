package teste_standard_user;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

public class ID21ThankYouMessage {
    @Test
    public void verifyThankYouMessage() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--incognito");
        options.addArguments("--enable-automation");
        options.addArguments("--disable-extensions");
        options.setExperimentalOption("prefs", Map.of(
                "credentials_enable_service", false,
                "profile.password_manager_enabled", false,
                "profile.default_content_setting_values.notifications", 2
        ));

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        new Actions(driver).sendKeys(Keys.ESCAPE).perform();

        driver.findElement(By.tagName("body")).click();

        WebElement addToCart = driver.findElement(By.cssSelector("button#add-to-cart-sauce-labs-backpack"));
        executor.executeScript("arguments[0].click();", addToCart);

        WebElement cartElement = driver.findElement(By.className("shopping_cart_link"));
        executor.executeScript("arguments[0].click();", cartElement);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("checkout_button")));
        executor.executeScript("arguments[0].click();", checkoutButton);


        driver.findElement(By.id("first-name")).sendKeys("Andreea");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("12345");

        driver.findElement(By.id("continue")).click();
        WebElement finishButton = driver.findElement(By.id("finish"));
        executor.executeScript("arguments[0].click();", finishButton);

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



