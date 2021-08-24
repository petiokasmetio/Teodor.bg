import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginPage {
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
    public void userLogin() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        element = driver.findElement(By.id("send2"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        assertEquals("МОЯТ ПРОФИЛ", driver.findElement(By.xpath("//*[@class='base']")).getText());
      //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       //FileUtils.copyFile(scrFile, new File("C:\\Users\\Elitebook\\OneDrive\\Работен плот\\screenshotjava.jpg"));
    }
    @Test
    public void userLogout() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        element = driver.findElement(By.id("send2"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click(element).perform();;
        driver.findElement(By.xpath("//*[@class='account-logout']")).click();
        WebDriverWait waitLogoText = new WebDriverWait(driver, 10);
        waitLogoText.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='header-top-message page-main']")));
        assertEquals("БЕЗПЛАТНА ДОСТАВКА ЗА ВСИЧКИ ПОРЪЧКИ НАД 99.99ЛВ", driver.findElement(By.xpath("//*[@class='header-top-message page-main']")).getText());
    }
    @Test
        public void userLoginInvalidEmailData() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("asfasfasf@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        element = driver.findElement(By.id("send2"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        WebDriverWait waitErrorMessage = new WebDriverWait(driver, 5);
        waitErrorMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='message-error error message']")));
        assertEquals("Влизането в профила е неправилно или профилът Ви е деактивиран временно. Моля, изчакайте и опитайте отново по-късно.", driver.findElement(By.xpath("//*[@class='message-error error message']")).getText());
    }
    @Test
    public void userLoginInvalidPasswordData() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16asgagw3gsdg");
        element = driver.findElement(By.id("send2"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        WebDriverWait waitErrorMessage = new WebDriverWait(driver, 5);
        waitErrorMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='message-error error message']")));
        assertEquals("Влизането в профила е неправилно или профилът Ви е деактивиран временно. Моля, изчакайте и опитайте отново по-късно.", driver.findElement(By.xpath("//*[@class='message-error error message']")).getText());
    }
    @Test
    public void userLoginInvalidPasswordInvalidEmailData() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("asfasf23ffasf@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qadf3223fwqqq16");
        element = driver.findElement(By.id("send2"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        WebDriverWait waitErrorMessage = new WebDriverWait(driver, 5);
        waitErrorMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='message-error error message']")));
        assertEquals("Влизането в профила е неправилно или профилът Ви е деактивиран временно. Моля, изчакайте и опитайте отново по-късно.", driver.findElement(By.xpath("//*[@class='message-error error message']")).getText());
    }
    @Test
    public void userLoginWithEmptyEmailData() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        element = driver.findElement(By.id("send2"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        WebDriverWait waitErrorMessage = new WebDriverWait(driver, 5);
        waitErrorMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='mage-error']")));
        assertEquals("Това е задължително поле.", driver.findElement(By.xpath("//*[@class='mage-error']")).getText());
    }
    @Test
    public void userLoginWithEmptyPasswordData() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("");
        element = driver.findElement(By.id("send2"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        WebDriverWait waitErrorMessage = new WebDriverWait(driver, 5);
        waitErrorMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='mage-error']")));
        assertEquals("Това е задължително поле.", driver.findElement(By.xpath("//*[@class='mage-error']")).getText());
    }
    @Test
    public void backKeysArowToReturnBackWithLoggedUser() throws IOException {
//        driver.manage().window().maximize();
//        driver.get("https://teodor.bg");
//        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
//        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
//        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
//        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
//        element = driver.findElement(By.id("send2"));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(element).perform();
//        actions.click(element).perform();
//        driver.findElement(By.xpath("//*[@class='account-logout']")).click();
//        WebDriverWait waitLogoText = new WebDriverWait(driver, 10);
//        waitLogoText.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='header-top-message page-main']")));
//        assertEquals("БЕЗПЛАТНА ДОСТАВКА ЗА ВСИЧКИ ПОРЪЧКИ НАД 99.99ЛВ", driver.findElement(By.xpath("//*[@class='header-top-message page-main']")).getText());
//        Actions actionsBackSpace = new Actions(driver);
//        element.click(Keys.BACK_SPACE.);
    }
    @Test
    public void enterWithGoogleAccount() throws IOException {
//        driver.manage().window().maximize();
//        driver.get("https://teodor.bg");
//        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
//        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
//        driver.findElement(By.xpath("//*[@class='actions-toolbar social-btn social-btn-actions-toolbar google-login']")).click();
////        element = driver.findElement(By.xpath("//*[@class='fa fa-google']"));
////        Actions actions = new Actions(driver);
////        actions.moveToElement(element).perform();
////        actions.click(element).perform();
//        assertEquals("МОЯТ ПРОФИЛ", driver.findElement(By.xpath("//*[@class='base']")).getText());
    }
}
