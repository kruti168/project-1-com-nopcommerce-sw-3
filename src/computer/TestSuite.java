package computer;

import com.google.common.base.Verify;
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

    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp(){

    openBrowser(baseUrl);

    }
    @Test
    public void verifyProductArrangeInAlphaBaticalOrder(){

     //Click on Computer Menu
    clickOnElement(By.xpath("//a[text()='Computers ']"));

    //Click on Desktop
     clickOnElement((By.linkText("Desktops")));

    //1.3 Select Sort By position "Name: Z to A"
     WebElement dropDown  = dropDownMenu(By.xpath("//select[@id='products-orderby']"));
     Select select = new Select(dropDown);
     select.selectByVisibleText("Name: Z to A");

     //1.4 Verify the Product will arrange in Descending order.
        List<WebElement>beforFilterNameZtoAList = driver.findElements(By.xpath("item-grid"));
        List<Double>beforefileNameZtoAList = new ArrayList<>();
        for ( WebElement nameZtoA :beforFilterNameZtoAList){

            beforefileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$","")));
        }

        select.selectByVisibleText("Name: Z to A");
        List<WebElement>afterFilterNameZtoAList = driver.findElements(By.xpath("item-grid"));
        List<Double>afterfileNameZtoAList = new ArrayList<>();
        for ( WebElement nameZtoA :beforFilterNameZtoAList){

            beforefileNameZtoAList.add(Double.valueOf(nameZtoA.getText().replace("$","")));
        }
        Collections.sort(beforefileNameZtoAList);
        Assert.assertEquals(beforFilterNameZtoAList,afterFilterNameZtoAList);



    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully()throws InterruptedException{
        //Click on Computer Menu
        clickOnElement(By.xpath("//a[text()='Computers ']"));

        //Click on Desktop
        clickOnElement((By.linkText("Desktops")));

        //2.3 Select Sort By position "Name: A to Z"
        WebElement dropDown  = dropDownMenu(By.id("products-orderby"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name: A to Z");

        //2.4 Click on "Add To Cart"
     Thread.sleep(2000);
     clickOnElement(By.xpath("//div[@class='product-item']/div[2]/div[3]/div[2]/button[1]"));

       //2 .5 Verify the Text "Build your own computer"
        String expectedMessage = "Build your own computer";
       String actualMessage = getTextFromElement(By.linkText("Build your own computer"));
       Assert.assertEquals(expectedMessage,actualMessage);

     //   2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class
   WebElement drop  = dropDownMenu(By.name("product_attribute_1"));
   Select select1 = new Select(drop);
     select1.selectByVisibleText("2.2 GHz Intel Pentium Dual-Core E2200");

     //2.7.Select "8GB [+$60.00]" using Select class.
        WebElement drop1  = dropDownMenu(By.name("product_attribute_2"));
        Select select2 = new Select(drop1);
        select2.selectByVisibleText("8GB [+$60.00]");

     //   2.8 Select HDD radio "400 GB [+$100.00]"
        clickOnElement(By.id("product_attribute_3_7"));

     //   2.9 Select OS radio "Vista Premium [+$60.00]"
        clickOnElement(By.id("product_attribute_4_9"));

     //2.10 Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        List<WebElement> checkbox =driver.findElements(By.xpath("//input[@name='product_attribute_5']"));
        for(int i=0; i<checkbox.size(); i++)
        {
            String value = checkbox.get(i).getAttribute("value");
            if(value.equalsIgnoreCase("Microsoft Office [+$50.00]")  )
            {
                break;
            }
        }
        clickOnElement(By.xpath("//input[@id='product_attribute_5_12']"));

        //2.11 Verify the price "$1,475.00
    //    String expectedMessage1 = "$1,460.00";
     //   String actualMessage1 = getTextFromElement(By.id("price-value-1"));
     //   Assert.assertEquals(expectedMessage1,actualMessage1);

        //2.12 Click on "ADD TO CARD" Button.
        clickOnElement(By.id("add-to-cart-button-1"));

      //  2.13 Verify the Message "The product has been added to your shopping cart" on Topgreen Bar

        String expectedMessage2 = "The product has been added to your shopping cart";
        String actualMessage2 = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals(expectedMessage2,actualMessage2);

        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@class='close']"));

        //2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.


        WebElement shoppingCart = driver.findElement(By.xpath("//span[contains(text(),'Shopping cart')]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(shoppingCart).build().perform();
        shoppingCart.click();

        //2.15 Verify the message "Shopping cart"
        String expectedMessage3 = "Shopping cart";
        String actualMessage3 = getTextFromElement(By.xpath("//h1[text()='Shopping cart']"));
        Assert.assertEquals(expectedMessage3,actualMessage3);

        //2.16 Change the Qty to "2" and Click on "Update shopping cart

        //driver.findElement(By.xpath("//input[@class='qty-input']")).clear();
        clearQty(By.xpath("//input[@class='qty-input']"));
        sendTextToElement(By.xpath("//input[@class='qty-input']"),"2");

        //2.17 Verify the Total"$2,950.00"
//        String expectedMessage4 = "$2,950.00";
//        String actualMessage4 = getTextFromElement(By.xpath("//span[@class='value-summary']//strong[contains(text(),'$2,950.00')])"));
//        Assert.assertEquals(actualMessage4,expectedMessage4);

        //2.18 click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));


        //2.19 Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));

        //2.20 Verify the Text “Welcome, Please Sign In! verify the msg. Welcome, Please Sign In!
        String expectedMessage5 = "Welcome, Please Sign In!";
        String actualMessage5 = getTextFromElement(By.xpath("//h1[normalize-space()='Welcome, Please Sign In!']"));
        Assert.assertEquals(expectedMessage5,actualMessage5);

        //2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[normalize-space()='Checkout as Guest']"));

        //2.22 Fill the all mandatory field
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FirstName']"),"kruti");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_LastName']"),"Patel");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Email']"),"kruti14387@gmail.com");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Company']"),"Kruti Ltd.");

        WebElement country = dropDownMenu(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
        Select select3 = new Select(country);
        select3.selectByVisibleText("United Kingdom");

        WebElement state = dropDownMenu(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"));
        Select select4 = new Select(state);
        select4.selectByVisibleText("Other");

        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_City']"),"Watford");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address1']"),"11");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_Address2']"),"Diamond close");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"),"Wd24 5hd");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"),"07458932222");
        sendTextToElement(By.xpath("//input[@id='BillingNewAddress_FaxNumber']"),"");

        //2.23 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        //2.24 Click on Radio Button “Next Day Air($0.00)”
        clickOnElement(By.xpath("//input[@id='shippingoption_1']"));

        //2.25 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@onclick='ShippingMethod.save()']"));

        //2.26 Select Radio Button “Credit Card”
        clickOnElement(By.xpath("//label[contains(text(),'Credit Card')]"));
        clickOnElement(By.xpath("//button[@onclick='PaymentMethod.save()']"));

        //2.27 Select “Master card” From Select credit card dropdown
        WebElement creditCardType = dropDownMenu((By.xpath("//select[@id='CreditCardType']")));
        Select select5 = new Select(creditCardType);
        select5.selectByVisibleText("Master card");

        //2.28 Fill all the details
        sendTextToElement(By.xpath("//input[@id='CardholderName']"),"Axika ltd");
        sendTextToElement(By.xpath("//input[@id='CardNumber']"),"5521573041475125");

        WebElement month = driver.findElement(By.xpath("//select[@id='ExpireMonth']"));
        Select select6 = new Select(month);
        select6.selectByVisibleText("10");

        WebElement year = driver.findElement(By.xpath("//select[@id='ExpireYear']"));
        Select select7 = new Select(year);
        select7.selectByVisibleText("2027");

        sendTextToElement(By.xpath("//input[@id='CardCode']"),"522");;

        //2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));

        //2.30 Verify “Payment Method” is “Credit Card”

        //2.34 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));

        //2.35 Verify the Text “Thank You"
        String expectedMsg3 = "Thank you";
        String actualMsg3= getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        Assert.assertEquals(expectedMsg3,actualMsg3);

        //2.36 Verify the message “Your order has been successfully processed!”
        String exporderMsg = "Your order has been successfully processed!";
        String actordMsg = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        Assert.assertEquals(actordMsg,exporderMsg);

        //2.37 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));

        //2.38 Verify the text “Welcome to our store”
        String actFinalmsg = "Welcome to our store";
        String expFinalmsg = getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        Assert.assertEquals(expFinalmsg,actFinalmsg);





    }

}
