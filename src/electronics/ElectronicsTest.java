package electronics;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class ElectronicsTest extends Utility {
    String baseURL = "https://demo.nopcommerce.com/electronics";
    @Before
    public void setUp()
    {
        openBrowser(baseURL);
    }

    @Test
    public void verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse Hover on “Electronics”Tab
        mouseHover(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/a[1]"));

        //2.2 Mouse Hover on “Cell phones” and click
        mouseHover(By.xpath("//body/div[6]/div[2]/ul[1]/li[2]/ul[1]/li[2]/a[1]"));

        clickOnElement(By.xpath("(//ul[@class='sublist first-level']//li)[5]"));

        //2.3 Verify the text “Cell phones”
        verifyText(driver, By.xpath("//h1[contains(text(),'Cell phones')]"), "Cell phones"); // /html/body/div[6]/div[2]/ul[1]/li[2]/ul/li[2]/a

        //2.4 Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));

        //2.5 Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/h2[1]/a[1]"));

        //2.6 Verify the text “Nokia Lumia 1020”
        verifyText(driver, By.xpath("//h1[contains(text(),'Nokia Lumia 1020')]"), "Nokia Lumia 1020");

        //2.7 Verify the price “$349.00”
        verifyText(driver, By.xpath("//span[@id='price-value-20']"), "$349.00");

        //2.8 Change quantity to 2
        clearQty(By.xpath("//input[@id='product_enteredQuantity_20']"));

        // clearTextFromField(By.xpath("//input[@id='product_enteredQuantity_20']"));
        sendTextToElement(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");

        //2.9 Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));

        //2.10 Verify the Message "The product has been added to your shopping cart" on Top green Bar
//        verifyText(driver, By.xpath("//body/div[@id='bar-notification']/div[1]/p[1]"), "The product has been added to your shopping cart");
//        //After that close the bar clicking on the cross button.
//        clickOnElement(By.xpath("//body/div[@id='bar-notification']/div[1]/span[1]"));

        //2.11 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHover(By.xpath("//span[contains(text(),'Shopping cart')]"));
        clickOnElement(By.xpath("//button[contains(text(),'Go to cart')]"));

        //2.12 Verify the message "Shopping cart"
        verifyText(driver, By.xpath("//span[contains(text(),'Shopping cart')]"), "Shopping cart");

        //2.13 Verify the quantity is 2
        verifyText(driver, By.xpath("//h1[contains(text(),'Shopping cart')]"), "2");

        //2.14 Verify the Total $698.00
        verifyText(driver, By.xpath("//tbody/tr[1]/td[6]/span[1]"), "$698.00");

        //2.15 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.16 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.17 Verify the Text “Welcome, Please Sign In!”
        verifyText(driver, By.xpath("//h1[contains(text(),'Welcome, Please Sign In!')]"), "Welcome, Please Sign In!");

        //2.18 Click on “REGISTER” tab
        clickOnElement(By.xpath("//button[contains(text(),'Register')]"));

        //2.19 Verify the text “Register”
        verifyText(driver, By.xpath("//h1[contains(text(),'Register')]"), "Register");

        //2.20 Fill the mandatory fields
        clickOnElement(By.xpath("//input[@id='gender-male']"));
        sendTextToElement(By.xpath("//input[@id='FirstName']"), "Prime");
        sendTextToElement(By.xpath("//input[@id='LastName']"), "Testing");
        selectByVisibleTextFromDropDown(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[1]"), "10");
        selectByVisibleTextFromDropDown(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[2]"), "May");
        selectByVisibleTextFromDropDown(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[4]/div[1]/select[3]"), "1925");
        sendTextToElement(By.xpath("//input[@id='Email']"), "prime1@gmail.com");
        sendTextToElement(By.xpath("//input[@id='Company']"), "Prime Ltd");
        clickOnElement(By.xpath("//input[@id='Newsletter']"));
        sendTextToElement(By.xpath("//input[@id='Password']"), "prime@123");
        sendTextToElement(By.xpath("//input[@id='ConfirmPassword']"), "prime@123");

        // 2.21 Click on “REGISTER” Button
        clickOnElement(By.xpath("//button[@id='register-button']"));

        //2.22 Verify the message “Your registration completed”
        verifyText(driver, By.xpath("//div[contains(text(),'Your registration completed')]"), "Your registration completed");

        //2.23 Click on “CONTINUE” tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));

        //2.24 Verify the text “Shopping cart”
        verifyText(driver, By.xpath("//h1[contains(text(),'Shopping cart')]"), "Shopping cart");
        clickOnElement(By.xpath("//span[contains(text(),'Shopping cart')]"));

        //2.25 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));

        //2.26 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.27 Fill the Mandatory fields
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"), "Other");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"), "Harrow");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"), "100");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address2']"), "London Road");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "HA9 0SB");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "0158955785");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FaxNumber']"), "0154785955");

        //2.28 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[1]/div[2]/div[1]/button[4]"));

        //2.29 Click on Radio Button “2nd Day Air ($0.00)”
        clickOnElement(By.xpath("//label[contains(text(),'2nd Day Air ($0.00)')]"));

        //2.30 Click on “CONTINUE”
        clickOnElement(By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[3]/div[2]/form[1]/div[2]/button[1]"));

        //2.31 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//label[normalize-space()='Credit Card']"));
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));

        //2.32 Select “Visa” From Select credit card dropdown
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Visa");

        //2.33 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"), "Prime Testing");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"), "5521573041475125");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "10");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2025");
        sendTextToElement(By.xpath("//input[@id='CardCode']"), "245");

        //2.34 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.35 Verify “Payment Method” is “Credit Card”
        verifyText(driver, By.xpath("//span[contains(text(),'Credit Card')]"), "Credit Card");

        //2.36 Verify “Shipping Method” is “2nd Day Air”
        verifyText(driver, By.xpath("//body/div[6]/div[3]/div[1]/div[1]/div[1]/div[2]/ol[1]/li[6]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/ul[1]/li[1]/span[2]"), "\n" +
                "                                2nd Day Air\n" +
                "                            ");

        //2.37 Verify Total is “$698.00”
        verifyText(driver, By.xpath("//tbody/tr[1]/td[6]/span[1]"), "$698.00");

        //2.38 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[contains(text(),'Confirm')]"));

        //2.39 Verify the Text “Thank You”
        verifyText(driver, By.xpath("//h1[contains(text(),'Thank you')]"), "Thank you");

        //2.40 Verify the message “Your order has been successfully processed!”
        verifyText(driver, By.xpath("//strong[contains(text(),'Your order has been successfully processed!')]"), "Your order has been successfully processed!");

        //2.41 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[contains(text(),'Continue')]"));

        //2.42 Verify the text “Welcome to our store”
        verifyText(driver, By.xpath("//h2[contains(text(),'Welcome to our store')]"), "Welcome to our store");

        //2.43 Click on “Logout” link
        clickOnElement(By.xpath("//a[contains(text(),'Log out')]"));

        //2.44 Verify the URL is “https://demo.nopcommerce.com/”
        String currentURL = driver.getCurrentUrl();
        String actualUTL = "https://demo.nopcommerce.com/";
        Assert.assertEquals(currentURL, actualUTL);
        Thread.sleep(3000);
    }
    @After
    public void tearDown()
    {

        closeBrowser();
}

}
