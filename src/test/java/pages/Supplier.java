package pages;

import org.openqa.selenium.WebDriver;

import action.Wrapper;

public class Supplier extends Wrapper{
	
	public Supplier(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	public void Supplier() throws InterruptedException
	{
		click("//a[text()=\"Suppliers\"]");
		click("//a[text()=\"New supplier \"]");
		Thread.sleep(2000);
		type("//input[@id=\"suppliertype_contacts_companyname\"]", "Supplier");
		type("//input[@id=\"suppliertype_addressline1\"]", "Address1");
		click("//button[@id=\"company-details-save\"]");
		Thread.sleep(2000);
	}
	public void Add_Supplier_PO()
	{
		click("//a[text()=\"Add new purchase order\"]");
	}

}
