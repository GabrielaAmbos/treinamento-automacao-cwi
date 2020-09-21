package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageElementMapper {

    @FindBy(className = "navigation_page")
    public WebElement pageNavigation;

    @FindBy(className = "lighter")
    public WebElement searchResult;

    @FindBy(className = "heading-counter")
    public WebElement resultNumber;

    @FindBy(xpath = "//*[@itemprop='name']")
    public WebElement nameItem;

    @FindBy(xpath = "//*[@title='Add to cart']")
    public WebElement addToCart;


}
