package pageObject.constants;

import org.openqa.selenium.WebDriver;
import pageObject.abstractClasses.BasePage;


public class TextConstants extends BasePage {
    public static final String URL = "https://ecse00100fdb.epam.com:9002/yacceleratorstorefront/?site=electronics";

    public TextConstants(WebDriver driver) {
        super(driver);
    }
}
