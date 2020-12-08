package pageObject.desktop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.desktop.fragments.AddProductToCartPopup;
import pageObject.abstractClasses.BasePage;

public final class ProductDetailsPage extends BasePage {
    @FindBy(xpath="//button[@id='addToCartButton']")
    WebElement addToCartButton;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public AddProductToCartPopup clickAddToCartButton()
    {
        clickButton(addToCartButton);
        return new AddProductToCartPopup(driver);
    }
}
