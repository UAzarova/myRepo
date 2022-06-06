package hw6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {
    HeaderBlock headerBlock;

    public MainPage (WebDriver driver) {
        super (driver);
        headerBlock = new HeaderBlock(driver);
    }

    @FindBy(xpath = "//div[@class='main-menu main-menu--active']//a[text()='Efros Config Inspector']")
    private WebElement selectEfrosCI;

    public EfrosCIPage clickEfrosCIButton() {
        headerBlock.clickProductButton();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(selectEfrosCI));
        selectEfrosCI.click();
        return new EfrosCIPage(driver);
    }
}
