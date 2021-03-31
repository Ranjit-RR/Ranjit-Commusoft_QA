package testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import action.Baseclass;
import pages.LoginPage;
import pages.Customer;
import pages.CreateJob;
import pages.searchengine;

public class Karna_UnitTest extends Baseclass {
	
String homepage;
	
	@Test(priority = 0)
	public void login() throws InterruptedException
	{
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(sheet.sheetIN("Login",0, 1),sheet.sheetIN("Login",1, 1),sheet.sheetIN("Login", 2, 1));
		Thread.sleep(1000);
		homepage = driver.getCurrentUrl();
	}
	@Test(priority = 1)
	public void PO() throws InterruptedException
	{
		Customer customer = new Customer(driver);
		customer.Add_Customer();
		Thread.sleep(5000);
		 // get the code from Customer page using driver inside the Wrapper
		Thread.sleep(2000);
		CreateJob Job = new CreateJob(driver);
		Job.addjob(); // get the code from CreateJob page using the object job
		Job.JobDescription("No Rules");// get the code from CreateJob page using the object job
		Job.createjob();// get the code from CreateJob page using the object job
		Thread.sleep(7000);
		Job.JobCost();
		Job.JobCostPO();
		searchengine search = new searchengine(driver);
		Thread.sleep(3000);
		search.searchbox_supplier("supplier");
		search.searchbox_supplier_parts("Parts1");
		search.searchbox_supplier_parts_nominalcode("Part");
		search.parts_deliverymethod("Delivery to Office");
		search.supplierpo_items("Item");
		Job.PO_item_unitprice("100");
		Job.PO_item_saleprice("200");
		search.searchbox_supplier_item_nominalcode("Parts");
		Job.Add_PO_button();	
	}
	@Test (priority = 2)
	public void PO_Value_Validation() throws InterruptedException 
	{
		//PO(); //call the method inside the current class
		Thread.sleep(3000);
		CreateJob job = new CreateJob(driver);
		job.view_po();
		
		/*ASSERTION for the total values*/
		
		String part_total = gettext("(//span[@class=\"ng-binding\"])[16]");//part total
		part_total = part_total.replace("£", "");
		String Expectedparttotal= "300.00";
		Assertion(part_total, Expectedparttotal,"Wrong part total");
		
		String item_total = gettext("(//span[@class=\"ng-binding\"])[23]");//item total
		item_total = item_total.replace("£", "");
		String Expecteditemtotal= "100.00";
		Assertion(item_total, Expecteditemtotal,"Wrong item total");
		
		String sub_total = gettext("(//span[@class=\"ng-binding\"])[24]");//sub total
		sub_total = sub_total.replace("£", "");
		String Expectedsubtotal= "400.00";
		Assertion(sub_total, Expectedsubtotal,"Wrong sub total");
		
		
		String VAT = gettext("(//span[@class=\"ng-binding\"])[25]");//VAT
		VAT = VAT.replace("£", "");
		String ExpectedVATpart= "80.00";
		Assertion(VAT,ExpectedVATpart,"Wrong VAT value");
		
		String Grandtotal = gettext("(//span[@class=\"ng-binding\"])[26]");//Grand total
		Grandtotal = Grandtotal.replace("£", "");
		String ExpectedGrandtotal= "480.00";
		Assertion(Grandtotal,ExpectedGrandtotal,"Wrong Grandtotal value");
	} 
	@Test (priority = 3)
	public void PO_Edit_Value_Validation() throws InterruptedException
	{
		Thread.sleep(3000);
		//driver.get("https://stage2.commusoft.net/customers/customer/1132/jobs/1258/costs/purchase_order/56/details");
		//driver.get("https://dev.commusoft.net/customers/customer/1073/jobs/420/costs/purchase_order/75/details");
		CreateJob Job = new CreateJob(driver);
		Job.edit_po();
		Job.PO_part_unitprice_eidt("600");
		searchengine searchvat = new searchengine(driver);
		searchvat.searchboxedit_supplier_partVAT("15.00");
		Job.PO_part_itemprice_eidt("200");
		searchvat.searchboxedit_supplier_itemVAT("15.00");
		Job.save_po();
		
     /*ASSERTION for the total values*/
		
		String part_total = gettext("(//span[@class=\"ng-binding\"])[16]");//part total
		part_total = part_total.replace("£", "");
		String Expectedparttotal= "600.00";
		Assertion(part_total, Expectedparttotal,"Wrong part total");
		
		String item_total = gettext("(//span[@class=\"ng-binding\"])[23]");//item total
		item_total = item_total.replace("£", "");
		String Expecteditemtotal= "200.00";
		Assertion(item_total, Expecteditemtotal,"Wrong item total");
		
		String sub_total = gettext("(//span[@class=\"ng-binding\"])[24]");//sub total
		sub_total = sub_total.replace("£", "");
		String Expectedsubtotal= "800.00";
		Assertion(sub_total, Expectedsubtotal,"Wrong sub total");
		
		
		String VAT = gettext("(//span[@class=\"ng-binding\"])[25]");//VAT
		VAT = VAT.replace("£", "");
		String ExpectedVATpart= "120.00";
		Assertion(VAT,ExpectedVATpart,"Wrong VAT value");
		
		String Grandtotal = gettext("(//span[@class=\"ng-binding\"])[26]");//Grand total
		Grandtotal = Grandtotal.replace("£", "");
		String ExpectedGrandtotal= "920.00";
		Assertion(Grandtotal,ExpectedGrandtotal,"Wrong Grandtotal value");	
	}
	@Test(priority = 4)
	public void PO_Invoice_Lintitem_invoice() throws InterruptedException
	{
		Thread.sleep(3000);
		//driver.get("https://dev.commusoft.net/customers/customer/1069/jobs/416/costs/purchase_order/74/details");
		
		CreateJob Job = new CreateJob(driver);
		Job.invoice_withlineitem();
		
		/* Assertion */
		String Total_in = gettext("(//div[@class=\"total-value\"])[1]");
		Total_in = Total_in.replace("£", "");
		String Expectedintotal= "806.00";
		Assertion(Total_in, Expectedintotal,"Wrong invoice total");
		
		String Total_vat = gettext("(//div[@class=\"total-value\"])[2]");
		Total_vat = Total_vat.replace("£", "");
		String Expectedvattotal= "161.20";
		Assertion(Total_vat, Expectedvattotal,"Wrong vat total");
		
		String Total_grand = gettext("(//div[@class=\"total-value\"])[3]");
		Total_grand = Total_grand.replace("£", "");
		String Expectedgrandtotal= "967.20";
		Assertion(Total_grand, Expectedgrandtotal,"Wrong grand total");
		
		Job.save_invocie();
		
		String Finalvalue = gettext("(//div[@class=\"total-value\"])[3]");
		Finalvalue = Finalvalue.replace("£", "");
		String ExpectedFinalvalue= "967.20";
		Assertion(Finalvalue, ExpectedFinalvalue,"Wrong Final total");
		
	}

	
}
