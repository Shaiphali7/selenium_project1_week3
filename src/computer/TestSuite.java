package computer;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestSuite extends Utility {
    @Before
    public void setUp() {
        openBrowser();
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder () {
        // Click on Computer Menu(mouse hover the computer menu )
        Actions actions = new Actions(driver);
        WebElement computerElement = getElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Computers ']"));
        actions.moveToElement(computerElement).build().perform();
        //Click on desktop
        clickOnElement(By.xpath("//ul[@class='sublist first-level']/li/a[contains(text(),'Desktops')][1]"));
         //Select sort by-Name:Z to A
        WebElement dropDown=driver.findElement(By.id("products-orderby"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Name: Z to A");

        /*
        Verify the Product will arrange in Descending order.
         */
        //Getting the all product displayed
        List<WebElement> sortBy=driver.findElements(By.tagName("h2"));
        //Storing in a two list String type
        List<String> product = new ArrayList<String>();
        for (WebElement e : sortBy)
        {
            product.add(e.getText());
        }

// make a copy of the list
        List<String> descending = new ArrayList<String>(product);
        // sort the list
        Collections.sort(descending);

// true if the product will arrange in descending order
        System.out.println(descending.equals(product));

    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully()throws InterruptedException
    {
        // Click on Computer Menu(mouse hover the computer menu )
        Actions actions = new Actions(driver);
        WebElement computerElement = getElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Computers ']"));
        actions.moveToElement(computerElement).build().perform();
        //Click on desktop
        clickOnElement(By.xpath("//ul[@class='sublist first-level']/li/a[contains(text(),'Desktops')][1]"));
        //Select sort by-Name:Z to A
        WebElement dropDown=driver.findElement(By.id("products-orderby"));
        Select select=new Select(dropDown);
        select.selectByVisibleText("Name: A to Z");
        //Click on "Add To Cart"
         Thread.sleep(200);
        clickOnElement(By.xpath("(//button[@class='button-2 product-box-add-to-cart-button'])[1]"));
        // Verify the Text "Build your own computer"
        Thread.sleep(200);
        String actualText=gettextFromElement(By.xpath("//div[@class='product-name']"));
        String expectedText="Build your own computer";
        Assert.assertEquals("Heading is not same",actualText,expectedText);
       // Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
        WebElement dropDown1=driver.findElement(By.id("product_attribute_1"));
        Select select1=new Select(dropDown1);
        select1.selectByIndex(1);
        //Select "8GB [+$60.00]" using Select class.
        WebElement dropDown2=driver.findElement(By.id("product_attribute_2"));
        Select select2=new Select(dropDown2);
        select2.selectByIndex(3);
        // Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));
        // Select OS radio "Vista Premium [+$60.00]
        clickOnElement(By.id("product_attribute_4_9"));
        //Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander[+$5.00]"
        clickOnElement(By.id("product_attribute_5_12"));
         //Verify the price "$1,475.00"
        String actualTotal=gettextFromElement(By.xpath("//span[@id='price-value-1']"));
        System.out.println(actualTotal);
        // Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));
        // Verify the Message "The product has been added to your shopping cart" on Top green Bar
       String actualAddCartMessage=gettextFromElement(By.xpath("//p[@class='content']"));
        //System.out.println(actualAddCartMessage);
        String expectedMessage="The product has been added to your shopping cart";
        Assert.assertEquals("Heading is wronge",actualAddCartMessage,expectedMessage);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        //Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        WebElement shoppingCart=getElement(By.xpath("//span[@class='cart-label']"));
        actions.moveToElement(shoppingCart).build().perform();
        clickOnElement(By.xpath("//button[@class='button-1 cart-button']"));
        // Verify the message "Shopping cart"
        String actualShoppingCart=gettextFromElement(By.tagName("h1"));
        String expected1="Shopping cart";
        Assert.assertEquals("Not the same heading",actualShoppingCart,expected1);
        Thread.sleep(200);
        //Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[@id='itemquantity11222']")).clear();
        sendTextToElement(By.xpath("//input[@id='itemquantity11222']"),"2");
        clickOnElement(By.xpath("/button[@id='updatecart']"));
        // Verify the Total"$2,950.00"
        String actualTotalCost=gettextFromElement(By.xpath("//div[@class='totals']//strong"));
        System.out.println(actualTotalCost);
        // click on checkbox “I agree with the terms of service”
        clickOnElement(By.id("termsofservice"));
        // Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        // Verify the Text “Welcome, Please Sign In!”
        String actualWelcomeMessage=gettextFromElement(By.tagName("h1"));
        //Click on “CHECKOUT AS GUEST”Tab
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
        // Fill the all mandatory field

        // Click on “CONTINUE”
        // Click on Radio Button “Next Day Air($0.00)”
        //Click on “CONTINUE”
        // Select Radio Button “Credit Card”
        //Select “Master card” From Select credit card dropdown
        // Fill all the details
        // Click on “CONTINUE”
        //Verify “Payment Method” is “Credit Card”
        //Verify “Shipping Method” is “Next Day Air”
        // Verify Total is “$2,950.00”
        // Click on “CONFIRM”
        // Verify the Text “Thank You”
        // Verify the message “Your order has been successfully processed!”
        // Click on “CONTINUE”
        // Verify the text “Welcome to our store”



    }

    @After

    public void tearDown() {
        //closeBrowser();
    }
}
