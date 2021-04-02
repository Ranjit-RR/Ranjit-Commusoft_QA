package testcase;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import action.Baseclass;
import pages.CreateJob;
import pages.LoginPage;

public class Supplier_invoice extends Baseclass {
	
	String homepage;
	String customer = "https://stage2.commusoft.net/customers/customer/1135/view/property/view";
   
	
	
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
		Thread.sleep(4000);
		
		Thread.sleep(4000);
		CreateJob job = new CreateJob(driver);
		job.addjob();
		job.JobDescription("PreFinal");
		job.createjob();
		click("(//span[text()='Costs'])[1]");
		
	}
	@Test(priority = 2)
	public void Add_Supplierinvoice() throws InterruptedException
	{
		click("//a [text() ='Add new supplier invoice']");
		click ("//span [text() ='Please select a supplier']");
		Thread.sleep(5000);
		
		type ("//input [@class='select2-input select2-focused'][1]", "Supplier");
		Thread.sleep(5000);
		click ("//li [@class='select2-results-dept-0 select2-result select2-result-selectable']");
		type ("//input [@class='ng-pristine ng-invalid ng-invalid-required']", "Inv223");
		Thread.sleep(1000);
		dclick ("//td [@class='afterHiddenColumn firstVisibleColumn']");
		
		type ("//textarea [@class='handsontableInput'][1]", "Invo22item");
		typeenter("//textarea [@class='handsontableInput'][1]");
		
		Thread.sleep(1000);
		//Quantity:
	   dclick("//td[@class='overflow_handsontable current highlight']");
	 
		Thread.sleep(1000);
		clear("(//textarea[@class='handsontableInput'])[2]");
	
		Thread.sleep(2000);
		type("(//textarea[@class='handsontableInput'])[2]", "20");
		typeenter("(//textarea[@class='handsontableInput'])[2]");
		Thread.sleep(2000);
		
		
	//Unit cost:
		
		   dclick("//td[@class='overflow_handsontable current highlight']");
		 
			Thread.sleep(1000);
			clear("(//textarea[@class='handsontableInput'])[2]");
		
			Thread.sleep(2000);
			type("(//textarea[@class='handsontableInput'])[2]", "20");
			typeenter("(//textarea[@class='handsontableInput'])[2]");
			Thread.sleep(2000);
			
	//sales cost:
			
			   dclick("//td[@class='overflow_handsontable current highlight']");
			 
				Thread.sleep(1000);
				clear("(//textarea[@class='handsontableInput'])[1]");
			
				Thread.sleep(2000);
				type("(//textarea[@class='handsontableInput'])[1]", "20");
				typeenter("(//textarea[@class='handsontableInput'])[1]");
				Thread.sleep(2000);
			
	//VAT:
				dclick("//td[@class='overflow_handsontable select_icon current highlight']");
				Thread.sleep(1000);
				dclick("//input[@class='select2-input select2-focused']");
				clear("//input[@class='select2-input select2-focused']");
				Thread.sleep(3000);
				type("//input[@class='select2-input select2-focused']","5");
				Thread.sleep(1000);
				click("(//div[@class='select2-result-label'])[3]");
				Thread.sleep(2000);
				
	//Nominal code:
				
				dclick("//td[@class='overflow_handsontable select_icon afterHiddenColumn htPlaceholder current highlight']");
				Thread.sleep(2000);
				type("//input[@class='select2-input select2-focused']","part");
				Thread.sleep(1000);
				click("(//div[@class='select2-result-label'])[1]");
				Thread.sleep(2000);
				
	//Add supplier button
				
				click("//span[text()='Add supplier invoice']");
				
	
				
	}
	@Test(priority = 3)
	public void Edit_Supplierinvoice() throws InterruptedException
	{
		
	//Edit Supplier invoice:
		
		Thread.sleep(2000);
		click("//span[text()='Edit']");
		Thread.sleep(1000);
		type(" //input [@class='ng-pristine ng-valid ng-valid-required ng-valid-check-exists']", "15PO1");
		Thread.sleep(1000);
		click("(//span[text()='Save'])[1]");
		
	}
	@Test(priority = 4)
	public void Delete_Supplierinvoice() throws InterruptedException
	{
		
	//Delete Supplier invoice:
		
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