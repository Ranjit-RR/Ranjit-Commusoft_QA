package testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import action.Baseclass;
import pages.CreateJob;
import pages.Customer;
import pages.LoginPage;
import pages.Supplier;
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
	@Test(priority=2)
	public void test() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.get(homepage);
		Supplier supplier = new Supplier(driver);
		supplier.Supplier();
		supplier.Add_Supplier_PO();
		searchengine search = new searchengine(driver);
		search.searchbox_supplier_parts("Parts");
		search.searchbox_supplier_parts_nominalcode("Parts");
		search.parts_deliverymethod("Delivery to office");
		search.supplierpo_items("Item");
		CreateJob job = new CreateJob(driver);
		job.PO_item_unitprice("100");
		job.PO_item_saleprice("200");
		search.searchbox_supplier_item_nominalcode("Parts");
		job.save_po();
		CreateJob Job = new CreateJob(driver);
		Job.supplier_edit_po();
		Job.PO_part_unitprice_eidt("600");
		searchengine searchvat = new searchengine(driver);
		searchvat.searchboxsupplieredit_partVAT("15.00");
		Job.Supplier_PO_itemprice_eidt("200");
		searchvat.searchboxsupplieredit_itemVAT("15.00");
		Job.save_po();
		/* Assertion */
		Job.assert_Supplierparttoal();
		Job.assert_Supplieritem_total();
		Job.assert_Suppliersubtotal();
		Job.assert_Suppliervat();
		Job.assert_suppliereditgrand();


		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
