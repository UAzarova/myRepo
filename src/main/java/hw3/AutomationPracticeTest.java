package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AutomationPracticeTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("http://automationpractice.com/index.php?id_category=3&controller=category");
        driver.manage().window().maximize();

        //finding element
        //variant 1
        //WebElement casualStyleCheckBox = driver.findElement(By.xpath("//*[@id=\"ul_layered_id_feature_6\"]/li[1]/label"));
        //casualStyleCheckBox.click();

        //variant 2
        driver.findElement(By.xpath("//*[@id=\"ul_layered_id_feature_6\"]/li[1]/label")).click();

        //wait for loading element
        //variant 1
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //veriant 2
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Cancel']")));

        //variant 3 (please not use when element is appeared and not visible first)
        //webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[@title='Cancel']"))));

        driver.findElement(By.xpath("//a[@title='Cancel']")).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
