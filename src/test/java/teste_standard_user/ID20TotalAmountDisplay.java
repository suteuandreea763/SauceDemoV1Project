package teste_standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ID20TotalAmountDisplay {
    @Test
    public void testCheckoutProcess() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/index.html");

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement addToCartButton = driver.findElement(By.xpath
                ("/html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[3]/div[3]/button[1]"));
        executor.executeScript("arguments[0].click();", addToCartButton);

        driver.findElement(By.id("shopping_cart_container")).click();

        WebElement checkoutButton = driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));
        executor.executeScript("arguments[0].click();", checkoutButton);

        driver.findElement(By.id("first-name")).sendKeys("Andreea");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("12345");

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='CONTINUE']"));
        executor.executeScript("arguments[0].click();", continueButton);

        WebElement totalAmountElement = driver.findElement(By.className("summary_total_label"));
        String totalAmount = totalAmountElement.getText();
        System.out.println("Suma totală afișată: " + totalAmount);

        driver.quit();

    }
}







