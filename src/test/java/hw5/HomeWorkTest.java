package hw5;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;




public class HomeWorkTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
        driver = new ChromeDriver(chromeOptions);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }


    @Test
    void downloadEfrosManual() throws InterruptedException {

        driver.get("https://www.gaz-is.ru/");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-menu']//a[text()='Продукты']")));
        driver.findElement(By.xpath("//div[@class='main-menu']//a[text()='Продукты']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='main-menu main-menu--active']//a[text()='Efros Config Inspector']")));
        driver.findElement(By.xpath("//div[@class='main-menu main-menu--active']//a[text()='Efros Config Inspector']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Материалы']")));
        driver.findElement(By.xpath("//a[@title='Материалы']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Руководство администратора Efros CI 4 (4.5)']")));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//a[text()='Руководство администратора Efros CI 4 (4.5)']"));
        jse.executeScript("arguments[0].scrollIntoView(true)", element);
        element.click();

        Thread.sleep(5000);
    }

    @Test
    void checkTestPass() throws InterruptedException {

        driver.get("https://kudago.com/");
        String xpathToClick = "//a[@class=\"cities-menu-item-link cities-menu-item-link-online\"]";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathToClick)));
        driver.findElement(By.xpath(xpathToClick)).click();

        xpathToClick = "//a[@title=\"Тест для влюблённых в Питер: что вы знаете о городской архитектуре?\"]";
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(xpathToClick));
        jse.executeScript("arguments[0].scrollIntoView(true)", element);
        element.click();

        xpathToClick = "//button[contains(text(),'Пройти тест')]";
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathToClick)));
        driver.findElement(By.xpath(xpathToClick)).click();

        String xpathToClickNext = "//button[@class=\"button quiz-nextButton\"]";
        String xpathToClickAnswer = "//div[@class=\"quiz-answers \"]/div";
        for (int i = 0; i < 12; i++) {
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathToClickAnswer)));
            driver.findElement(By.xpath(xpathToClickAnswer)).click();
            webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathToClickNext)));
            driver.findElement(By.xpath(xpathToClickNext)).click();
        }

        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class=\"quiz-result\"]")).isDisplayed(), true);
        Thread.sleep(5000);
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
