package tests.TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AutomationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class t02_testCase {

    @Test
    public void test01() {
       /*
        1. Launch browser
        2. Navigate to url 'http://automationexercise.com'
        3. Verify that home page is visible successfully
        4. Click 'Signup / Login' button
        5. Fill all details in Signup and create account
        6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        7. Verify ' Logged in as username' at top
        8. Add products to cart
        9. Click 'Cart' button
        10. Verify that cart page is displayed
        11. Click Proceed To Checkout
        12. Verify that the delivery address is same address filled at the time registration of account
        13. Verify that the billing address is same address filled at the time registration of account
        14. Click 'Delete Account' button
        15. Verify 'ACCOUNT DELETED!' and click 'Continue' button

        */
     //   2. Navigate to url 'http://automationexercise.com'
        Driver.getDriver().get(ConfigReader.getProperty("autoUrl"));

        //3. Verify that home page is visible successfully

        String expectedUrl="https://automationexercise.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualUrl,expectedUrl,"home page is not visible");

       // 4. Click 'Signup / Login' button
        AutomationPage automationPage=new AutomationPage();
        automationPage.signInLoginLinki.click();
        ReusableMethods.bekle(1);

        //5. Fill all details in Signup and create account
        automationPage.emailBox.sendKeys("humeyratayfun@hotmail.com");
        automationPage.passwordBox.sendKeys("mekselina");
        automationPage.loginLinki.click();

      //  7. Verify ' Logged in as username' at top

        String expectedUsername="Logged in as Hümeyra";
        String actualUserName=automationPage.loginAsUserName.getText();
        softAssert.assertEquals(actualUserName,expectedUsername,"Logged in as username is not visible");

       // 8. Add products to cart

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();",automationPage.urunResmi);
        ReusableMethods.bekle(1);
        automationPage.addToCart.click();
        automationPage.continueShopping.click();

       // 9. Click 'Cart' button
        automationPage.cartLinki.click();



       // 10. Verify that cart page is displayed
       // softAssert.assertTrue(automationPage.shoppingCart.isDisplayed()," cart page is not displayed");
        softAssert.assertTrue(automationPage.shoppingCart.isDisplayed()," cart page is not displayed");
       // 11. Click Proceed To Checkout

        automationPage.proceedToCheckoutLinki.click();
        ReusableMethods.bekle(1);


      //  12. Verify that the delivery address is same address filled at the time registration of account
        softAssert.assertTrue(automationPage.Yourdeliveryaddress.isDisplayed(),"delivery address is not same address");
       // 13. Verify that the billing address is same address filled at the time registration of account
        softAssert.assertTrue(automationPage.Yourbillingaddress.isDisplayed(),"billing address is not same address ");
       // 14. Click 'Delete Account' button
        automationPage.deleteAccountLinki.click();

        //15. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        softAssert.assertTrue(automationPage.accountDeletedYazisi.isDisplayed(),"'ACCOUNT DELETED isnot displayed");
        automationPage.continueLinki.click();
        softAssert.assertAll();
        Driver.quitDriver();
    }
}
