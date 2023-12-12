package tests.day02_Configuration_driver_kullanımı;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class c04_negatifLoginTesti {
    /*
    1- https://www.testotomasyonu.com/ anasayfasina gidin
    2- login linkine basin
    3- 3 farkli test method’u olusturun.
    - gecerli username, gecersiz password
    - gecersiz username, gecerli password
    - gecersiz username, gecersiz password.
    4- Login butonuna basarak login olun
    5- Basarili olarak giris yapilamadigini test edin
     */

      @Test(groups = "smoke")
    public void gecersizPasswordTesti() {
          // 1- https://www.testotomasyonu.com/ anasayfasina gidin
          Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
          ReusableMethods.bekle(1);
          // 2- account linkine basin
          TestOtomasyonuPage testOtomasyonuPage = new TestOtomasyonuPage();
          testOtomasyonuPage.accountLinki.click();

          //  - gecerli username, gecersiz password
          ReusableMethods.bekle(1);
          testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecerliEmail"));
          testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
          // 4- Login butonuna basarak login olun
          ReusableMethods.bekle(1);
          testOtomasyonuPage.loginButonu.click();
          // 5- Basarili olarak giris yapilamadigini test edin
          ReusableMethods.bekle(2);
          Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());
          Driver.closeDriver();
      }

      @Test(groups = "regression")
    public void gecersizEmailTesti() {
          Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
          ReusableMethods.bekle(1);
          TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
          testOtomasyonuPage.accountLinki.click();
          //gecersiz username, gecerli password
          ReusableMethods.bekle(1);
         testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
          testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecerliPassword"));
          ReusableMethods.bekle(1);
          testOtomasyonuPage.loginButonu.click();
          Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());
          ReusableMethods.bekle(2);
          Driver.closeDriver();




      }


      @Test(priority = 5)
    public void gecersizEmailGecersizPassword(){
          /*
    1- https://www.testotomasyonu.com/ anasayfasina gidin

    2- login linkine basin
    -3 gecersiz username, gecersiz password.
    4- Login butonuna basarak login olun
    5- Basarili olarak giris yapilamadigini test edin

     */

          Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
          ReusableMethods.bekle(1);
          TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
          testOtomasyonuPage.accountLinki.click();
          ReusableMethods.bekle(1);
         testOtomasyonuPage.emailKutusu.sendKeys(ConfigReader.getProperty("toGecersizEmail"));
         testOtomasyonuPage.passwordKutusu.sendKeys(ConfigReader.getProperty("toGecersizPassword"));
          ReusableMethods.bekle(1);
          testOtomasyonuPage.loginButonu.click();
          Assert.assertTrue(testOtomasyonuPage.emailKutusu.isDisplayed());
          ReusableMethods.bekle(2);
          Driver.closeDriver();

      }

}

