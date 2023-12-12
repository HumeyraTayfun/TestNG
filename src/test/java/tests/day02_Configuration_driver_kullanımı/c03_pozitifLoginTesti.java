package tests.day02_Configuration_driver_kullanımı;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class c03_pozitifLoginTesti {

    /*
    1- https://www.testotomasyonu.com/ anasayfasina gidin
    2- account linkine basin
    3- Kullanici email’i olarak “wise@gmail.com”girin
    4- Kullanici sifresi olarak “12345" girin
    5- Login butonuna basarak login olun
    6- Basarili olarak giris yapilabildigini test edin
     */

      @Test(groups = {"smoke","regression"})
    public void pozitifLoginTesti(){

          Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
          ReusableMethods.bekle(2);
          TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
          testOtomasyonuPage.accountLinki.click();
          testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
          testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
          ReusableMethods.bekle(1);
          testOtomasyonuPage.loginButonu.click();
          Assert.assertTrue(testOtomasyonuPage.logoutLinki.isDisplayed());
          Driver.closeDriver();

      }
}
