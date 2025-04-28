package teste_standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ID8CartItemAdder {
    public WebDriver driver;

    @Test
    public void AddToCart() {

        driver = new ChromeDriver();
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


        WebElement cartBadge = driver.findElement(By.className("shopping_cart_container"));
        int actualProductCount = Integer.parseInt(cartBadge.getText());
        int expectedProductCount = 6;

        if (actualProductCount == expectedProductCount) {
            System.out.println("Test reușit: Numărul de produse din coș este corect. Produse adăugate: " + actualProductCount);
        } else {
            System.out.println("Test eșuat: Numărul de produse din coș NU corespunde. Așteptat: " + expectedProductCount +
                    ", Găsit: " + actualProductCount);
        }

        driver.quit();
    }

}
