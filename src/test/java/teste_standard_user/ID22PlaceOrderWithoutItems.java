package teste_standard_user;

import helpMethods.AlertHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ID22PlaceOrderWithoutItems{
    @Test
    public void placeOrderWithoutAddingProducts() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        JavascriptExecutor executor = (JavascriptExecutor) driver;


        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();


        executor.executeScript("arguments[0].click();", driver.findElement(By.id("shopping_cart_container")));


        WebDriverWait waitCheckout = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutButton = waitCheckout.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn_action.checkout_button")));
        executor.executeScript("arguments[0].click();", checkoutButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        executor.executeScript("arguments[0].click();", continueButton);


        WebDriverWait waitError = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMessage = waitError.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("[data-test='error']")));

        String expectedErrorMessage = "Your cart is empty. Please add items before proceeding to checkout.";
        String actualErrorMessage = errorMessage.getText();

        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Test trecut: Mesajul de eroare este afișat corect.");
        } else {
            System.out.println("Test eșuat: Checkout-ul este permis fără produse în coș.");
            throw new AssertionError("Checkout permis fără produse: " + actualErrorMessage);
        }

        driver.quit();
    }
}


