package pageObject.desktop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pageObject.constants.TextConstants;
import pageObject.abstractClasses.BasePage;


public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='js-site-search-input']")
    WebElement searchField;
    @FindBy(xpath = "//button[@class='btn btn-link js_search_button']")
    WebElement searchButton;

    public HomePage(WebDriver driver) {

        super(driver);
    }

    public void open() {
        getDriver().get(TextConstants.URL);
    }

    public HomePage enterValueToSearchField(String productId) {
        setField(searchField, productId);
        return this;
    }

    public SearchResultPage clickSearchButton() {
        clickButton(searchButton);
        return new SearchResultPage(driver);
    }

}
