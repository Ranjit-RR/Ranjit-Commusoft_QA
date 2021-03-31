package pages;

import org.openqa.selenium.WebDriver;

import action.Wrapper;

public class Customer extends Wrapper {
	
	public Customer(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	public void Customer_create()
	{
		click("#customertypecustomer");
	}
	public void Customer_title()
	{
		selectdropdown("#customertype_contacts_settingsTitlesid", "Mr");
	}
	public void Customer_Name()
	{
		type("#customertype_contacts_name", "Ranjit");
	}
	public void Customer_SurName()
	{
		type("#customertype_contacts_surname", "Aravind");
	}
	public void Customer_Mobile()
	{
		type("#customertype_contacts_contactstelephone_0_telephonenumber", "8965326589");
	}
	public void Customer_email()
	{
		type("#customertype_contacts_contactsemail_emailaddress", "ranjit@commusoft.com");
	}
	public void Customer_AddressLine1()
	{
		type("#customertype_addressline1", "Madurai");
	}
	public void Customer_Save()
	{
		click("//button[@type='submit']");
	}
	public void workaddress_tab()
	{
		click("#workAddressTab");
	}
	public void workaddress_addnewWorkaddress()
	{
		click("#addNewBranch");
	}
	public void Workaddress_create() throws InterruptedException
	{
		type("#workaddress_contacts_name","Work Address Ranjit");
		
		type("#workaddress_contacts_surname","Aravind");
		
		type("#workaddress_contacts_contactstelephone_0_telephonenumber","9865326598");
		
		type("#workaddress_contacts_contactstelephone_1_telephonenumber","2530178");
		
		type("#workaddress_contacts_contactsemail_emailaddress","ranjittestinfgun@yopmail.com");
		
		type("#workaddress_addressline1","Madurai JILLA");
		click("//span[@ng-hide='saving']");
		Thread.sleep(9000);
	}
	
	/*K*/
	
	public void Add_Customer() throws InterruptedException
	{
		Customer_create();
		Customer_title();
		Customer_Name();
		Customer_SurName();
		Customer_Mobile();
		Customer_email();
		Customer_AddressLine1();
		Customer_Save();
		Thread.sleep(25000);
		
	}
	
	
	
}
