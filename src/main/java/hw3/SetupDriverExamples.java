package hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class SetupDriverExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        //chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("user-agent=Googlebot/2.1 (+http://www.googlebot.com/bot.html)");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.google.com/");

        //создание новой вкладки
        /*
        driver.switchTo().newWindow(WindowType.TAB);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.lenta.com/");
        Thread.sleep(500);
        driver.close();

        driver.switchTo().window(tabs.get(0));
        ((JavascriptExecutor)driver).executeScript("window.open(\"http://ya.ru\")");
        */

        //driver.manage().window().setSize(new Dimension(300, 700));
        driver.manage().window().maximize();


        Thread.sleep(5000);
        driver.quit();
    }
}
