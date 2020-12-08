package pageObject.desktop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.abstractClasses.BasePage;

public final class SearchResultPage extends BasePage {

    private static By productInSearchResult (String productId){
        return By.xpath(String.format("//a[@class='product__list--name'][contains(@href, '%s')]", productId));
    }

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage openProductDetails(String productId)
    {
        clickButton(productInSearchResult(productId));
        return new ProductDetailsPage(driver);
    }

}
