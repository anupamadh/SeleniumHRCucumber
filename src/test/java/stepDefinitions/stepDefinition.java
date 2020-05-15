package stepDefinitions;

import org.apache.log4j.BasicConfigurator;
import org.junit.runner.RunWith;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.LoginPage;
import pageObjects.dashboardPage;
import resources.base;

@RunWith(Cucumber.class)
public class stepDefinition extends base{

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	BasicConfigurator.configure();
    	driver = initializeDriver();
    }

    @And("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }
    
    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	LoginPage lp = new LoginPage(driver);
     	lp.getUsername().sendKeys(username);
    	lp.getPassword().sendKeys(password);
    	lp.getLoginButton().click();
    }

    @Then("^Verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
    	dashboardPage dp = new dashboardPage(driver);
    	Assert.assertEquals(dp.getWelcome().getText(), "Welcome Admin");
		
    }
    
    @And("^close browsers$")
    public void close_browsers() throws Throwable {
        driver.quit();
    }

   

}