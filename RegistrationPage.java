import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationPage {

    WebDriver driver;
    WebElement element;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Elitebook\\OneDrive\\Работен плот\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void registrationPage()
    {
        driver.get("https://teodor.bg/");
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@class='action create primary']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='page-title-wrapper']")).isDisplayed());
    }
    @Test
    public void duplicateRegistration()
    {
//        driver.get("https://teodor.bg/");
//        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
//        driver.findElement(By.xpath("//*[@class='action create primary']")).click();
//        driver.findElement(By.id("firstname")).sendKeys("qqqq16");
//        driver.findElement(By.id("lastname")).sendKeys("qqqq16");
//        driver.findElement(By.id("email_address")).sendKeys("qqqq16@gmail.com");
//        driver.findElement(By.id("password")).sendKeys("qqqq16");
//        driver.findElement(By.id("password-confirmation")).sendKeys("qqqq16");
//        driver.findElement(By.id("customer_account_create_1")).click();
//        driver.findElement(By.id("customer_account_create_2")).click();
//        driver.findElement(By.id("customer_account_create_3")).click();
//        driver.findElement(By.id("rc-anchor-container")).click();
//        driver.findElement(By.xpath("//*[@class='action submit primary']")).click();
        //Unable to check reCAPCHA checkbox
    }
    @Test
            public void forgottenPasswordChange()
    {
//        driver.get("https://teodor.bg/");
//        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
    }
}
