package stepDefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageObject;

import java.io.File;
import java.time.Duration;
import java.util.Map;

public class CreateLogin {
    WebDriver driver;
    PageObject pageObject;

    @Given("User is at the your logo page")
    public void user_is_at_the_your_logo_page(){
        String rootDir = System.getProperty("user.dir");
        String chromeDriverPath = rootDir + File.separator + "src"+File.separator+"test"+File.separator+"resources"+File.separator+"drivers"+File.separator+"chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver =new ChromeDriver();
        pageObject = new PageObject(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(" http://automationpractice.com/index.php");
    }

    @When("User click on Sign In")
    public void user_click_on_sign_In(){
        pageObject.signIn();
    }

    @And("User enters email address")
    public void user_enters_email_address(Map<String,String> table){
        pageObject.emailLogin(table.get("email"));
    }

    @And("User clicks on create an account")
    public void user_clicks_on_create_an_account(){
        pageObject.createAccount();
    }

    @And("User enters details with below values")
    public void user_click_on_sign_In(Map<String,String> table){
        pageObject.enterValue(table.get("title"), table.get("firstName"),table.get("lastName"),
                table.get("password"),table.get("date"), table.get("month"),table.get("year"),table.get("firstNameAddress"),
                table.get("lastNameAddress"),table.get("address"),table.get("city"), table.get("state"),table.get("postalCode"),
                table.get("country"),table.get("mobilePhone"),table.get("assignAnAddressAliasForFutureReference"));

    }

    @Then("User clicks on register")
    public void user_clicks_on_register(){
        pageObject.register();
        driver.close();
    }

    @And("Verify correct name and surname are displayed")
        public void verify_correct_name_and_surname_are_displayed(){
            pageObject.accountVerfiy();
        }
    @And("User clicks on signout")
    public void user_clicks_on_signout(){
        pageObject.signOut();
        driver.close();
    }

    @And("User login with below details")
    public void user_login(Map<String,String> table) {
        pageObject.alreadyRegistered(table.get("alreadyRegisteredEmail"),table.get("alreadyRegisteredPwd"));
    }


    @And("User clicks on T-shirt tab and adds the item in cart")
    public void userClicksOnTShirtTabAndAddsTheItemInCart() {
        pageObject.openTshirtpage();
        pageObject.addToCartWhileHover();
        pageObject.ProceedToCheckout();
        driver.close();
    }
}
