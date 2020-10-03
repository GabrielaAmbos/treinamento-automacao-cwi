package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageElementMapper {

    @FindBy(css = ".cart_description .product-name")
    public WebElement productNameCart;
}
