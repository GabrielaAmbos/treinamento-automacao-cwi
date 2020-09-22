package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountElementMapper {

    @FindBy(className = "page-heading")
    public WebElement myAccount;
}
