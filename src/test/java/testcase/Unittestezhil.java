package testcase;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import action.Baseclass;
import pages.CreateJob;
import pages.LoginPage;

public class Unittestezhil extends Baseclass {
	
	String homepage;
	String customer = "https://stage2.commusoft.net/customers/customer/1135/view/property/view";
    String Job = "https://stage2.commusoft.net/customers/customer/1135/jobs/1261/costs/jobcostsview";
    String supplierinvoice = "https://stage2.commusoft.net/suppliers/2/invoice/17/details";
	
	
	@Test(priority = 0)
	public void login() throws InterruptedException
	{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(sheet.sheetIN("Login",0, 1),sheet.sheetIN("Login",1, 1),sheet.sheetIN("Login", 2, 1));
		Thread.sleep(5000);
		homepage = driver.getCurrentUrl();
	}
	@Test(priority = 1)
	public void Add_job() throws InterruptedException
	{
		driver.get(customer);
		Thread.sleep(2000);
		driver.get(Job);
		Thread.sleep(2000);
//		CreateJob job = new CreateJob(driver);
//		job.addjob();
//		job.JobDescription("PreFinal");
//		job.createjob();
		//click("(//span[text()='Costs'])[1]");
		
	}
	@Test(priority = 2)
	public void Add_Supplierinvoice() throws InterruptedException
	{
		driver.get(supplierinvoice);
	//  Click quicklink: click ("//a[@class='btn dropdown-toggle btn-small quick-links-btn']");
		
	//delete Sup PO
		
		Thread.sleep(3000);
		click("//span[text()='Quick links']");
		Thread.sleep(3000);
		click("//span[text()='Quick links']");
		
		click("//span[text()='Delete']");
		Thread.sleep(2000);
		type("//input[@id='confirm_delete_input']", "Delete");
		Thread.sleep(1000);
		click("//a[text()='Delete']");
		
			
	}
	
	
	}