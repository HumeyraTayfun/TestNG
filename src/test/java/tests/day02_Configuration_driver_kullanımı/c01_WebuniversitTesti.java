package tests.day02_Configuration_driver_kullanımı;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebuniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class c01_WebuniversitTesti {
    /*
     1.“http://webdriveruniversity.com/” adresine gidin
            2.“Login Portal” a kadar asagi inin
3.“Login Portal” a tiklayin
4.Diger window’a gecin
5.“username” ve “password” kutularina deger yazdirin
6.“login” butonuna basin
7.Popup’ta cikan yazinin “validation failed” oldugunu test edin
8.Ok diyerek Popup’i kapatin
9.Ilk sayfaya geri donun
10.Ilk sayfaya donuldugunu test edin
     */


        @Test
        public void negatifLoginTesti(){
        //1."http://webdriveruniversity.com/" adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/");
        //2."Login Portal" a  kadar asagi inin
        WebuniversityPage webuniversityPage = new WebuniversityPage();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",webuniversityPage.loginPortalLinki);
        //3."Login Portal" a tiklayin
        ReusableMethods.bekle(1);
        webuniversityPage.loginPortalLinki.click();
        //4.Diger window'a gecin
        ReusableMethods.titleİleSayfaDeğiştir("WebDriver | Login Portal");
        //5."username" ve  "password" kutularina rastgele deger yazdirin

        Faker faker = new Faker();
        webuniversityPage.usernameKutusu.sendKeys(faker.name().username());
        webuniversityPage.passwordKutusu.sendKeys(faker.internet().password());
        //6."login" butonuna basin
        webuniversityPage.loginButonu.click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        ReusableMethods.bekle(1);
        String expectedAlertYazisi = "validation failed";
        String actualAlertYazisi = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualAlertYazisi,expectedAlertYazisi);
        //8.Ok diyerek Popup'i kapatin
        Driver.getDriver().switchTo().alert().accept();
        ReusableMethods.bekle(1);
        //9.Ilk sayfaya geri donun
        String ilkSayfaTitle = "WebDriverUniversity.com";
        ReusableMethods.titleİleSayfaDeğiştir(ilkSayfaTitle);
        //10.Ilk sayfaya donuldugunu test edin
        ReusableMethods.bekle(1);
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle,ilkSayfaTitle);


        Driver.quitDriver();
    }
    }

