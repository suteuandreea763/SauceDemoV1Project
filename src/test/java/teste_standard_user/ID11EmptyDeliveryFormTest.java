package teste_standard_user;


import helpMethods.AlertHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ID11EmptyDeliveryFormTest {
    public WebDriver driver;

    @Test
    public void testErrorMessageForEmptyFields(){

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/");
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

        WebElement addToCart1 = driver.findElement(By.xpath
                ("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
        executor.executeScript("arguments[0].click();", addToCart1);

        WebElement addToCart2 = driver.findElement(By.xpath
                ("//div[5]//div[3]//button[1]"));
        executor.executeScript("arguments[0].click();", addToCart2);

        WebElement addToCart3 = driver.findElement(By.xpath
                ("//body//div[@id='page_wrapper']//div[@id='inventory_container']" +
                        "//div[@id='inventory_container']//div[2]//div[3]//button[1]"));
        executor.executeScript("arguments[0].click();", addToCart3);

        WebElement addToCart4 = driver.findElement(By.xpath
                ("//div[3]//div[3]//button[1]"));
        executor.executeScript("arguments[0].click();", addToCart4);

        WebElement addToCart5 = driver.findElement(By.xpath
                ("//div[4]//div[3]//button[1]"));
        executor.executeScript("arguments[0].click();", addToCart5);

        WebElement addToCart6 = driver.findElement(By.xpath
                ("//div[6]//div[3]//button[1]"));
        executor.executeScript("arguments[0].click();", addToCart6);


        WebElement cartButtonElement = driver.findElement(By.className("shopping_cart_badge"));
        cartButtonElement.click();


        WebElement checkoutElement = driver.findElement(By.xpath(
                "//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]"));
        executor.executeScript("arguments[0].click();", checkoutElement);

        WebElement continueButtonElement = driver.findElement(By.xpath(
                "//*[@id=\"checkout_info_container\"]/div/form/div[2]/input"));
        continueButtonElement.click();

        try {
            WebElement errorMessageElement = driver.findElement(By.cssSelector(".error-message-container"));
            String actualErrorMessage = errorMessageElement.getText();
            String expectedErrorMessage = "Error: [First Name/Last Name/Zip/PostalCode] is required";

            if (!actualErrorMessage.equals(expectedErrorMessage)) {
                System.out.println("Test failed: The error message is incorrect. Expected '"
                        + expectedErrorMessage + "' but got '" + actualErrorMessage + "'");
            } else {
                System.out.println("Test passed!");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Test failed: The error message is incorrect or missing!");
        }

        driver.quit();
    }
}

