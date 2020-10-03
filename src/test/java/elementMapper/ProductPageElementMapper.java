package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageElementMapper {

    @FindBy(css = "h1[itemprop=name]")
    public WebElement productNamePDP;

    @FindBy(xpath = "//*[@itemprop=price]")
    public WebElement itemPrice;

    @FindBy(css = "#add_to_cart > button")
    public WebElement buttonAddToCart;

    @FindBy(css = ".button-container a[title='Proceed to checkout")
    public WebElement buttonModalProceedToCheckout;


}
