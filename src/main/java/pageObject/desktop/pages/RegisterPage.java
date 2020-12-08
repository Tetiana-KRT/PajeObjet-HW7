package pageObject.desktop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.abstractClasses.BasePage;

public final class RegisterPage extends BasePage {

    @FindBy(xpath="//input[@id='guest.email']")
    WebElement guestEmailInput;
    @FindBy(xpath="//input[@id='guest.confirm.email']")
    WebElement confirmGuestEmailInput;
    @FindBy(xpath="//button[.='Check Out as a Guest']")
    WebElement checkOutAsGuestButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage setGuestEmail(String guestEmail)
    {
        setField(guestEmailInput, guestEmail);
        return this;
    }

    public RegisterPage confirmGuestEmail(String guestEmail)
    {
        setField(confirmGuestEmailInput, guestEmail);
        return this;
    }

    public OrderSummaryPage clickCheckOutAsGuestButton()
    {
        clickButton(checkOutAsGuestButton);
        return new OrderSummaryPage(driver);
    }
}


