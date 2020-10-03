package pageObjects;

import elementMapper.HomePageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class HomePage extends HomePageElementMapper {

    public HomePage () {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public void clickBtnLogin() {
        login.click();
    }

    public void clickSearch() {
        search.click();
    }

    public void sendKeysSearch(String keys) {
        search.sendKeys(keys);
    }

    public void clickSubmit() {
        submit.click();
    }

    public void doSearch (String key) {
        clickSearch();
        sendKeysSearch(key);
        clickSubmit();
    }

    public void clickCategoryTShirts() {
        menuTshirts.click();
    }

    public void clickCategoryDresses() {
        menuDresses.click();
    }

    public void clickCategoryWomen() {
        menuWomen.click();
    }
}
