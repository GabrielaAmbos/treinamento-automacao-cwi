package pageObjects;

import elementMapper.ProductPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ProductPage extends ProductPageElementMapper {

    public ProductPage () {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextProductName() {
        return itemName.getText();
    }

    public String getTextProductPrice() {
        return itemPrice.getText();
    }

    public void isImageItem() {
        itemImage.equals("image-block");
    }

    public void clickBtnAddToCart() {
        addToCart.click();
    }


}
