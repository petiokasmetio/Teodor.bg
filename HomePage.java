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
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class HomePage {
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
    public void deliveryBannerOfert() {
        String textInBanner = driver.findElement(By.xpath("//*[@class='header-top-message page-main']")).getText();
        assertTrue(textInBanner.contains("БЕЗПЛАТНА ДОСТАВКА ЗА ВСИЧКИ ПОРЪЧКИ НАД 99.99ЛВ"));
    }

    @Test
    public void summerSaleBanner() {
        String summerSaaleBanner = driver.findElement(By.xpath("//*[@class='widget block block-static-block']")).getText();
        assertTrue(summerSaaleBanner.contains("Summer Sale до -70% + Extra 20% при покупка на 3 или повече артикула"));
    }

    @Test
    public void h8sProducts() {
        driver.findElement(By.xpath("//*[@href='/h8s']")).click();
        String h8sClothes = driver.findElement(By.xpath("//*[@class='base']")).getText();
        assertTrue(h8sClothes.contains("H8S ДРЕХИ"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@src='https://teodor.bg/media/catalog/category/1.png']")).isDisplayed());
    }

    @Test
    public void h8sTShirts() {
        driver.findElement(By.xpath("//*[@href='/h8s']")).click();
        driver.findElement(By.xpath("//*[@class='filter-options-title']")).click();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/h8s/teniski-h8s']")).click();
        String tShirt = driver.findElement(By.xpath("//*[@class='products wrapper grid products-grid']")).getText();
        assertTrue("give me tShirt tags", tShirt.contains("ТЕНИСКА"));
    }

    @Test
    public void h8sSportSuits() {
        driver.findElement(By.xpath("//*[@href='/h8s']")).click();
        driver.findElement(By.xpath("//*[@class='filter-options-title']")).click();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/h8s/sportni-ekipi-h8s']")).click();
        String sportSuits = driver.findElement(By.xpath("//*[@class='products wrapper grid products-grid']")).getText();
        assertTrue("give me sport suits", sportSuits.contains("СПОРТЕН ЕКИП"));
    }

    @Test
    public void h8sShorts() {
        driver.findElement(By.xpath("//*[@href='/h8s']")).click();
        driver.findElement(By.xpath("//*[@class='filter-options-title']")).click();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/h8s/shorti']")).click();
        String shorts = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me shorts", shorts.contains("ШОРТИ"));
    }

    @Test
    public void h8sShoes() {
        driver.findElement(By.xpath("//*[@href='/h8s']")).click();
        driver.findElement(By.xpath("//*[@class='filter-options-title']")).click();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/h8s/obuvki']")).click();
        String shoes = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me shoes", shoes.contains("МАРАТОНКИ"));
    }

    @Test
    public void h8sPulovers() {
        driver.findElement(By.xpath("//*[@href='/h8s']")).click();
        driver.findElement(By.xpath("//*[@class='filter-options-title']")).click();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/h8s/puloveri-h8s']")).click();
        String shoes = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me pulovers", shoes.contains("ПУЛОВЕР"));
    }

    @Test
    public void promotions() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/namaleni']")).click();
        Assert.assertTrue(driver.findElement(By.id("old-price-320877")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("product-price-320877")).isDisplayed());
        String longSleeveShirt = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("First two asserts are for РИЗА С ДЪЛЪГ РЪКАВ ЕФЕКТНА ЯКА", longSleeveShirt.contains("РИЗА"));
    }

    @Test
    public void summerSale() {
        element = driver.findElement(By.xpath("//*[@class='has-sub']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/summer-sale-do-50-extra-20']")).click();
        Assert.assertTrue(driver.findElement(By.id("old-price-350100")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("product-price-350100")).isDisplayed());
        String blackPants = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("get 87% discounted pants", blackPants.contains("ЧЕРЕН СПОРТЕН ПАНТАЛОН С ЛАСТИК"));
    }

    @Test
    public void newClothes() {
        driver.findElement(By.xpath("//*[@href='/novi']")).click();
        String newModels = driver.findElement(By.id("maincontent")).getText();
        assertTrue("give me title of the page НОВИ МОДЕЛИ", newModels.contains("НОВИ МОДЕЛИ"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='product-label new-label']")).isDisplayed());
    }

    @Test
    public void suits() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/kostyumi']")).click();
        String suits = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me every КОСТЮМ", suits.contains("КОСТЮМ"));
    }

    @Test
    public void elecs() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/eletsi']")).click();
        String elecs = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all ELECS", elecs.contains("ЕЛЕК"));
    }

    @Test
    public void pants() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/pantaloni']")).click();
        String pants = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all pants", pants.contains("ПАНТАЛОН"));
    }

    @Test
    public void tShirts() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/teniski']")).click();
        String tShirts = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all T-Shirts", tShirts.contains("ТЕНИСКА"));
    }

    @Test
    public void tShirtsWithCollar() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/teniski']")).click();
        driver.findElement(By.xpath("//*[@href='/teniski/s-yaka']")).click();
        String tShirtWithCollar = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all T-Shirts with yaka", tShirtWithCollar.contains("ЯКА"));
    }

    @Test
    public void tShirtsWithNeckLine() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/teniski']")).click();
        driver.findElement(By.xpath("//*[@href='/teniski/s-dekolte']")).click();
        String tShirtWithNeckLine = driver.findElement(By.id("maincontent")).getText();
        assertTrue("give me all T-Shirts with collar", tShirtWithNeckLine.contains("ТЕНИСКИ С ДЕКОЛТЕ"));
    }

    @Test
    public void sportSuits() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/sportni-ekipi']")).click();
        String sportSuit = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all sport suits", sportSuit.contains("СПОРТЕН ЕКИП"));
        String sportStuff = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of sport suits", sportStuff.contains("МЪЖКИ СПОРТНИ ЕКИПИ"));
    }

    @Test
    public void vests() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/zhiletki']")).click();
        String vests = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all vests", vests.contains("ЖИЛЕТКА"));
        String vestsTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of vests", vestsTitle.contains("МЪЖКИ ЖИЛЕТКИ"));
    }

    @Test
    public void coats() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/palta']")).click();
        String coats = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all coats", coats.contains("ПАЛТО"));
        String coatsTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of coats", coatsTitle.contains("ПАЛТА"));
    }

    @Test
    public void h8sDuplicateLink() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/h8s']")).click();
        String h8sTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of coats", h8sTitle.contains("H8S ДРЕХИ"));
    }

    @Test
    public void summerSaleDuplicateLink() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/summer-sale-do-50-extra-20']")).click();
        String summerSaleTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of summer sale", summerSaleTitle.contains("SUMMER SALE ДО -70% + EXTRA 20%"));
    }

    @Test
    public void baseTshirts() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/bazovi-teniski']")).click();
        String baseTshirts = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all base t-shirts", baseTshirts.contains("ТЕНИСКА"));
        String baseTshirtsTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of base t-shirts", baseTshirtsTitle.contains("БАЗОВИ ТЕНИСКИ"));
    }

    @Test
    public void jacketsSports() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/saka']")).click();
        driver.findElement(By.xpath("//*[@href='/saka/sportni']")).click();
        String sportJacketsTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of sport jackets", sportJacketsTitle.contains("СПОРТНО-ЕЛЕГАНТНИ САКА ЗА МЪЖЕ"));
    }

    @Test
    public void jacketsCeremonial() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/saka']")).click();
        driver.findElement(By.xpath("//*[@href='/saka/vtaleni180']")).click();
        String sportJacketsTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of ceremonial jackets", sportJacketsTitle.contains("ВТАЛЕНИ САКА ЗА МЪЖЕ"));
    }

    @Test
    public void shirts() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/rizi']")).click();
        String shirts = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all shirts", shirts.contains("РИЗА"));
        String shirtsTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of shirts", shirtsTitle.contains("РИЗИ ЗА МЪЖЕ"));
    }

    @Test
    public void officialShirts() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/rizi']")).click();
        driver.findElement(By.xpath("//*[@href='/rizi/ofitsialni-rizi']")).click();
        String officialShirts = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of official shirts", officialShirts.contains("МЪЖКИ ОФИЦИАЛНИ РИЗИ"));
    }

    @Test
    public void everydayShirts() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/rizi']")).click();
        driver.findElement(By.xpath("//*[@href='/rizi/sportni-rizi']")).click();
        String sportShirts = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of official shirts", sportShirts.contains("СПОРТНО-ЕЛЕГАНТНИ РИЗИ ЗА МЪЖЕ"));
    }

    @Test
    public void shortSleeveShirts() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/rizi']")).click();
        driver.findElement(By.xpath("//*[@href='/rizi/rizi-s-kas-rakav']")).click();
        String shortSleeveShitrs = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of short sleeves shirts", shortSleeveShitrs.contains("РИЗИ С КЪС РЪКАВ"));
    }

    @Test
    public void Jeens() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/danki']")).click();
        String jeens = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all Jeens", jeens.contains("ДЪНКИ"));
        String jeensTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of Jeens", jeensTitle.contains("ДЪНКИ ЗА МЪЖЕ"));
    }

    @Test
    public void manTop() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/bluzi']")).click();
        String manTop = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all man top", manTop.contains("БЛУЗА"));
        String manTopTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of man top", manTopTitle.contains("БЛУЗИ С ДЪЛЪГ РЪКАВ"));
    }

    @Test
    public void pulovers() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/puloveri']")).click();
        String pulovers = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all man pulovers", pulovers.contains("ПУЛОВЕР"));
        String puloversTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of man pulovers", puloversTitle.contains("МЪЖКИ ПУЛОВЕРИ"));
    }

    @Test
    public void topJackets() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/yaketa']")).click();
        String topJackets = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all man top jackets", topJackets.contains("ЯКЕ"));
        String topJacketsTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of man top jackets", topJacketsTitle.contains("ЯКЕТА"));
    }

    @Test
    public void shortBermudas() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/bermudi']")).click();
        String bermuda = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all man top jackets", bermuda.contains("БЕРМУДИ"));
        String bermudaTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of man top jackets", bermudaTitle.contains("МЪЖКИ БЕРМУДИ"));
    }

    @Test
    public void swimShorts() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/banksi']")).click();
        String swimShorts = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all man swim shorts", swimShorts.contains("БАНСКИ"));
        String switmShortsTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of man swim shorts", switmShortsTitle.contains("МЪЖКИ БАНСКИ"));
    }

    @Test
    public void lenClothes() {
        element = driver.findElement(By.id("om"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='https://teodor.bg/len']")).click();
        String topClothes = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all man slenClothes", topClothes.contains("ЛЕН"));
        String botClothes = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all man slenClothes", botClothes.contains("ЛЕНЕНА"));
        String lenTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of man slenClothes", lenTitle.contains("ЛЕНЕНИ ДРЕХИ"));
    }

    @Test
    public void manShoes() {
        element = driver.findElement(By.xpath("//*[@href='/obuvki']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click(element).perform();
        String shoes = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all man shoes", shoes.contains("ОБУВКИ"));
        String mocasina = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all man mocasina", mocasina.contains("МОКАСИНИ"));
        String shoeTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of man shoes", shoeTitle.contains("МЪЖКИ ОБУВКИ"));
    }

    @Test
    public void officialManShoes() {
        element = driver.findElement(By.xpath("//*[@href='/obuvki']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/obuvki/ofitsialni-obuvki']")).click();
        String officialManShoes = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all officialManShoes", officialManShoes.contains("ОФИЦИАЛНИ ОБУВКИ"));
        String officialManShoesTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of officialManShoes", officialManShoesTitle.contains("ОФИЦИАЛНИ МЪЖКИ ОБУВКИ"));
    }

    @Test
    public void sportElegantShoes() {
        element = driver.findElement(By.xpath("//*[@href='/obuvki']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/obuvki/sportni-obuvki']")).click();
        String sportni = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all dayly shoes", sportni.contains("СПОРТНИ ОБУВКИ"));
        String sportni2 = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all dayly shoes", sportni2.contains("МАРАТОНКИ"));
        String sportniTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of dayly shoes", sportniTitle.contains("МЪЖКИ ЕЖЕДНЕВНИ ОБУВКИ"));
    }

    @Test
    public void mokassina() {
        element = driver.findElement(By.xpath("//*[@href='/obuvki']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/obuvki/mokasini']")).click();
        String mokassinaShoe = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all mokassina", mokassinaShoe.contains("МОКАСИНИ"));
        String mokassinaShoeTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of mokassina", mokassinaShoeTitle.contains("МОКАСИНИ ЗА МЪЖЕ"));
    }

    @Test
    public void boots() {
        element = driver.findElement(By.xpath("//*[@href='/obuvki']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/obuvki/boti']")).click();
        String boots = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all boots", boots.contains("БОТИ"));
        String bootsTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of boots", bootsTitle.contains("БОТИ"));
    }

    @Test
    public void slippers() {
        element = driver.findElement(By.xpath("//*[@href='/obuvki']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/obuvki/chehli']")).click();
        String slippers = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all slippers", slippers.contains("ЧЕХЛИ"));
        String slippersTitlte = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of slippers", slippersTitlte.contains("МЪЖКИ КОЖЕНИ ЧЕХЛИ"));
    }

    @Test
    public void tie() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/vratovrazki']")).click();
        String tie = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all ties", tie.contains("ВРАТОВРЪЗКА"));
        String tieTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of ties", tieTitle.contains("ВРАТОВРЪЗКИ"));
    }

    @Test
    public void tieNeedle() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/igli-za-vratovrazki']")).click();
        String tieNeedle = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all tieNeedle", tieNeedle.contains("ИГЛА ЗА ВРАТОВРЪЗКА"));
        String tieNeedleT = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of tieNeedle", tieNeedleT.contains("ИГЛИ ЗА ВРАТОВРЪЗКИ"));
    }

    @Test
    public void bowTie() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/papionki']")).click();
        String bowTie = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all bowTie", bowTie.contains("ПАПИЙОНКА"));
        String bowTieT = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of bowTie", bowTieT.contains("ПАПИЙОНКИ"));
    }

    @Test
    public void belts() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/kolani']")).click();
        String belts = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all belts", belts.contains("КОЛАН"));
        String beltsT = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of belts", beltsT.contains("МЪЖКИ КОЛАНИ"));
    }

    @Test
    public void braces() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/tiranti']")).click();
        String braces = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all  braces", braces.contains("ТИРАНТИ"));
        String bracesTitle = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of rbaces", bracesTitle.contains("ТИРАНТИ"));
    }

    @Test
    public void bagsAndBackpacks() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/chanti']")).click();
        String bagsAndBackpacks = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all bags and backpacks", bagsAndBackpacks.contains("ЧАНТА"));
        String suitCase = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all bags and cases", suitCase.contains("КАЛЪФ"));
        String bagsAndBackpacksT = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of bags and backpacks", bagsAndBackpacksT.contains("ЧАНТИ И РАНИЦИ"));
    }

    @Test
    public void bagsAndWallets() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/chanti-i-portfeyli']")).click();
        String bags = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all bags", bags.contains("ВИЗИТНИК"));
        String wallets = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all wallets", wallets.contains("ПОРТФЕЙЛ"));
        String bagsNwalletsT = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of bags n wallets", bagsNwalletsT.contains("ЧАНТИ И ПОРТФЕЙЛИ"));
    }

    @Test
    public void socks() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/chorapi']")).click();
        String socks = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all socks", socks.contains("ЧОРАПИ"));
        String socksT = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of socks", socksT.contains("ЧОРАПИ"));
    }

    @Test
    public void rakaveli() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/rakaveli']")).click();
        String hands = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all hands", hands.contains("БУТОНЕЛИ"));
        String handsT = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of handsT", handsT.contains("РЪКАВЕЛИ"));
    }

    @Test
    public void suitTowels() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/karpichki-za-sako']")).click();
        String suitTowels = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all towels", suitTowels.contains("КЪРПА"));
        String suitTowelsT = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of towels", suitTowelsT.contains("МЪЖКИ КЪРПИЧКИ ЗА САКО"));
    }

    @Test
    public void scarf() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/shalove']")).click();
        String scarf = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all scarf", scarf.contains("ШАЛ"));
        String scarfT = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of scarf", scarfT.contains("ШАЛОВЕ"));
    }

    @Test
    public void bracers() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/grivni']")).click();
        String bracers = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all bracers", bracers.contains("ГРИВНА"));
        String bracersT = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of bracers", bracersT.contains("МЪЖКИ ГРИВНИ КОЖЕНИ"));
    }

    @Test
    public void giftBox() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/podar-chni-kutii']")).click();
        String giftBox = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all gift box", giftBox.contains("ПОДАРЪЧНА КУТИЯ"));
        String giftBoxT = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of gift box", giftBoxT.contains("ПОДАРЪЧНИ КУТИИ"));
    }

    @Test
    public void hats() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/shapki']")).click();
        String hats = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all hats", hats.contains("ШАПКА"));
        String hatsT = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of hats", hatsT.contains("ШАПКИ"));
    }

    @Test
    public void hands() {
        element = driver.findElement(By.xpath("//*[@href='/aksesoari']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        driver.findElement(By.xpath("//*[@href='/aksesoari/r-kavici']")).click();
        String hands = driver.findElement(By.id("amasty-shopby-product-list")).getText();
        assertTrue("give me all hands", hands.contains("Не можем да намерим продукти, отговарящи на селекцията."));
        String handsT = driver.findElement(By.id("page-title-heading")).getText();
        assertTrue("give me title of hands", handsT.contains("РЪКАВИЦИ"));
    }

    @Test
    public void vouchers() {
        element = driver.findElement(By.xpath("//*[@href='/vaucher-za-podarak']"));
        Actions actions = new Actions(driver);
        actions.click(element).perform();
        String vauchers = driver.findElement(By.id("maincontent")).getText();
        assertTrue("give me all vouchers", vauchers.contains("ВАУЧЕРИ ЗА ПОДАРЪК ЗА МЪЖКИ ДРЕХИ"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='https://teodor.bg/vaucher-1']")).isDisplayed());
    }

    @Test
    public void vouchersSend() {
        element = driver.findElement(By.xpath("//*[@href='/vaucher-za-podarak']"));
        Actions actions = new Actions(driver);
        actions.click(element).perform();
        element = driver.findElement(By.xpath("//*[@href='https://teodor.bg/vaucher-1']"));
        actions.click(element).perform();
        Assert.assertTrue(driver.findElement(By.id("select_2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("options_3_text")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("product-addtocart-button")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='javascript:;']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='action towishlist']")).isDisplayed());
    }
    @Test
    public void shops() {
        element = driver.findElement(By.xpath("//*[@href='/magazini']"));
        Actions actions = new Actions(driver);
        actions.click(element).perform();
        String shopsTitle = driver.findElement(By.id("maincontent")).getText();
        assertTrue("give me title shops", shopsTitle.contains("TEODOR МАГАЗИНИ"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='/magazini-sofiya']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='map-container']")).isDisplayed());
    }
    @Test
    public void loyalClients() {
        element = driver.findElement(By.xpath("//*[@href='/korporativni-klienti']"));
        Actions actions = new Actions(driver);
        actions.click(element).perform();
        String corporativeClients = driver.findElement(By.id("maincontent")).getText();
        assertTrue("give me title loyal clients", corporativeClients.contains("КОРПОРАТИВНИ КЛИЕНТИ"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@src='https://teodor.bg/media/Next_Gen_orange-01.jpg']")).isDisplayed());
    }
    @Test
    public void loyalClientsCards() {
        element = driver.findElement(By.xpath("//*[@href='/korporativni-klienti']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        element = driver.findElement(By.xpath("//*[@href='/karti-za-loyalnost']"));
        actions.click(element).perform();
        String corporativeClients = driver.findElement(By.id("maincontent")).getText();
        assertTrue("give me title cards loyal", corporativeClients.contains("КАРТИ ЗА ЛОЯЛНИ КЛИЕНТИ"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='text-page']")).isDisplayed());
    }
    @Test
    public void blog() {
        element = driver.findElement(By.xpath("//*[@href='/novini/category/novini']"));
        Actions actions = new Actions(driver);
        actions.click(element).perform();
        String corporativeClients = driver.findElement(By.id("maincontent")).getText();
        assertTrue("give me title news", corporativeClients.contains("НОВИНИ И СТАТИИ"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='post-image']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='post-info-wraper']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("mpblog-search-box")).isDisplayed());
    }
    @Test
    public void video() {
        element = driver.findElement(By.xpath("//*[@href='/novini/category/video-novini']"));
        Actions actions = new Actions(driver);
        actions.click(element).perform();
        String videoTitle = driver.findElement(By.id("maincontent")).getText();
        assertTrue("give me title video news", videoTitle.contains("ВИДЕА ЗА МЪЖКА МОДА"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@href='https://teodor.bg/novini/prolet-ljato-2021']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@src='https://teodor.bg/media/mageplaza/blog/post/resize/400x/u/n/untitled-4_1.jpg']")).isDisplayed());
    }
    @Test
    public void contscts() {
        element = driver.findElement(By.xpath("//*[@href='/contact']"));
        Actions actions = new Actions(driver);
        actions.click(element).perform();
        String contactTitle = driver.findElement(By.id("maincontent")).getText();
        assertTrue("give me title contacts", contactTitle.contains("КОНТАКТИ"));
        Assert.assertTrue(driver.findElement(By.id("name")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("telephone")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("subject")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("comment")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='primary']")).isDisplayed());
    }
}

