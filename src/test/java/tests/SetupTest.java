package tests;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.*;

public class SetupTest extends BaseTests{

    @Test
    public void testOpenBrowserAndLoadPage() {
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abriuuuu!!!");
    }

    @Test
    public void testLogin() {
        String email = "gabrielaambos15@gmail.com";
        String passwd = "senha123";

        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        MyAccountPage myAccountPage = new MyAccountPage();

        homePage.clickBtnLogin();
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains((Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account"))));

        loginPage.keysEmail(email);
        loginPage.keysPassword(passwd);
        loginPage.clickBtnSubmit();

        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));

        assertTrue(myAccountPage.getTextMyAccount().contains("MY ACCOUNT"));
    }

    @Test
    public void testSearch() {
        String quest = "DRESS";
        String resultQts = "7";

        HomePage home = new HomePage();
        SearchPage searchPage = new SearchPage();

        home.doSearch(quest);
        assertTrue(searchPage.isSearchPage());
        assertEquals(quest, searchPage.getTextSearchResult());
        assertThat(searchPage.getTextResultNumber(), CoreMatchers.containsString(resultQts));
    }

    @Test
    public void testSearchAndViewItem() {
        String quest = "Blouse";
        String price = "$27.00";

        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();
        ProductPage productPage = new ProductPage();

        homePage.doSearch(quest);
        assertTrue(searchPage.isSearchPage());
        assertEquals(quest.toUpperCase(), searchPage.getTextSearchResult());

        assertEquals(searchPage.getTextNameItem(), quest);

       //searchPage.clickBtnAddToCart();

       // assertEquals(productPage.itemName, quest);
    }

    @Test
    public void testAcessCategoryTShirts() {
        HomePage homePage = new HomePage();
        CategoryPage categoryPage = new CategoryPage();

        homePage.clickCategoryTShirts();
        assertTrue(categoryPage.isTShirts());

    }

}
