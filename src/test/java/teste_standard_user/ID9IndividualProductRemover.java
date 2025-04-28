package teste_standard_user;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Map;

public class ID9IndividualProductRemover {
    public WebDriver driver;


    @Test
    public void RemoveIndividualItems() {

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

        WebElement usernameElement = driver.findElement(By.id("user-name"));
        String usernameValue = "standard_user";
        usernameElement.sendKeys(usernameValue);

        WebElement passwordElement = driver.findElement(By.id("password"));
        String passwordValue = "secret_sauce";
        passwordElement.sendKeys(passwordValue);

        WebElement loginButtonElement = driver.findElement(By.id("login-button"));
        loginButtonElement.click();

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


        WebElement removeFromCart1 = driver.findElement(By.id("remove-sauce-labs-backpack"));
        executor.executeScript("arguments[0].click();", removeFromCart1);


        WebElement removeFromCart2 = driver.findElement(By.id("remove-sauce-labs-bike-light"));
        executor.executeScript("arguments[0].click();", removeFromCart2);


        WebElement removeFromCart3 = driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt"));
        executor.executeScript("arguments[0].click();", removeFromCart3);


        WebElement removeFromCart4 = driver.findElement(By.id("remove-sauce-labs-fleece-jacket"));
        executor.executeScript("arguments[0].click();", removeFromCart4);


        WebElement removeFromCart5 = driver.findElement(By.id("remove-sauce-labs-onesie"));
        executor.executeScript("arguments[0].click();", removeFromCart5);


        WebElement removeFromCart6 = driver.findElement(By.id("remove-test.allthethings()-t-shirt-(red)"));
        executor.executeScript("arguments[0].click();", removeFromCart6);

        driver.quit();
        }
    }

