package pageObjects;

import elementMapper.CategoryPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class CategoryPage extends CategoryPageElementMapper {

    public CategoryPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextCategoryName() {
       return categoryName.getText();
    }

    public boolean isTShirts() {
        return getTextCategoryName().contains("T-SHIRTS");
    }

    public boolean isDresses() {
        return getTextCategoryName().contains("DRESSES");
    }

    public boolean isWomen() {
        return getTextCategoryName().contains("WOMEN");
    }

    public void clickProductAddToProductPage() {
        BasePage.mouseOver(productNameCategory);
        buttonMoreAddToProductPage.click();
    }

    public String getProductNameCategory() {
        return productNameCategory.getText();
    }



}
