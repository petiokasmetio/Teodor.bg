import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class NavigationBar {

    WebDriver driver;
    WebElement element;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Elitebook\\OneDrive\\Работен плот\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void languageMenuBG() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://teodor.bg/");
        driver.findElement(By.xpath("//*[@class='actions dropdown options switcher-options']")).click();
        assertTrue(driver.findElement(By.xpath("//*[@class='actions dropdown options switcher-options']")).isDisplayed());
    }

    @Test
    public void languageRO()
    {
        driver.get("https://teodor.bg/");
        driver.findElement(By.xpath("//*[@class='actions dropdown options switcher-options']")).click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        element = driver.findElement(By.xpath("//*[@src='https://teodor.bg/media/ro_flag.png']"));
        Actions actions = new Actions(driver);
        actions.click(element).perform();
        element = driver.findElement(By.xpath("//*[contains(text(), 'Livrare gratuită')]"));
        assertTrue("Text in roman", element.isDisplayed());
    }
    @Test
    public void languageGR()
    {
        driver.get("https://teodor.bg/");
        driver.findElement(By.xpath("//*[@class='actions dropdown options switcher-options']")).click();
        element = driver.findElement(By.xpath("//*[@src='https://teodor.bg/media/gr-flag.png']"));
        Actions actions = new Actions(driver);
        actions.click(element).perform();
        element = driver.findElement(By.xpath("//*[contains(text(), 'Δωρεάν μεταφορικά')]"));
        assertTrue("Text in greek",  element.isDisplayed());
    }
    @Test
    public void currencyMenuBG()
    {
//        driver.get("https://teodor.bg/");
//        driver.findElement(By.id("switcher-currency-trigger")).click();
    }
    @Test
    public void currencyMenuEU()
    {
//        driver.get("https://teodor.bg/");
//        element = driver.findElement(By.xpath("//*[@class='language-BGN']"));
//        Actions actions = new Actions(driver);
//        actions.click(element).perform();
    }
    @Test
    public void searchField()
    {
//        driver.get("https://teodor.bg/");
//        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
//        element = driver.findElement(By.id("search_mini_form"));
//        Actions actions = new Actions(driver);
//        actions.click(element).perform();
    }
    @Test
    public void enterPage()
    {
        //"ВХОД"
        driver.get("https://teodor.bg/");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        Assert.assertTrue(driver.findElement(By.id("send2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='action create primary']")).isDisplayed());
    }
    @Test
    public void loginWithGoogleProfile()
    {
        driver.get("https://teodor.bg");
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@class='actions-toolbar social-btn social-btn-actions-toolbar google-login']")).click();
        Assert.assertTrue(driver.findElement(By.id("maincontent")).isDisplayed());
    }
    @Test
    public void myFavoritesButton()
    {
//        driver.get("https://teodor.bg");
//        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
//        element = driver.findElement(By.id("send2"));
//        Actions actions = new Actions(driver);
//        actions.click(element).perform();
//        driver.findElement(By.xpath("//*[@class='header-wishlist clever-link']")).click();
//        Assert.assertTrue(driver.findElement(By.id("wishlist-view-form")).isDisplayed());
    }
    @Test
    public void shoppingCartButton()
    {
        driver.get("https://teodor.bg");
        driver.findElement(By.xpath("//*[@class='action showcart clever-link']")).click();
        driver.findElement(By.id("maincontent")).getText();
        Assert.assertTrue(driver.findElement(By.id("maincontent")).isDisplayed());
    }
    @Test
    public void chatButton()
    {
//        driver.get("https://teodor.bg");
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.xpath("//*[@fill='#222222']")).click();
    }
}
