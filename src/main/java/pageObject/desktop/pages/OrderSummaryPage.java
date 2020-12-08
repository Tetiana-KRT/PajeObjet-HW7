package pageObject.desktop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.abstractClasses.BasePage;

public final class OrderSummaryPage extends BasePage {

    @FindBy(xpath="//div[@class='subtotal']//span")
    WebElement subtotalValue;
    @FindBy(xpath="//div[@class='totals']//span")
    WebElement totalValue;
    @FindBy(xpath="//div[@class='realTotals']//p")
    WebElement taxValue;

    public OrderSummaryPage(WebDriver driver) {
        super(driver);
    }

    public OrderSummaryPage verifySubtotalEqualsAmount(String amount)
    {
        verifyFieldEquals(subtotalValue, amount);
        return this;
    }

    public OrderSummaryPage verifyTotalEqualsAmount(String amount)
    {
        verifyFieldEquals(totalValue, amount);
        return this;
    }

    public OrderSummaryPage verifyTaxEqualsAmount(String amount)
    {
        verifyFieldContains(taxValue, amount);
        return this;
    }
}


