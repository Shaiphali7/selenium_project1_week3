package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    @Before
    public void setUp() {
        openBrowser();
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    {
       //mouse hover the Electronic menu
        Actions actions = new Actions(driver);
        WebElement electronicsElement = getElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Electronics ']"));
        actions.moveToElement(electronicsElement).build().perform();
        //Click on "Cell phone"
        clickOnElement(By.partialLinkText("Cell phon"));
        //1.3 Verify the text “Cell phones"
        String actualPhoneText=gettextFromElement(By.tagName("h1"));
        String expectedPhoneText="Cell phones";
        Assert.assertEquals("Not a right text",actualPhoneText,expectedPhoneText);

    }
    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully()throws InterruptedException
    {
        //2.1 Mouse Hover on “Electronics”Tab
        Actions actions = new Actions(driver);
        WebElement electronicsElement = getElement(By.xpath("//ul[@class='top-menu notmobile']//a[text() = 'Electronics ']"));
        actions.moveToElement(electronicsElement).build().perform();
        // 2.2 Mouse Hover on “Cell phones” and click
        Thread.sleep(200);
        clickOnElement(By.partialLinkText("Cell phon"));
       //2.3 Verify the text “Cell phones”
        String actualPhoneText=gettextFromElement(By.tagName("h1"));
        String expectedPhoneText="Cell phones";
        Assert.assertEquals("Not a right text",actualPhoneText,expectedPhoneText);
       //2.4 Click on List View Tab
        Thread.sleep(400);
        clickOnElement(By.xpath("//a[@class='viewmode-icon list']"));
       //2.5 Click on product name “Nokia Lumia 1020” link
        Thread.sleep(400);
        clickOnElement(By.xpath("//h2[@class='product-title']//a[text()='Nokia Lumia 1020']"));
        //2.6 Verify the text “Nokia Lumia 1020”
        Thread.sleep(400);
        String actualPhoneName=gettextFromElement(By.tagName("h1"));
        String expectedPhoneName="Nokia Lumia 1020";
        Assert.assertEquals("Not a right text",actualPhoneName,expectedPhoneName);

       //2.7 Verify the price “$349.00”
        String actualPrice=gettextFromElement(By.xpath("//span[@class='price-value-20']"));
        String expectedPrice="$349.00";
        Assert.assertEquals("Not a right text",actualPrice,expectedPrice);

        // 2.8 Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"),"2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top
        String actualMessage=gettextFromElement(By.xpath("//p[@class='content']"));

        String expectedMessage="The product has been added to your shopping cart";
        Assert.assertEquals("Not a right text",actualMessage,expectedMessage);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));
        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        Thread.sleep(200);
        WebElement shoppingCart = getElement(By.xpath("//span[@class='cart-label']"));
        actions.moveToElement(shoppingCart).build().perform();
        clickOnElement(By.xpath("//button[text()='Go to cart']"));

        //2.12 Verify the message "Shopping cart"
        String actualCartName=gettextFromElement(By.tagName("h1"));
        String expectedCartName="Shopping cart";
        Assert.assertEquals("Not a right text",actualPrice,expectedPrice);

        //2.13 Verify the quantity is 2
        Thread.sleep(200);
//        String actualQuantity=gettextFromElement(By.xpath("//input[@id='itemquantity11224']"));
//        String expectedQuantity="2";
//        System.out.println(actualQuantity);
//        Assert.assertEquals("Not a right text",actualQuantity,expectedQuantity);

        //2.14 Verify the Total $698.00
        String actualPriceFor2=gettextFromElement(By.xpath("//span[@class='product-subtotal']"));
        String expectedPriceFor2="$698.00";
        Assert.assertEquals("Not a right text",actualPriceFor2,expectedPriceFor2);

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        String actualWelcomeMessage=gettextFromElement(By.tagName("h1"));
        String expectedWelcomeMessage="Welcome, Please Sign In!";
        Assert.assertEquals("Not a right text",actualWelcomeMessage,expectedWelcomeMessage);

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[@class='button-1 register-button']"));
        //2.19 Verify the text “Register”
        String actualRegister=gettextFromElement(By.tagName("h1"));
        String expectedRegister="Register";
        Assert.assertEquals("Not a right text",actualRegister,expectedRegister);

//        2.20 Fill the mandatory fields
        sendTextToElement(By.id("FirstName"),"Name");
        sendTextToElement(By.id("LastName"),"Jain");

        //Enter date of birth(Day)
        sendTextToElement(By.name("DateOfBirthDay"),"27");
        //Enter date of birth(Month)
        sendTextToElement(By.name("DateOfBirthMonth"),"January");
        //Enter date of birth(year)
        sendTextToElement(By.name("DateOfBirthYear"),"1995");
        //Enter Email
        sendTextToElement(By.id("Email"),"Primea@gmail.com");
        //Enter Password
        sendTextToElement(By.name("Password"),"Prime123#");
        //Enter Confirm Password
        sendTextToElement(By.name("ConfirmPassword"),"Prime123#");

        //Clicking in Register button
        clickOnElement(By.id("register-button"));

//        2.22 Verify the message “Your registration completed”
        String actualMessage1 = gettextFromElement(By.xpath("//div[@class='result']"));

        String expectedMessageAfterRegistration = "Your registration completed";
        Assert.assertEquals("Message is not correct", expectedMessageAfterRegistration, actualMessage1);
//        2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[@class='button-1 register-continue-button']"));
//        2.24 Verify the text “Shopping card”

//        2.25 click on checkbox “I agree with the terms of service”

//        2.26 Click on “CHECKOUT”
//        2.27 Fill the Mandatory fields
//        2.28 Click on “CONTINUE”
//        2.29 Click on Radio Button “2nd Day Air ($0.00)”
//        2.30 Click on “CONTINUE”
//        2.31 Select Radio Button “Credit Card”
//        2.32 Select “Visa” From Select credit card dropdown
//        2.33 Fill all the details
//        2.34 Click on “CONTINUE”
//        2.35 Verify “Payment Method” is “Credit Card”
//        2.36 Verify “Shipping Method” is “2nd Day Air”
//        2.37 Verify Total is “$698.00”
//        2.38 Click on “CONFIRM”
//        2.39 Verify the Text “Thank You”
//        2.40 Verify the message “Your order has been successfully processed!”
//        2.41 Click on “CONTINUE”
//        2.42 Verify the text “Welcome to our store”
//        2.43 Click on “Logout” link
//        2.44 Verify the URL is “https://demo.nopcommerce.com/

    }
    @After

    public void tearDown() {
        //closeBrowser();
    }
    }

