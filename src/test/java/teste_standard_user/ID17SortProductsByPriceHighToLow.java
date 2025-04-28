package teste_standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ID17SortProductsByPriceHighToLow {
    public WebDriver driver;

    @Test
    public void verifySortByPriceHighToLow() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement sortMenu = driver.findElement(By.className("product_sort_container"));
        sortMenu.click();
        driver.findElement(By.xpath("//option[@value='hilo']")).click();

        System.out.println("Sortarea după preț (de la mare la mic) a fost realizată.");

        driver.quit();
    }
}

