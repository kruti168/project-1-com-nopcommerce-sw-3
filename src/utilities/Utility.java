package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {


    //This Method will hoover element
    public WebElement mouseHover(By by)
    {
        return driver.findElement(by);
    }


    public void selectMenu(String menu)
    {
        driver.findElement(By.linkText(menu)).click();
    }

    //This method click on the menu
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }

    //This method will open dropDown Menu.
    public WebElement dropDownMenu(By by)
    {
        return driver.findElement(by);
    }

    //This method will get text from element
    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }

    //This method verify the text with element
    public boolean verifyText(WebDriver driver, By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        String actualText = element.getText();
        return actualText.equals(expectedText);
    }

    //This method will send text to element
    public void sendTextToElement(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }

    //This method will be clear the qty.
    public void clearQty(By by)
    {
        driver.findElement(by).clear();
    }

    public void selectByVisibleTextFromDropDown(By by, String text){
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
}




}
