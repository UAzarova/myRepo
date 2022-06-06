package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderBlock extends BasePage {
    public HeaderBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='main-menu']//a[text()='О компании']")
    private WebElement aboutCompanyButton;

    @FindBy(xpath = "//div[@class='main-menu']//a[text()='Продукты']")
    private WebElement productsButton;

    @FindBy(xpath = "//div[@class='main-menu']//a[text()='Решения и услуги']\n")
    private WebElement solutionsAndServicesButton;

    @FindBy(xpath = "//div[@class='main-menu']//a[text()='Поддержка']")
    private WebElement supportButton;

    @FindBy(xpath = "//div/a[@href=\"mailto:support@gaz-is.ru\"]")
    private WebElement mailToSupportButton;

    @FindBy(xpath = "//div/a[@href=\"mailto:resp@gaz-is.ru\"]")
    private WebElement mailToCentralOfficeButton;

    public void clickProductButton () {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(productsButton));
        productsButton.click();
    }
}
