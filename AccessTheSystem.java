import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class AccessTheSystem {

    WebDriver driver;
    WebElement element;

    @Before
public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Elitebook\\OneDrive\\Работен плот\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }
    @Test
    public void accessTheSystemAsGuest()
    {
        driver.get("https://teodor.bg/");
        element = driver.findElement(By.xpath("//*[contains(text(), 'Безплатна доставка за всички')]"));
        assertTrue("Text in Bulgarian", element.isDisplayed());
    }
}
