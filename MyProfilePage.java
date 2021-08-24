import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyProfilePage {
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
    public void invoiceAddress() throws IOException {
//        driver.manage().window().maximize();
//        driver.get("https://teodor.bg");
//        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
//        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
//        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
//        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
//        driver.findElement(By.id("send2")).click();
//        driver.findElement(By.xpath("//*[@href='https://teodor.bg/customer/address/']")).click();
//        driver.findElement(By.id("telephone")).sendKeys("0234879987");
//        element = driver.findElement(By.xpath("//*[@title='Град']"));
//        Actions actions1 = new Actions(driver);
//        actions1.moveToElement(element).perform();
//        actions1.click(element).perform();
//        actions1.sendKeys("СОФИЯ").perform();
//        element = driver.findElement(By.xpath("//*[@title='Офис']"));
//        Actions actions2 = new Actions(driver);
//        actions2.moveToElement(element).perform();
//        actions2.click(element).perform();
//        actions2.sendKeys("СОФИЯ").perform();
//        element = driver.findElement(By.xpath("//*[@title='Запиши адрес']"));
//        Actions actions3 = new Actions(driver);
//        actions3.moveToElement(element).perform();
//        actions3.click(element).perform();
//        WebDriverWait waitErrorMessage = new WebDriverWait(driver, 5);
//        waitErrorMessage.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='message-success success message']")));
//        assertEquals("Вие запазихте адреса.", driver.findElement(By.xpath("//*[@class='message-success success message']")).getText());
//        //WORKS ONLY ONE TIME
    }

    @Test
    public void changeEmail() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/customer/account/edit/']")).click();
        driver.findElement(By.id("change-email")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.id("current-password")).sendKeys("qqqq16");
        driver.findElement(By.xpath("//*[@class='action save primary']")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='message-success success message']")));
        assertEquals("Вие запазихте информацията за профила.", driver.findElement(By.xpath("//*[@class='message-success success message']")).getText());
    }
    @Test
    public void changedPassword() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
       driver.findElement(By.id("send2")).click();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/customer/account/edit/']")).click();
        driver.findElement(By.id("change-password")).click();
        driver.findElement(By.id("current-password")).sendKeys("qqqq16");
        driver.findElement(By.id("password")).sendKeys("qqqq16");
        driver.findElement(By.id("password-confirmation")).sendKeys("qqqq16");
        driver.findElement(By.xpath("//*[@class='action save primary']")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='message-success success message']")));
        assertEquals("Вие запазихте информацията за профила.", driver.findElement(By.xpath("//*[@class='message-success success message']")).getText());
    }
    @Test
    public void invoiceDataComplete() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/customer/account/edit/']")).click();
        driver.findElement(By.id("customer_invoice")).click();
        driver.findElement(By.id("customer_invoice_company_name")).sendKeys("qqqq16");
        driver.findElement(By.id("customer_invoice_company_urn")).sendKeys("qqqq16");
        driver.findElement(By.id("customer_invoice_company_vat")).sendKeys("qqqq16");
        driver.findElement(By.id("customer_invoice_company_city")).sendKeys("qqqq16");
        driver.findElement(By.id("customer_invoice_company_addr")).sendKeys("qqqq16");
        driver.findElement(By.id("customer_invoice_company_pic")).sendKeys("qqqq16");
        driver.findElement(By.xpath("//*[@class='action save primary']")).click();
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='message-success success message']")));
        assertEquals("Вие запазихте информацията за профила.", driver.findElement(By.xpath("//*[@class='message-success success message']")).getText());
    }
    @Test
    public void favoriteMenuEmptyList() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.xpath("//*[@class='header-wishlist clever-link']")).click();
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='message info empty']")));
        assertEquals("Нямате продукти в списъка с любими", driver.findElement(By.xpath("//*[@class='message info empty']")).getText());
    }
    @Test
    public void addItemToFavorite() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        driver.findElement(By.id("send2")).click();
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element = driver.findElement(By.xpath("//*[@class='level-top']"));
        actions.click(element).perform();
        element = driver.findElement(By.xpath("//*[@title='СИЛНО ВТАЛЕН КОСТЮМ В ЕФЕКТНО СИНЬО - Teodor.bg']"));
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        By addToFavorites = By.xpath("//*[@data-action='add-to-wishlist']");
        WebDriverWait wait1 = new WebDriverWait(driver, 5);
        wait1.until(ExpectedConditions.elementToBeClickable(addToFavorites)).click();
        assertEquals("ЛЮБИМИ", driver.findElement(By.xpath("//*[@class='page-title']")).getText());
    }
    @Test
    public void removeFavoriteItem() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        driver.findElement(By.id("send2")).click();
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element = driver.findElement(By.xpath("//*[@class='level-top']"));
        actions.click(element).perform();
        element = driver.findElement(By.xpath("//*[@title='СИЛНО ВТАЛЕН КОСТЮМ В ЕФЕКТНО СИНЬО - Teodor.bg']"));
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        By addToFavorites = By.xpath("//*[@data-action='add-to-wishlist']");
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.elementToBeClickable(addToFavorites)).click();
        driver.findElement(By.xpath("//*[@class='header-wishlist clever-link']")).click();
        element = driver.findElement(By.xpath("//*[@class='product-image-photo']"));
        actions.moveToElement(element).perform();
        element = driver.findElement(By.xpath("//*[@class='btn-remove action delete']"));
        actions.click(element).perform();
        String actualText = driver.findElement(By.xpath("//*[@class='message info empty']")).getText();
        assertTrue(actualText.contains("Нямате продукти в списъка с любими"));
    }
    @Test
    public void favoritesShare() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        driver.findElement(By.id("send2")).click();
        element = driver.findElement(By.xpath("//*[@href='/obuvki']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/obuvki/chehli']")).click();
        element = driver.findElement(By.xpath("//*[@src='https://teodor.bg/media/catalog/product/cache/e3e69fb7c4c6812fd110353bffc282d2/1/4/14501_1.jpg']"));
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("option-label-size1-208-item-179"))).click();
        element = driver.findElement(By.xpath("//*[@class='action towishlist']"));
        actions.click(element).perform();
        element = driver.findElement(By.xpath("//*[@class='header-wishlist clever-link']"));
        actions.click(element).perform();
        element = driver.findElement(By.xpath("//*[@class='action share']"));
        actions.click(element).perform();
        element = driver.findElement(By.id("email_address"));
        actions.sendKeys(element, "hellopussycat@gmail.com").perform();
        element = driver.findElement(By.xpath("//*[@class='action submit primary']"));
        actions.click(element).perform();
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='message-success success message']")));
        String textFromMessage = driver.findElement(By.xpath("//*[@class='message-success success message']")).getText();
        assertTrue(textFromMessage.contains("Вашият Списък с желани продукти е бил споделен."));
    }
    @Test
    public void addEverythingToTheCartButton() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        driver.findElement(By.id("send2")).click();
        element = driver.findElement(By.xpath("//*[@href='/obuvki']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/obuvki/chehli']")).click();
        element = driver.findElement(By.xpath("//*[@src='https://teodor.bg/media/catalog/product/cache/e3e69fb7c4c6812fd110353bffc282d2/1/4/14501_1.jpg']"));
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        WebDriverWait wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("option-label-size1-208-item-179"))).click();
        element = driver.findElement(By.xpath("//*[@class='action towishlist']"));
        actions.click(element).perform();
        element = driver.findElement(By.xpath("//*[@class='header-wishlist clever-link']"));
        actions.click(element).perform();
        element = driver.findElement(By.xpath("//*[@class='action tocart']"));
        actions.click(element).perform();
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='message-success success message']")));
        String textFromSuccess = driver.findElement(By.xpath("//*[@class='message-success success message']")).getText();
        assertTrue(textFromSuccess.contains("ЖЪЛТИ ЧЕХЛИ ОТ НАБУК С МЕТАЛНО ЛОГО"));
    }
    @Test
    public void buletinSubscription() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/newsletter/manage/']")).click();
        driver.findElement(By.id("subscription")).click();
        driver.findElement(By.xpath("//*[@class='action save primary']")).click();
        String textFromSuccess = driver.findElement(By.xpath("//*[@class='base']")).getText();
        assertTrue(textFromSuccess.contains("МОЯТ ПРОФИЛ"));
    }
    @Test
    public void dataControlProfile() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/gdpr/customer/dashboard/']")).click();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/customer/account/edit/']")).click();
        Assert.assertTrue(driver.findElement(By.id("firstname")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("lastname")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("change-email")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("change-password")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("customer_invoice")).isDisplayed());
    }
    @Test
    public void dataControlAddress() throws IOException {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/gdpr/customer/dashboard/']")).click();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/customer/address/index/']")).click();
        String invoiceDefault = driver.findElement(By.xpath("//*[@class='box box-address-billing']")).getText();
        assertTrue(invoiceDefault.contains("По подразбиране адрес за фактуриране"));
        String addressDeiveryDefault = driver.findElement(By.xpath("//*[@class='box box-address-shipping']")).getText();
        assertTrue(addressDeiveryDefault.contains("Адрес за доставка по подразбиране"));
    }
    @Test
    public void agreementTerms()
    {
        driver.manage().window().maximize();
        driver.get("https://teodor.bg");
        By cookies_accept = By.xpath("//*[@class='v-button v-accept']");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@name='login[username]']")).sendKeys("qqqq16@gmail.com");
        driver.findElement(By.xpath("//*[@name='login[password]']")).sendKeys("qqqq16");
        driver.findElement(By.id("send2")).click();
        driver.findElement(By.xpath("//*[@class='clever-link']")).click();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/gdpr/customer/dashboard/']")).click();
        element = driver.findElement(By.xpath("//*[@href='https://teodor.bg/gdpr/customer/review/']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        String textPersonalData = driver.findElement(By.xpath("//*[@class='block-content']")).getText();
        assertTrue(textPersonalData.contains("№ 2016/679 на ЕП и на Съвета от 27.04.2016 г."));
        Assert.assertTrue(driver.findElement(By.id("consent_1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("consent_2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("consent_3")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='action save primary']")).isDisplayed());
    }
}