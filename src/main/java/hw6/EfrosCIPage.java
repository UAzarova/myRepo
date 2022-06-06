package hw6;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EfrosCIPage extends BasePage{
    HeaderBlock headerBlock;

    public EfrosCIPage (WebDriver driver) {
        super (driver);
        headerBlock = new HeaderBlock(driver);
    }

    @FindBy(xpath = "//a[@title='Материалы']")
    private WebElement selectDocumentation;

    @FindBy(xpath = "//a[text()='Руководство администратора Efros CI 4 (4.5)']")
    private WebElement manualAdmin;


    public void clickDocumentation() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectDocumentation));
        selectDocumentation.click();
    }

    public void downloadManualAdmin() {
        clickDocumentation();

        webDriverWait.until(ExpectedConditions.visibilityOf(manualAdmin));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", manualAdmin);
        manualAdmin.click();
    }
}