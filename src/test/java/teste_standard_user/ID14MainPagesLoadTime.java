package teste_standard_user;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ID14MainPagesLoadTime {
        public WebDriver driver;

        @BeforeClass
        public void setUp() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        public void verifyLoginPageLoadTime() {
            long startTime = System.nanoTime();
            driver.get("https://www.saucedemo.com/");
            long endTime = System.nanoTime();

            long loadTimeInSeconds = (endTime - startTime) / 1_000_000_000;

            System.out.println("Timpul de încărcare al paginii de autentificare: " + loadTimeInSeconds + " secunde");

            Assert.assertTrue(loadTimeInSeconds < 2,
                    "Test eșuat: Timpul de răspuns al paginii de autentificare depășește 2 secunde!");
        }

        @Test
        public void verifyProductsPageLoadTime() {
            long startTime = System.nanoTime();
            driver.get("https://www.saucedemo.com/inventory.html");
            long endTime = System.nanoTime();

            long loadTimeInSeconds = (endTime - startTime) / 1_000_000_000;

            System.out.println("Timpul de încărcare al paginii de produse: " + loadTimeInSeconds + " secunde");

            Assert.assertTrue(loadTimeInSeconds < 2,
                    "Test eșuat: Timpul de răspuns al paginii de produse depășește 2 secunde!");
        }

        @Test
        public void verifyCartPageLoadTime() {
            long startTime = System.nanoTime();
            driver.get("https://www.saucedemo.com/cart.html");
            long endTime = System.nanoTime();

            long loadTimeInSeconds = (endTime - startTime) / 1_000_000_000;

            System.out.println("Timpul de încărcare al paginii de coș: " + loadTimeInSeconds + " secunde");

            Assert.assertTrue(loadTimeInSeconds < 2,
                    "Test eșuat: Timpul de răspuns al paginii de coș depășește 2 secunde!");
        }

        @AfterClass
        public void tearDown() {
            driver.quit();
        }
    }


