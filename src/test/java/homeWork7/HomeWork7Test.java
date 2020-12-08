package homeWork7;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.constants.TextConstants;
import pageObject.desktop.fragments.AddProductToCartPopup;
import pageObject.desktop.pages.*;

import java.util.concurrent.TimeUnit;

public class HomeWork7Test {

    public WebDriver driver;
    private HomePage homePage;
    private SearchResultPage searchResultPagePage;
    private ProductDetailsPage productDetailsPage;
    private AddProductToCartPopup addProductToCartPopup;
    private CartPage cartPage;
    private RegisterPage registerPage;
    private OrderSummaryPage orderSummaryPage;



    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--ignore-certificate-errors");
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\\\Tetiana_Kryvytska\\\\Downloads\\\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\homeWorkMaven\\\\New Version\\\\src\\resources\\\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "src/resources");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        homePage = new HomePage(driver);
        searchResultPagePage = new SearchResultPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        addProductToCartPopup = new AddProductToCartPopup(driver);
        cartPage = new CartPage(driver);
        registerPage = new RegisterPage(driver);
        orderSummaryPage = new OrderSummaryPage(driver);
    }

    @DisplayName("Add To Cart Test")
    @Tag("testTag")
    @Test
    public void addToCartTest() {
        driver.get(TextConstants.URL);
//        driver.get("https://ecse00100fdb.epam.com:9002/yacceleratorstorefront/?site=electronics");
        String amount = "￥610.00";
        String taxAmount = "￥55.45";
        String testEmail = "test@user.com";
        String testProductId = "1934793";

        homePage.enterValueToSearchField(testProductId);
        homePage.clickSearchButton();
        searchResultPagePage.openProductDetails(testProductId);
        productDetailsPage.clickAddToCartButton();
        addProductToCartPopup.clickCheckOutButton();
        cartPage.verifySubtotalEqualsValue(amount);
        cartPage.verifyTotalEqualsValue(amount);
        cartPage.clickCheckOutInCartButton();
        registerPage.setGuestEmail(testEmail);
        registerPage.confirmGuestEmail(testEmail);
        registerPage.clickCheckOutAsGuestButton();
        orderSummaryPage.verifySubtotalEqualsAmount(amount);
        orderSummaryPage.verifyTotalEqualsAmount(amount);
        orderSummaryPage.verifyTaxEqualsAmount(taxAmount);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
