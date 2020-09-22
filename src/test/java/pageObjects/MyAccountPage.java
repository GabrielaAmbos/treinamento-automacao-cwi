package pageObjects;

import elementMapper.MyAccountElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class MyAccountPage extends MyAccountElementMapper {

    public MyAccountPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextMyAccount() {
        return myAccount.getText();
    }


}
