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

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class ProductFilters {

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
    public void h8sFiltersContent() {
        driver.findElement(By.xpath("//*[@href='/h8s']")).click();
        String contentAsideMenu = driver.findElement(By.xpath("//*[@class='sidebar sidebar-main']")).getText();
        assertTrue("Give me categoryes", contentAsideMenu.contains("КАТЕГОРИИ"));
        assertTrue("Give me color", contentAsideMenu.contains("ЦВЯТ"));
        assertTrue("Give me cut", contentAsideMenu.contains("КРОЙКА"));
        assertTrue("Give me shoe size", contentAsideMenu.contains("РАЗМЕР - ОБУВКИ"));
        assertTrue("Give me shirt size", contentAsideMenu.contains("РАЗМЕР - РИЗИ, ТЕНИСКИ, БЛУЗИ, СПОРТНИ ЕКИПИ, ПУЛОВЕРИ"));
        assertTrue("Give me tissue", contentAsideMenu.contains("ТЪКАН"));
        assertTrue("Give me price", contentAsideMenu.contains("ЦЕНА"));
    }
    @Test
    public void h8sFiltecByCategoryTeniski() {
        driver.findElement(By.xpath("//*[@href='/h8s']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='https://teodor.bg/h8s/teniski-h8s']")))).click();
        String yellowTshirt = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me yellow tshirt description", yellowTshirt.contains("ЖЪЛТА БИЕ ТЕНИСКА С БРОДЕРИЯ И ЛОГО"));
    }
    @Test
    public void h8sFiltecByCategorySportSuit() {
        driver.findElement(By.xpath("//*[@href='/h8s']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='https://teodor.bg/h8s/sportni-ekipi-h8s']")))).click();
        String sportSuit = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me sport suit description", sportSuit.contains("СПОРТЕН ЕКИП В БОРДО"));
    }
    @Test
    public void h8sFiltecByCategoryShorts() {
        driver.findElement(By.xpath("//*[@href='/h8s']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='https://teodor.bg/h8s/shorti']")))).click();
        String shorts = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me shorts description", shorts.contains("СИВИ МЕЛАНЖИРАНИ ШОРТИ С БРОДЕРИЯ"));
    }
    @Test
    public void h8sFiltecByCategoryShoes() {
        driver.findElement(By.xpath("//*[@href='/h8s']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='https://teodor.bg/h8s/obuvki']")))).click();
        String shoes = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me shoes description", shoes.contains("МАРАТОНКИ В ТЪМНО СИНЬО И БОРДО ОТ ВЕЛУР"));
    }
    @Test
    public void h8sFiltecByCategoryPulovers() {
        driver.findElement(By.xpath("//*[@href='/h8s']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='https://teodor.bg/h8s/puloveri-h8s']")))).click();
        String pulovers = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me pulover description", pulovers.contains("БЯЛ ПАМУЧЕН ПУЛОВЕР ШПИЦ ДЕКОЛТЕ"));
    }
    @Test
    public void filterReducedPriceProducts() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        String contentAsideMenu = driver.findElement(By.xpath("//*[@class='sidebar sidebar-main']")).getText();
        assertTrue("Give me categoryes", contentAsideMenu.contains("КАТЕГОРИИ"));
        assertTrue("Give me color", contentAsideMenu.contains("ЦВЯТ"));
        assertTrue("Give me cut", contentAsideMenu.contains("КРОЙКА"));
        assertTrue("Give me shoe size", contentAsideMenu.contains("РАЗМЕР - ОБУВКИ"));
        assertTrue("Give me shoe size", contentAsideMenu.contains("РАЗМЕР - ЧИНО ПАНТАЛОНИ, САКА, КОСТЮМИ, ЯКЕТА, ПАЛТА"));
        assertTrue("Give me shoe size", contentAsideMenu.contains("РАЗМЕР - ДЪНКИ И 5 ДЖОБА"));
        assertTrue("Give me shirt size", contentAsideMenu.contains("РАЗМЕР - РИЗИ, ТЕНИСКИ, БЛУЗИ, СПОРТНИ ЕКИПИ, ПУЛОВЕРИ"));
        assertTrue("Give me tissue", contentAsideMenu.contains("ТЪКАН"));
        assertTrue("Give me price", contentAsideMenu.contains("ЦЕНА"));
    }
    @Test
    public void sortingFilterByPercentDiscount() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        element = driver.findElement(By.id("sorter"));
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        Select dropdown = new Select(driver.findElement(By.id("sorter")));
        dropdown.selectByValue("best_discountd");
        Select select = new Select(driver.findElement(By.id("sorter")));
        String optionFromDropdownMenu = select.getFirstSelectedOption().getText();
        Assert.assertEquals("% Отстъпка", optionFromDropdownMenu);
    }
    @Test
    public void sortingFilterByRecentlyAdded() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        element = driver.findElement(By.id("sorter"));
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        Select dropdownMenu = new Select(driver.findElement(By.id("sorter")));
        dropdownMenu.selectByValue("recently_addedd");
        Select select = new Select(driver.findElement(By.id("sorter")));
        String optionFromDropdownMenu = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Най-нови", optionFromDropdownMenu);
    }
    @Test
    public void sortingFilterByNumberOFAssessments() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        element = driver.findElement(By.id("sorter"));
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        Select dropdownMenu = new Select(driver.findElement(By.id("sorter")));
        dropdownMenu.selectByValue("most_reviewedd");
        Select select = new Select(driver.findElement(By.id("sorter")));
        String optionFromDropdownMenu = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Брой оценки", optionFromDropdownMenu);
    }
    @Test
    public void sortingFilterByBestSellers() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        element = driver.findElement(By.id("sorter"));
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        Select dropdownMenu = new Select(driver.findElement(By.id("sorter")));
        dropdownMenu.selectByValue("best_sellersd");
        Select select = new Select(driver.findElement(By.id("sorter")));
        String optionFromDropdownMenu = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Bestsellers", optionFromDropdownMenu);
    }
    @Test
    public void sortingFilterByDescendingPrice() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        element = driver.findElement(By.id("sorter"));
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        Select dropdownMenu = new Select(driver.findElement(By.id("sorter")));
        dropdownMenu.selectByValue("priced");
        Select select = new Select(driver.findElement(By.id("sorter")));
        String optionFromDropdownMenu = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Цена (Низходящ ред)", optionFromDropdownMenu);
    }
    @Test
    public void sortingFilterByAscendingPrice() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        element = driver.findElement(By.id("sorter"));
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        Select dropdownMenu = new Select(driver.findElement(By.id("sorter")));
        dropdownMenu.selectByValue("pricea");
        Select select = new Select(driver.findElement(By.id("sorter")));
        String optionFromDropdownMenu = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Цена (Възходящ ред)", optionFromDropdownMenu);
    }
    @Test
    public void sortingFilterByDescendingName() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        element = driver.findElement(By.id("sorter"));
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        Select dropdownMenu = new Select(driver.findElement(By.id("sorter")));
        dropdownMenu.selectByValue("named");
        Select select = new Select(driver.findElement(By.id("sorter")));
        String optionFromDropdownMenu = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Име (Низходящ ред)", optionFromDropdownMenu);
    }
    @Test
    public void sortingFilterByAscendingName() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        element = driver.findElement(By.id("sorter"));
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        Select dropdownMenu = new Select(driver.findElement(By.id("sorter")));
        dropdownMenu.selectByValue("namea");
        Select select = new Select(driver.findElement(By.id("sorter")));
        String optionFromDropdownMenu = select.getFirstSelectedOption().getText();
        Assert.assertEquals("Име (Възходящ ред)", optionFromDropdownMenu);
    }
    @Test
    public void filterCategoryByShoes() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='https://teodor.bg/namaleni/obuvki']")))).click();
        String assertShoesAppear = driver.findElement(By.xpath("//*[@class='products list items product-items']")).getText();
        assertTrue("Give me shoes mokasina", assertShoesAppear.contains("МОКАСИНИ"));
        assertTrue("Give me shoes obuvki", assertShoesAppear.contains("ОБУВКИ"));
        assertTrue("Give me shoes kecove", assertShoesAppear.contains("КЕЦОВЕ"));
    }
    @Test
    public void filterCategoryByColor() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='https://teodor.bg/namaleni/color-zh_lti']")))).click();
        element = driver.findElement(By.xpath("//*[@class='products list items product-items']"));
        actions.moveToElement(element).perform();
        String assertShoesAppear = driver.findElement(By.xpath("//*[@class='products list items product-items']")).getText();
        assertTrue("Give me yellow slippers", assertShoesAppear.contains("ЖЪЛТИ ЧЕХЛИ"));
        assertTrue("Give me bermuda yellow", assertShoesAppear.contains("ТЪМНО ЖЪЛТИ БЕРМУДИ"));
        assertTrue("Give me yellow t shirt", assertShoesAppear.contains("ЖЪЛТА ТЕНИСКА"));
    }
    @Test
    public void filterCategoryByCut() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='https://teodor.bg/namaleni/cutting-regular_fit']")))).click();
        element = driver.findElement(By.xpath("//*[@class='products list items product-items']"));
        actions.moveToElement(element).perform();
        String assertShoesAppear = driver.findElement(By.xpath("//*[@class='products list items product-items']")).getText();
        assertTrue("Give me regular fit suit", assertShoesAppear.contains("ЕЛЕГАНТЕН КАРИРАН КОСТЮМ В СИВО"));
        assertTrue("Give me bermuda pants", assertShoesAppear.contains("БЕЖОВИ БЕРМУДИ НА ТОЧКИ"));
        assertTrue("Give me yellow shirt", assertShoesAppear.contains("БЯЛА РИЗА В РЕЛЕФНО РАЙЕ"));
    }
    @Test
    public void filterCategoryByShoeSize() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='https://teodor.bg/namaleni/size1-42_1']")))).click();
        element = driver.findElement(By.xpath("//*[@class='item product product-item']"));
        actions.moveToElement(element).perform();
        String numberFourTwo = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me number", numberFourTwo.contains("42"));
    }
    @Test
    public void filterCategoryByPantsClothesNumber() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='https://teodor.bg/namaleni/size2-50']")))).click();
        element = driver.findElement(By.xpath("//*[@class='item product product-item']"));
        actions.moveToElement(element).perform();
        String numberFourTwo = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me number 50", numberFourTwo.contains("50"));
    }
    @Test
    public void filterCategoryByJeensNumbers() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@href='https://teodor.bg/namaleni/size3-30']")))).click();
        element = driver.findElement(By.xpath("//*[@class='item product product-item']"));
        actions.moveToElement(element).perform();
        String numberFourTwo = driver.findElement(By.xpath("//*[@class='product-item-info']")).getText();
        assertTrue("give me number 30", numberFourTwo.contains("30"));
    }
}