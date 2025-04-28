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

public class ID22PlaceOrderWithoutItems {

    @Test
    public void placeOrderWithoutAddingProducts() {
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

        executor.executeScript("arguments[0].click();", driver.findElement(By.className("shopping_cart_link")));

        WebDriverWait waitCheckout = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutButton = waitCheckout.until(ExpectedConditions.elementToBeClickable
                (By.className("checkout_button")));
        executor.executeScript("arguments[0].click();", checkoutButton);

        WebDriverWait waitForm = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitForm.until(ExpectedConditions.urlContains("checkout-step-one.html"));

        WebElement firstNameInput = waitForm.until
                (ExpectedConditions.visibilityOfElementLocated(By.id("first-name")));

        firstNameInput.sendKeys("Andreea");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("12345");

        driver.findElement(By.name("continue")).click();

        WebDriverWait waitFinish = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement finishButton = waitFinish.until(ExpectedConditions.elementToBeClickable(By.id("finish")));
        executor.executeScript("arguments[0].click();", finishButton);

        try {
            WebElement errorMessage = driver.findElement(By.className("complete-header"));
            String message = errorMessage.getText();
            if (!message.equalsIgnoreCase("The shopping cart is empty, the order cannot be placed.")) {
                throw new AssertionError("Test failed! Unexpected message: " + message);
            }
        } catch (NoSuchElementException e) {
            throw new AssertionError("Test failed! Error message not displayed.");
        }

        driver.quit();
    }
}
