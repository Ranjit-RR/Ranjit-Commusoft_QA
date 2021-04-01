package testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import action.Baseclass;
import pages.CreateJob;
import pages.Customer;
import pages.LoginPage;
import pages.searchengine;

public class K_Check extends Baseclass {
String homepage;
	
	@Test(priority = 0)
	public void login() throws InterruptedException
	{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(sheet.sheetIN("Login",0, 1),sheet.sheetIN("Login",1, 1),sheet.sheetIN("Login", 2, 1));
		Thread.sleep(1000);
		homepage = driver.getCurrentUrl();
	}
	
	@Test(priority =1)
	public void Jobparts_PO() throws InterruptedException
	{
		Thread.sleep(3000);
		Customer customer = new Customer(driver);
		CreateJob job = new CreateJob(driver);
		searchengine search = new searchengine(driver);
		customer.Add_Customer();
		job.addjob();
		job.JobDescription("No Rules");
		job.createjob();
		job.Jobparts_fulfil("10", "1", "Requested");
		job.order_from_supplier();
		Thread.sleep(2000);
		search.searchbox_supplier("Supplier");
		search.searchbox_supplier_parts_nominalcode("parts");
		search.parts_deliverymethod("Delivery to office");
		job.save_po();
		/* Assertion for invoiec values check */
		job.assert_invoicetotal("5,000.00");
		job.assert_invoicevattotal("1,000.00");
		job.assert_invoicegrand("6,000.00");
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
