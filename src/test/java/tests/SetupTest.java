package tests;

import org.junit.Test;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.assertTrue;

public class SetupTest extends BaseTests{

    @Test
    public void testOpenBrowserAndLoadPage() {
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abriuuuu!!!");
    }

}
