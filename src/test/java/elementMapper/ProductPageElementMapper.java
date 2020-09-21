package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageElementMapper {

    @FindBy(xpath = "//*[@itemprop='name']")
    public WebElement itemName;

    @FindBy(xpath = "//*[@itemprop='image']")
    public WebElement itemImage;

    @FindBy(xpath = "//*[@itemprop='price']")
    public WebElement itemPrice;

    @FindBy(name = "Submit")
    public WebElement addToCart;


}
