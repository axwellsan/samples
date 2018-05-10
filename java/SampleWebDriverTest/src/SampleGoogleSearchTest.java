import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SampleGoogleSearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void searchEpamTest() throws Exception {
        driver.get("https://www.google.com");
        driver.findElement(By.id("lst-ib")).sendKeys("EPAM");
        driver.findElement(By.id("lst-ib")).sendKeys(Keys.ESCAPE);
        driver.findElement(By.name("btnK")).click();
        driver.findElements(By.cssSelector("#ires .g a")).get(0).click();
        Assert.assertTrue(driver.getCurrentUrl().startsWith("https://careers.epam."));
    }
}