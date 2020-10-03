package pageObjects;

import elementMapper.ProductPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class ProductPage extends ProductPageElementMapper {

    public ProductPage () {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getProductNamePDP() {
        return productNamePDP.getText();
    }

    public String getTextProductPrice() {
        return itemPrice.getText();
    }

    public void clickButtonAddToCart() {
        buttonAddToCart.click();
    }

    public void clickButtonModalProceedToCheckout() {
        buttonModalProceedToCheckout.click();
    }



}
