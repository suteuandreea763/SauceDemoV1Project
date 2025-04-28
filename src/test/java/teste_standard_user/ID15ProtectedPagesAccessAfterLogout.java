package teste_standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ID15ProtectedPagesAccessAfterLogout {
    public WebDriver driver;

    @Test
    public void verifyCannotAccessProtectedPagesAfterLogout() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        JavascriptExecutor executor = (JavascriptExecutor) driver;

        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        driver.get("https://www.saucedemo.com/inventory.html");

        WebElement menuButton = driver.findElement(By.xpath("//button[normalize-space()='Open Menu']"));
        menuButton.click();

        WebElement logoutButton = driver.findElement(By.id("logout_sidebar_link"));
        executor.executeScript("arguments[0].click();", logoutButton);

        driver.get("https://www.saucedemo.com/inventory.html");

        String currentUrl = driver.getCurrentUrl();
        if (!currentUrl.contains("https://www.saucedemo.com/")) {
            System.out.println("Test eșuat: Utilizatorul poate accesa pagina protejată după delogare!");
        } else {
            System.out.println("Test trecut: Utilizatorul NU poate accesa pagina protejată după delogare.");
        }

        driver.quit();
    }
}

