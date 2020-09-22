package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPageElementMapper {

    @FindBy(className = "cat-name")
    public WebElement categoryName;
}
