package teste_standard_user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

    public class ID13PasswordMaskingTest {
        public WebDriver driver;

        @Test
        public void verifyPasswordIsMasked() {

            driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");
            driver.manage().window().maximize();

            WebElement passwordField = driver.findElement(By.id("password"));

            String fieldType = passwordField.getAttribute("type");

            Assert.assertEquals(fieldType, "password",
                    "Test eșuat: Parola nu este mascată (câmpul nu este de tip 'password')!");

            driver.quit();
        }
    }


