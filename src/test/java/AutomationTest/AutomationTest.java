package AutomationTest;

import hw6.EfrosCIPage;
import hw6.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutomationTest {
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

        new MainPage(driver)
                .clickEfrosCIButton()
                .downloadManualAdmin();

        Thread.sleep(5000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
