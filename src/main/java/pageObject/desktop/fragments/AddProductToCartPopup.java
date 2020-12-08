package pageObject.desktop.fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.desktop.pages.CartPage;
import pageObject.abstractClasses.BasePage;

public final class AddProductToCartPopup extends BasePage {

    @FindBy(xpath="//a[contains(text(),'Check Out')]")
    WebElement checkOutButton;

    public AddProductToCartPopup(WebDriver driver) {
        super(driver);
    }

    public CartPage clickCheckOutButton()
    {
        clickButton(checkOutButton);
        return new CartPage(driver);
    }
}

