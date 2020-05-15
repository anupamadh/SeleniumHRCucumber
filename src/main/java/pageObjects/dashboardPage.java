package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dashboardPage {
	
private WebDriver driver;
private By welcome = By.cssSelector("#welcome");
private By leave = By.id("menu_leave_viewLeaveModule");
private By dashboard_menu = By.id("menu_dashboard_index");
private By assign_leave = By.xpath("//a[contains(@href,'assignLeave')]/img");
private static WebDriverWait w= null;
private By employee = By.cssSelector("#entitlements_employee_empName");
private By leave_type = By.cssSelector("#entitlements_leave_type");
private By leave_period = By.cssSelector("#period");
private By entitlement = By.cssSelector("#entitlements_entitlement");
private By button_save = By.cssSelector("#btnSave");
private By total_text = By.cssSelector("tr[class='total'] td:nth-child(2)");
private By popup = By.id("employeeEntitlement");
private By popup_confirm = By.id("dialogUpdateEntitlementConfirmBtn");

public dashboardPage(WebDriver driver) {
	this.driver = driver;
}


public WebElement getWelcome() {
			return driver.findElement(welcome);
}

public WebElement getAddEntitlements() {
	WebElement element = driver.findElement(leave);
	element.click();
	Actions actions = new Actions(driver);
	WebElement entitlements = driver.findElement(By.xpath("//a[@id='menu_leave_Entitlements']"));
	actions.moveToElement(entitlements).perform();
	WebElement addEntitlements = driver.findElement(By.xpath("//a[contains(text(),'Add Entitlements')]"));
	return addEntitlements;
}

public WebElement getDashboardMenu() {
	return driver.findElement(dashboard_menu);
}
public WebElement getAssignLeave() {
	return driver.findElement(assign_leave);
}

public WebElement getEmployee() {
	return driver.findElement(employee);
}

public WebElement getLeaveType() {
	return driver.findElement(leave_type);
}

public WebElement getLeavePeriod() {
	return driver.findElement(leave_period);
}

public WebElement getEntitlement() {
	return driver.findElement(entitlement);
}

public WebElement getSaveButton() {
	return driver.findElement(button_save);
}

public WebElement getTotalText() {
	return driver.findElement(total_text);
}

@SuppressWarnings("finally")
public int getPopupSize() {
	try {
	w= new WebDriverWait(driver, 5);
	w.until(ExpectedConditions.visibilityOfElementLocated(popup));
	
	}
	finally{
		return driver.findElements(popup).size();
	}
}

public WebElement getPopup() {
	return driver.findElement(popup_confirm);
}


}
