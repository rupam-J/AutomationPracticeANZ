package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.sql.Struct;

public class PageObject {
    By sign_in = By.xpath("//a[@title='Log in to your customer account']");
    By email_login = By.id("email_create");
    By create_account = By.id("SubmitCreate");
    By gender_mr = By.id("id_gender1");
    By gender_mrs = By.id("id_gender2");
    By first_name = By.id("customer_firstname");
    By last_name = By.id("customer_lastname");
    By email_id = By.id("email");
    By pwd = By.id("passwd");
    By day = By.id("days");
    By month = By.id("months");
    By year = By.id("years");
    By select_address = By.id("address1");
    By address_firstname = By.id("firstname");
    By address_lastname = By.id("lastname");
    By enter_city = By.id("city");
    By enter_state = By.id("id_state");
    By postal_code = By.id("postcode");
    By enter_country  = By.id("id_country");
    By mobile_no = By.id("phone_mobile");
    By address_alias = By.id("alias");
    By select_register = By.id("submitAccount");
    By customer_account_verify = By.xpath("//a[@title='View my customer account']");
    By already_registered_email = By.id("email");
    By already_registered_pwd = By.id("passwd");
    By already_registered_sign_in = By. id("SubmitLogin");
    By logout = By.xpath("//a[@title='Log me out']");
    By tab_shirt = By.xpath("(//a[@title='T-shirts'])[2]");
    By view_cart = By.xpath("//a[@title='Faded Short Sleeve T-shirts']");
    By add_to_cart = By.xpath("//a[@title='Add to cart']");
    By proceed_to_checkout_1 = By.xpath("(//a[@title='Proceed to checkout'])[1]");
    By checkout_page = By.name("processAddress");
    By proceed_to_checkout_2 = By.xpath("(//a[@title='Proceed to checkout'])[2]");
    By checkbox = By.id("cgv");
    By checkout_shipping = By.name("processCarrier");
    By productImage = By.className("product_img_link");

    WebDriver driver;

    public PageObject(WebDriver driver){
        this.driver = driver;
    }

    public void accountVerfiy(){
       System.out.println(driver.findElement(customer_account_verify).getText());
        if (driver.findElement(customer_account_verify).getText().equals("new user")) {
            System.out.println("Correct name and surname are displayed");
        }
        else {
            System.out.println("InCorrect name and surname are displayed");
        }
    }

    public void signIn(){
        driver.findElement(sign_in).click();
    }

    public void emailLogin(String emailLogin){
        driver.findElement(email_login).sendKeys(emailLogin);
    }

    public void createAccount(){
        driver.findElement(create_account).click();
    }

    public void enterValue(String gender, String firstName, String lastName,
                           String password, String days, String months, String years, String addressFirstName,
                           String addressLastName, String address, String city, String state, String postalCode, String country,
                           String mobile, String addressAlias) {

        if(gender.equals("Mr")) {
            driver.findElement(gender_mr).click();
        }
        else if(gender.equals("Mrs")){
            driver.findElement(gender_mrs).click();
        }

        driver.findElement(first_name).sendKeys(firstName);
        driver.findElement(last_name).sendKeys(lastName);
        driver.findElement(pwd).sendKeys(password);
        driver.findElement(day).sendKeys(days);
        driver.findElement(month).sendKeys(months);
        driver.findElement(year).sendKeys(years);
        driver.findElement(select_address).sendKeys(address);
        driver.findElement(address_firstname).sendKeys(addressFirstName);
        driver.findElement(address_lastname).sendKeys(addressLastName);
        driver.findElement(enter_city).sendKeys(city);
        driver.findElement(enter_state).sendKeys(state);
        driver.findElement(postal_code).sendKeys(postalCode);
        driver.findElement(enter_country).sendKeys(country);
        driver.findElement(mobile_no).sendKeys(mobile);
        driver.findElement(address_alias).sendKeys(addressAlias);
    }

    public void register(){
        driver.findElement(select_register).click();
    }


    public void alreadyRegistered(String alreadyRegisteredEmail , String alreadyRegisteredPwd){
         driver.findElement(already_registered_email).sendKeys(alreadyRegisteredEmail);
         driver.findElement(already_registered_pwd).sendKeys(alreadyRegisteredPwd);
         driver.findElement(already_registered_sign_in).click();

    }

    public void signOut(){
        driver.findElement(logout).click();
    }

    public void openTshirtpage(){
        driver.findElement(tab_shirt).click();
    }
    public void addToCartWhileHover(){

        Actions actions = new Actions(driver);
        WebElement productImageElement = driver.findElement(productImage);
        actions.moveToElement(productImageElement).perform();
        driver.findElement(add_to_cart).click();
    }

    public void ProceedToCheckout(){
        driver.findElement(proceed_to_checkout_1).click();
        driver.findElement(proceed_to_checkout_2).click();
        driver.findElement(checkout_page).click();
        driver.findElement(checkbox).click();
        driver.findElement(checkout_shipping).click();
    }
}
