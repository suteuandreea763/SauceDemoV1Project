//package teste_standard_user;
//
//import helpMethods.ElementHelper;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.Test;
//
//public class ID10CheckoutRedirectionTest {
//
//    public WebDriver driver;
//    private ElementHelper elementHelper;
//
//    @Test
//    public void RedirectToCheckout() {
//
//        driver = new ChromeDriver();
//        driver.get("https://www.saucedemo.com/v1/index.html");
//        driver.manage().window().maximize();
//
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//
//        WebElement usernameElement = driver.findElement(By.id("user-name"));
//        String usernameValue = "standard_user";
//        usernameElement.sendKeys(usernameValue);
//
//        WebElement passwordElement = driver.findElement(By.id("password"));
//        String passwordValue = "secret_sauce";
//        passwordElement.sendKeys(passwordValue);
//
//        WebElement loginButtonElement = driver.findElement(By.id("login-button"));
//        loginButtonElement.click();
//
//        WebElement addToCart1 = driver.findElement(By.xpath
//                ("//div[@class='inventory_list']//div[1]//div[3]//button[1]"));
//        executor.executeScript("arguments[0].click();", addToCart1);
//
//        WebElement addToCart2 = driver.findElement(By.xpath
//                ("//div[5]//div[3]//button[1]"));
//        executor.executeScript("arguments[0].click();", addToCart2);
//
//        WebElement addToCart3 = driver.findElement(By.xpath
//                ("//body//div[@id='page_wrapper']//div[@id='inventory_container']" +
//                        "//div[@id='inventory_container']//div[2]//div[3]//button[1]"));
//        executor.executeScript("arguments[0].click();", addToCart3);
//
//        WebElement addToCart4 = driver.findElement(By.xpath
//                ("//div[3]//div[3]//button[1]"));
//        executor.executeScript("arguments[0].click();", addToCart4);
//
//        WebElement addToCart5 = driver.findElement(By.xpath
//                ("//div[4]//div[3]//button[1]"));
//        executor.executeScript("arguments[0].click();", addToCart5);
//
//        WebElement addToCart6 = driver.findElement(By.xpath
//                ("//div[6]//div[3]//button[1]"));
//        executor.executeScript("arguments[0].click();", addToCart6);
//
//
//        WebElement cartButtonElement = driver.findElement(By.className("shopping_cart_badge"));
//        cartButtonElement.click();
//
//        WebElement checkoutElement = driver.findElement(By.xpath(
//                "//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]"));
//        checkoutElement.click();
//    }
//}


package teste_standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ID10CheckoutRedirectionTest {
    public WebDriver driver;

    @Test
    public void verifyRedirectToCheckout() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement addToCartButton = driver.findElement(By.xpath("//div[3]//div[3]//button[1]"));
        addToCartButton.click();

        WebElement cartButton = driver.findElement(By.id("shopping_cart_container"));
        cartButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath
                ("//a[@class='btn_action checkout_button']")));
        executor.executeScript("arguments[0].click();", checkoutButton);

        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("checkout-step-one")) {
            System.out.println("Test trecut: Utilizatorul a fost redirecționat către pagina de check-out.");
        } else {
            System.out.println("Test eșuat: Redirecționarea către pagina de check-out nu a funcționat.");
        }

        driver.quit();
    }
}