package hw3;


/**
 * Java 3. Home work 2.
 *
 * @author Azarova Iuliia
 * @version 16.05.2022
 */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-gpu");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://www.hermitagemuseum.org?lng=ru");
        driver.findElement(By.xpath("//a[@aria-label=\"Перейти к разделу Посетителям\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'500 рублей')]")));
        driver.findElement(By.xpath("//a[contains(text(),'500 рублей')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id=\"events\"]//button)[1]")));
        driver.findElement(By.xpath("(//*[@id=\"events\"]//button)[1]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-container\"]/div[2]/div/main/div/div/div/div/div/div[3]/div/div[1]")));
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div[2]/div/main/div/div/div/div/div/div[3]/div/div[1]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"fa fa-plus\"]")));
        driver.findElement(By.xpath("//i[@class=\"fa fa-plus\"]")).click();


        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"fio\"]")));
        driver.findElement(By.xpath("//input[@name=\"fio\"]")).sendKeys("Фамилия Имя Отчество");
        driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys("+79999999999");
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("testMail@mail.ru");
        driver.findElement(By.xpath("//input[@name=\"re_email\"]")).sendKeys("testMail@mail.ru");

        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]"));
        ((JavascriptExecutor)driver).executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", checkbox1);
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]"));
        ((JavascriptExecutor)driver).executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", checkbox2);
        driver.findElement(By.xpath("//*[@id=\"form-order\"]//button[@type=\"submit\"]")).click();

        Thread.sleep(5000);

        WebElement paymentAcceptButton = driver.findElement(By.xpath("//*[@id=\"page-container\"]//button[@type=\"submit\"]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", paymentAcceptButton);

        Thread.sleep(50000);
        driver.quit();
    }
}
