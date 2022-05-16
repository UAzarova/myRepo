package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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


        driver.get("https://www.hermitagemuseum.org?lng=ru");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[@aria-label=\"Перейти к разделу Посетителям\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'500 рублей')]")));
        driver.findElement(By.xpath("//a[contains(text(),'500 рублей')]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[2]/div/div[1]/div/ul/li/div/div[2]/a/button")));
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[2]/div/div[1]/div/ul/li/div/div[2]/a/button")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"page-container\"]/div[2]/div/main/div/div/div/div/div/div[3]/div/div[1]")));
        driver.findElement(By.xpath("//*[@id=\"page-container\"]/div[2]/div/main/div/div/div/div/div/div[3]/div/div[1]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class=\"fa fa-plus\"]")));
        driver.findElement(By.xpath("//i[@class=\"fa fa-plus\"]")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"fio\"]")));
        driver.findElement(By.xpath("//input[@name=\"fio\"]")).sendKeys("Фамилия Имя Отчество");
        driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys("+79999999999");
        driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys("mail@mail.ru");
        driver.findElement(By.xpath("//input[@name=\"re_email\"]")).sendKeys("mail@mail.ru");
        driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]")).click();
        driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]")).click();
        driver.findElement(By.xpath("submit")).click();










/*
        driver.findElement(By.id("loginform-password")).sendKeys("123456");

        //captcha
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@title=\"reCAPTCHA\"]")));
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title=\"reCAPTCHA\"]")));
        driver.findElement(By.xpath("//div[@class=\"recaptcha-checkbox-border\"]")).click();
        driver.switchTo().parentFrame();

        driver.findElement(By.id("login_btn")).click();
*/





        Thread.sleep(50000);
        driver.quit();
    }
}
