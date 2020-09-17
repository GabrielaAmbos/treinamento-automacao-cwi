package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.assertTrue;

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

}
