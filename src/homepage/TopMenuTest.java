package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser();
    }
    public void selectMenu(String menu)
    {

        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li/a[text() ='" + menu + " ']")).click();
    }
    @Test
    public void verifyPageNavigation()
    {
        String menu="Computers";
      selectMenu(menu);
      //Verifying the page navigation
        System.out.println(driver.getTitle());

    }
    @After
    public void tearDown() {
        //closeBrowser();
    }
}
