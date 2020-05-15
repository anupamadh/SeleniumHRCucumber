package hrapp;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import resources.base;
import utils.jdbcConnection;

public class HomePage extends base{
	public static Logger log = LogManager.getLogger(base.class.getName());
	
@BeforeTest	
public void initialize() throws IOException {
	BasicConfigurator.configure();
	driver = initializeDriver();
}


@Test
public void basePageNavigation() throws IOException, SQLException {
	driver.get(prop.getProperty("url"));
	LoginPage lp = new LoginPage(driver);
	jdbcConnection jd = new jdbcConnection();
	jd.getConnection();
	lp.getUsername().sendKeys(jd.getUsername());
	lp.getPassword().sendKeys(jd.getPassword());
	lp.getLoginButton().click();
	
}


}
