package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElementMapper {

    @FindBy(className = "login")
    public WebElement login;

    @FindBy(id = "search_query_top")
    public WebElement search;

    @FindBy(name = "submit_search")
    public WebElement submit;

    @FindBy(css = "#block_top_menu .sf-menu li:nth-child(3) a[title=T-shirts]")
    public WebElement menuTshirts;

    @FindBy(css = "#block_top_menu .sf-menu li:nth-child(1) a[title=Dresses]")
    public WebElement menuDresses;

    @FindBy(css = "#block_top_menu .sf-menu li:nth-child(1) a[title=Women]")
    public WebElement menuWomen;

}
