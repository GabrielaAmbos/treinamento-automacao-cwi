package tests;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.HomePage;
import pageObjects.ProductPage;
import pageObjects.SearchPage;
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
        Browser.getCurrentDriver().findElement(By.className("login")).click();
        System.out.println("Click login");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains((Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account"))));
        Browser.getCurrentDriver().findElement(By.id("email")).sendKeys("gabrielaambos15@gmail.com");
        Browser.getCurrentDriver().findElement(By.id("passwd")).sendKeys("senha123");
        Browser.getCurrentDriver().findElement(By.id("SubmitLogin")).click();
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
        assertTrue(Browser.getCurrentDriver().findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
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

}
