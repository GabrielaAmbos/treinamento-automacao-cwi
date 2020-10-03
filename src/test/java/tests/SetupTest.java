package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.*;

@Feature("Testes site de ecommerce")
public class SetupTest extends BaseTests{

    @Test
    @Story("Abrir o site")
    public void testOpenBrowserAndLoadPage() {
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abriuuuu!!!");
    }

    @Test
    @Story("Realizar o login")
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
    @Story("Pesquisar por um produto")
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

  /*  @Test
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

       searchPage.clickBtnAddToCart();

        assertEquals(productPage.getProductNamePDP(), quest);
    }*/

    @Test
    @Story("Acessar categoria T-shirts")
    public void testAcessCategoryTShirts() {
        HomePage homePage = new HomePage();
        CategoryPage categoryPage = new CategoryPage();

        homePage.clickCategoryTShirts();
        assertTrue(categoryPage.isTShirts());

    }

    @Test
    @Story("Acessar categoria Women")
    public void testAcessCategoryWomen() {
        HomePage homePage = new HomePage();
        CategoryPage categoryPage = new CategoryPage();

        homePage.clickCategoryWomen();
        assertTrue(categoryPage.isWomen());
    }

    @Test
    @Story("Acessar categoria T-Shirts e visualizar pagina do produto")
    public void testAddProductToProductPage() {
        //Acessar a categoria T-Shirts
        testAcessCategoryTShirts();

        CategoryPage categoryPage = new CategoryPage();
        ProductPage productPage = new ProductPage();

        String nameProductCategory = categoryPage.getProductNameCategory();

        categoryPage.clickProductAddToProductPage();

        assertTrue(productPage.getProductNamePDP().contains(nameProductCategory));

    }

    @Test
    @Story("Acessar categoria T-Shirts, visualizar pagina do produto e adicionar ao carrinho")
    public void testAddProductToCartPage() {
        //Acessa a página de produto
        testAddProductToProductPage();

        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        String nameProductPDP = productPage.getProductNamePDP();

        productPage.clickButtonAddToCart();

        productPage.clickButtonModalProceedToCheckout();

        assertTrue(cartPage.getNameProductCart().contains(nameProductPDP));

    }

    @Test
    @Story("Fluxo completo de compras logado no sistema")
    public void testPurchaseFlow() {
        //Logar no sistema
        testLogin();

        //Acessar a categoria Women
        testAcessCategoryWomen();

        CategoryPage categoryPage = new CategoryPage();
        ProductPage productPage = new ProductPage();

        String nameProductCategory = categoryPage.getProductNameCategory();

        categoryPage.clickProductAddToProductPage();

        assertTrue(productPage.getProductNamePDP().contains(nameProductCategory));

        CartPage cartPage = new CartPage();

        String nameProductPDP = productPage.getProductNamePDP();

        productPage.clickButtonAddToCart();

        productPage.clickButtonModalProceedToCheckout();

        assertTrue(cartPage.getNameProductCart().contains(nameProductPDP));

    }


}
