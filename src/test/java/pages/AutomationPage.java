package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AutomationPage {

    public AutomationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()=' Signup / Login']")
    public WebElement signInLoginLinki;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[text()='Login']")
    public WebElement loginLinki;

    @FindBy(xpath = "//li[10]")
    public WebElement loginAsUserName;

    @FindBy(xpath = "(//*[@class='btn btn-default add-to-cart'])[1]")
    public WebElement addToCart;

    @FindBy(xpath = "(//img[@alt='ecommerce website products'])[1]")
    public WebElement urunResmi;

    @FindBy(xpath ="//li[@class='active']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//a[@class='btn btn-default check_out']")
    public WebElement proceedToCheckoutLinki;

    @FindBy(xpath = "//*[text()='Your delivery address']")
    public WebElement Yourdeliveryaddress;

    @FindBy(xpath = "//*[text()='Your billing address']")
    public WebElement Yourbillingaddress;

    @FindBy(xpath = " //*[text()=' Delete Account']")
    public WebElement deleteAccountLinki;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement accountDeletedYazisi;

    @FindBy(xpath = "//*[text()='Continue']")
    public WebElement continueLinki;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShopping;

    @FindBy(xpath = "//*[text()=' Cart']")
    public WebElement cartLinki;

}
