package pageObject.desktop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.abstractClasses.BasePage;

public final class CartPage extends BasePage {

//    private final By subtotal = By.xpath("//div[@class='col-xs-6 cart-totals-right text-right']");
//    private final By total = By.xpath("//div[@class='col-xs-6 cart-totals-right text-right grand-total']");
//    private final By checkOutButtonInCart = By.xpath("//div[@class='cart__actions']//button[contains(text(),'Check Out')]");

    @FindBy(xpath="//div[@class='col-xs-6 cart-totals-right text-right']")
    WebElement subtotal;
    @FindBy(xpath="//div[@class='col-xs-6 cart-totals-right text-right grand-total']")
    WebElement total;
    @FindBy(xpath="//div[@class='cart__actions']//button[contains(text(),'Check Out')]")
    WebElement checkOutButtonInCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

//    public CartPage verifySubtotalEqualsValue(String amount)
//    {
//        Assert.assertEquals(amount, subtotal.findElement(driver).getText());
//        return this;
//    }

    public CartPage verifySubtotalEqualsValue(String amount)
    {
        verifyFieldEquals(subtotal, amount);
        return this;
    }

    public CartPage verifyTotalEqualsValue(String amount)
    {
        verifyFieldEquals(total, amount);
        return this;
    }

    public RegisterPage clickCheckOutInCartButton()
    {
        clickButton(checkOutButtonInCart);
        return new RegisterPage(driver);
    }
}

