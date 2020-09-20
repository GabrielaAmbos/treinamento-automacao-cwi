package pageObjects;

import elementMapper.SearchPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class SearchPage extends SearchPageElementMapper {

    public SearchPage() {
        PageFactory.initElements(Browser.getCurrentDriver(), this);
    }

    public String getTextPageNavigation() {
        return pageNavigation.getText();
    }

    public String getTextSearchResult() {
        return searchResult.getText().replace("\"", "");
    }

    public String getTextResultNumber() {
        return resultNumber.getText();
    }

    public boolean isSearchPage() {
        return getTextPageNavigation().equals("Search");
    }
}
