package teste_standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ID19SortProductsByNameZA {
    public WebDriver driver;

    @Test
    public void verifySortByNameZA() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/v1/");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement sortMenu = driver.findElement(By.className("product_sort_container"));
        sortMenu.click();
        driver.findElement(By.xpath("//option[@value='za']")).click();

        System.out.println("Sortarea produselor după nume (Z-A) a fost realizată.");

        driver.quit();
    }
}
