package teste_standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class ID7CorrectProductsLayoutChecker {
    public WebDriver driver;

    @Test
    public void ProductList() {

        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement usernameElement=driver.findElement(By.id("user-name"));
        String usernameValue="standard_user";
        usernameElement.sendKeys(usernameValue);

        WebElement passwordElement=driver.findElement(By.id("password"));
        String passwordValue="secret_sauce";
        passwordElement.sendKeys(passwordValue);

        WebElement loginButtonElement=driver.findElement(By.id("login-button"));
        loginButtonElement.click();


        List<WebElement> products = driver.findElements(By.className("inventory_item"));

        if (products.size() > 0) {
            System.out.println("Test reușit: Sunt afișate " + products.size() + " produse pe pagină.");
        } else {
            System.out.println("Test eșuat: Nu sunt afișate produse pe pagină.");
        }

        boolean allProductsDisplayedCorrectly = true;

        for (WebElement product : products) {
            if (!product.isDisplayed()) {
                allProductsDisplayedCorrectly = false;
                System.out.println("Test eșuat: Unul dintre produse nu este afișat corect.");
            }
        }

        if (allProductsDisplayedCorrectly) {
            System.out.println("Test reușit: Toate produsele sunt afișate corect și fără suprapuneri!");
        }
        driver.quit();
    }
}
