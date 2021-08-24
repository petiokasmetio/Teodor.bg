import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class ShoppingCart {

    WebDriver driver;
    WebElement element;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Elitebook\\OneDrive\\Работен плот\\WebDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
//        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
//        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
//        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
//        driver.findElement(By.id("send2")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void shoppingCartIcon()
    {
        driver.findElement(By.xpath("//*[@class='action showcart clever-link']")).click();
        String noAddedProducts = driver.findElement(By.id("maincontent")).getText();
        assertTrue("give me empty shopping cart", noAddedProducts.contains("Нямате добавени продукти във вашата количка"));
    }
    @Test
    public void shoppingCartAddProduct()
    {
        element = driver.findElement(By.xpath("//*[@href='/obuvki']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element = driver.findElement(By.xpath("//*[@href='/obuvki/ofitsialni-obuvki']"));
        actions.click(element).perform();
        driver.findElement(By.xpath("//img[@class='product-image-photo'][contains(@id,'612034bedba89')]")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 5);
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='option-label-size1-208-item-178']"))).click();
        driver.findElement(By.id("product-addtocart-button")).click();
        driver.findElement(By.xpath("//*[@class='action showcart clever-link']")).click();
        Assert.assertTrue(driver.findElement(By.id("cart-totals")).isDisplayed());
    }
    @Test
    public void shoppingCartDeleteProduct() {
        element = driver.findElement(By.xpath("//*[@href='/obuvki']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element = driver.findElement(By.xpath("//*[@href='/obuvki/ofitsialni-obuvki']"));
        actions.click(element).perform();
        driver.findElement(By.xpath("//img[@class='product-image-photo'][contains(@id,'612034bedba89')]")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 5);
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='option-label-size1-208-item-178']"))).click();
        driver.findElement(By.id("product-addtocart-button")).click();
        element = driver.findElement(By.xpath("//*[@class='action showcart clever-link']"));
        actions.click(element).perform();
        element = driver.findElement(By.xpath("//div[contains(@class, 'action action-delete']"));
        actions.moveToElement(element).perform();
        actions.click(element).perform();
    }
}
