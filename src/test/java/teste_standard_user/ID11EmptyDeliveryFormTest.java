package teste_standard_user;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

public class ID11EmptyDeliveryFormTest {
    public WebDriver driver;

    @Test
    public void testErrorMessageForEmptyFields(){
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
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        new Actions(driver).sendKeys(Keys.ESCAPE).perform();

        driver.findElement(By.tagName("body")).click();

        WebElement addToCart1 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        executor.executeScript("arguments[0].click();", addToCart1);

        WebElement addToCart2 = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        executor.executeScript("arguments[0].click();", addToCart2);

        WebElement addToCart3 = driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt"));
        executor.executeScript("arguments[0].click();", addToCart3);

        WebElement addToCart4 = driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket"));
        executor.executeScript("arguments[0].click();", addToCart4);

        WebElement addToCart5 = driver.findElement(By.id("add-to-cart-sauce-labs-onesie"));
        executor.executeScript("arguments[0].click();", addToCart5);

        WebElement addToCart6 = driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));
        executor.executeScript("arguments[0].click();", addToCart6);

        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        WebElement checkoutElement = driver.findElement(By.id("checkout"));
        executor.executeScript("arguments[0].click();", checkoutElement);

        driver.findElement(By.id("first-name")).sendKeys("");
        driver.findElement(By.id("last-name")).sendKeys("");
        driver.findElement(By.id("postal-code")).sendKeys("");

        WebElement continueButtonElement = driver.findElement(By.id("continue"));
        continueButtonElement.click();

        try {
            WebElement errorMessageElement = driver.findElement(By.cssSelector(".error-message-container"));
            String actualErrorMessage = errorMessageElement.getText();
            String expectedErrorMessage = "Error: [First Name/Last Name/Zip/PostalCode] is required";


            Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
                    "Test failed: The error message is incorrect. Expected '"
                            + expectedErrorMessage + "' but got '" + actualErrorMessage + "'");

            System.out.println("Test passed!");
        } catch (NoSuchElementException e) {
            Assert.fail("Test failed: The error message is incorrect or missing!");
        }

        driver.quit();
    }
}




