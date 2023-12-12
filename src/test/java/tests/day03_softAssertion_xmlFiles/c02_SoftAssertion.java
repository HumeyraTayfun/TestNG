package tests.day03_softAssertion_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class c02_SoftAssertion {
    /*
    1. “http://zero.webappsecurity.com/” Adresine gidin
    3 Sign in butonuna basin
    2. webbappsecurity ana sayafaya gittiginizi dogrulayin
    4. Login kutusuna “username” yazin
    5. Password kutusuna “password” yazin
    6. Sign in tusuna basin
    7. Back tusuna basin
    8. Giris yapilabildigini dogrulayin
    9. Online banking menusunu tiklayin
   10. Pay Bills sayfasina gidin
   11. “Purchase Foreign Currency” tusuna basin
   12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
   13. “Currency” dropdown menusunden Eurozone’u secin
   14. “Eurozone (euro)” secildigini dogrulayin
   15. Dropdown menude 16 option bulundugunu dogrulayin.
   16. Dropdown menude “Canada (dollar)” bulunduğunu dogrulayin
   17. Sayfayi kapatin

     */

    @Test
    public void softAssertionTesti(){
     //   1. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));

       // 2. webbappsecurity ana sayafaya gittiginizi dogrulayin
        SoftAssert softAssert=new SoftAssert();
        String expectedUrl="http://zero.webappsecurity.com/";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Anasayfada degiliz");
        //   3 Sign in butonuna basin
        ZeroPage zeroPage=new ZeroPage();
        zeroPage.signInLinki.click();

       // 4. Login kutusuna “username” yazin
        zeroPage.usernameKutusu.sendKeys("username");

      //  5. Password kutusuna “password” yazin
        zeroPage.passwordKutusu.sendKeys("password");
      //  6. Sign in tusuna basin
        zeroPage.signInButonu.click();
       // 7. Back tusuna basin
        Driver.getDriver().navigate().back();
      //  8. Giris yapilabildigini dogrulayin
         softAssert.assertTrue(zeroPage.onlineBankingLinki.isDisplayed(),"Giris yapilamadi");
      //  9. Online banking menusunu tiklayin
        zeroPage.onlineBankingLinki.click();
       // 10. Pay Bills sayfasina gidin
        zeroPage.payBillsLinki.click();
      //  11. “Purchase Foreign Currency” tusuna basin
        zeroPage.purchaseForeignCurrencyLinki.click();

      //  12. Currency dropdown menusunun erisilebilir oldugunu dogrulayin
         softAssert.assertTrue(zeroPage.pcCurrencyDropdownElementi.isEnabled(),"currency dropdown kullanilamiyor");
       // 13. “Currency” dropdown menusunden Eurozone’u secin
        Select select=new Select(zeroPage.pcCurrencyDropdownElementi);
        select.selectByValue("EUR");
       // 14. “Eurozone (euro)” secildigini dogrulayin
         String expectedOption="Eurozone (euro)";
         String actualOption=select.getFirstSelectedOption().getText();
         softAssert.assertEquals(actualOption,expectedOption,"Eurozone secilemedi");
       // 15. Dropdown menude 16 option bulundugunu dogrulayin.
         int expectedOptionSize=16;
         int actualOptionSize=select.getOptions().size();
         softAssert.assertEquals(actualOptionSize,expectedOptionSize,"Dropdown menu istenen boyutta degil");
       // 16. Dropdown menude “Canada (dollar)” bulunduğunu dogrulayin

        List<WebElement>dropdownElementleriList=select.getOptions();
        List<String>dropdownYazilariList= ReusableMethods.stringlisteDönüştür(dropdownElementleriList);
        softAssert.assertTrue(dropdownYazilariList.contains("Canada (dollar)"),"Dropdown'da Canada Dolari yok");

        softAssert.assertAll();
        ReusableMethods.bekle(2);
       // 17. Sayfayi kapatin
        Driver.closeDriver();

    }
}
