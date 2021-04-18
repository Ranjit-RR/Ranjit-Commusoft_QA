package pages;

import org.openqa.selenium.WebDriver;

import action.Wrapper;

public class Reporting extends Wrapper {
	
	public Reporting(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	public void Reporttab() throws InterruptedException
	{
		Thread.sleep(6000);
		click("//a[@class=\"trigger-dropdown ng-scope\"]"); //report tab
		Thread.sleep(3000);	
	}
	public void Report_Sidemenu() throws InterruptedException
	{
		Thread.sleep(5000);
		click("//a[@id=\"side-bar\"]"); //side menu
		Thread.sleep(3000);
	}
	public void Customer_Report() throws InterruptedException
	{
		click("//a[@has-root-permission=\"customerReports\"]"); //click customer report
		Thread.sleep(3000);
	}
	public void Customers_Report() throws InterruptedException
	{
		click("(//a[@has-permission=\"Basiccustomerreports,readaccess\"])[1]"); //click first customer report
		Thread.sleep(3000);
	}
	public void First_Plus_button() throws InterruptedException
	{
		click("(//span[@class=\"preview-file-link actions-toggle ng-scope ss-plus\"])[1]"); //click first + button
		Thread.sleep(3000);
	}
	public void Customer1_Assertion(String ER)
	{
		String AR = gettext("(//a[@ng-show=\"canDisplayMenu(category, 'customerIds', $index)\"])[1]");
		Assertion(ER, AR, "Customer report all visible");
	}
	/*---------------------------------------------------------------------------------------------------------*/
	public void WA_Report() throws InterruptedException
	{
		click("(//a[@has-permission=\"Basiccustomerreports,readaccess\"])[2]"); //click 2nd customer report
		Thread.sleep(3000);
	}
	public void Customer2_Assertion(String ER)
	{
		String AR = gettext("(//a[@ng-show=\"canDisplayMenu(category, 'workaddressIds', $index)\"])[1]");
		Assertion(ER, AR, "Customer2 report all visible");
	}
	/*---------------------------------------------------------------------------------------------------------*/
	public void Appliance_Details_Report() throws InterruptedException
	{
		click("(//a[@has-permission=\"Basiccustomerreports,readaccess\"])[3]"); //click 3rd customer report
		Thread.sleep(4000);
	}
	public void Customer3_Assertion()
	{
		try 
		{
			isdisplayed("//span[@data-row-index=\"0\" and @data-column=\"Customer.Account.Number\"]");//check the first row customer accoutn number present or not
		}
		catch (Exception e)
		{
			String a=gettext("(//div[@class=\"warning-message ng-binding\" and @ng-bind-html=\"message\" and contains(text(),'No records found')])[1]");
			String b="No records found";
			Assertion(b, a, "No records found - Assertion failed");
		}
	}
	public void Advertising_Performance_Report() throws InterruptedException
	{
		click("(//a[@has-permission=\"Basiccustomerreports,readaccess\"])[4]"); //click 3rd customer report
		Thread.sleep(4000);
	}
	public void Customer4_Assertion()
	{
		try 
		{
			isdisplayed("//span[@data-row-index=\"0\" and @data-column=\"No Jobs Created\"]");//check the first row job number present or not
		}
		catch (Exception e)
		{
			String a=gettext("(//div[@class=\"warning-message ng-binding\" and @ng-bind-html=\"message\" and contains(text(),'No records found')])[1]");
			String b="No records found";
			Assertion(b, a, "No records found - Assertion failed");
		}
	}
	/*---------------------------------------------------------------------------------------------------------*/
	public void JobEstimateAccessPhoneCallList_Report() throws InterruptedException
	{
		click("(//a[@has-permission=\"Basiccustomerreports,readaccess\"])[5]"); //click 3rd customer report
		Thread.sleep(3000);
	}
	public void Customer5_Assertion()
	{
		try 
		{
			String v="//span[@data-column=\"Status\" and @data-row-index=\"0\"]";
			isdisplayed(v);
		}
		catch (Exception e)
		{
			String a=gettext("(//div[@class=\"warning-message ng-binding\" and @ng-bind-html=\"message\" and contains(text(),'No records found')])[1]");
			String b="No records found";
			Assertion(b, a, "No records found - Assertion failed");
		}
	}
	/*---------------------------------------------------------------------------------------------------------*/
	public void ServicePlan_Report() throws InterruptedException
	{
		click("(//a[@has-permission=\"Basiccustomerreports,readaccess\"])[6]"); //click 3rd customer report
		Thread.sleep(3000);
	}
	public void Customer6_Assertion()
	{
		try 
		{
			isdisplayed("//span[@data-column=\"Customer address line 1\" and @data-row-index=\"0\"]");
		}
		catch (Exception e)
		{
			String a=gettext("(//div[@class=\"warning-message ng-binding\" and @ng-bind-html=\"message\" and contains(text(),'No records found')])[1]");
			String b="No records found";
			Assertion(b, a, "No records found - Assertion failed");
		}
	}
	/*---------------------------------------------------------------------------------------------------------*/
	public void Asset_Report() throws InterruptedException
	{
		click("(//a[@has-permission=\"customerAsset,readaccess\"])"); //click 3rd customer report
		Thread.sleep(3000);
	}
	public void Customer7_Assertion()
	{
		try 
		{
			isdisplayed("//span[@data-column=\"Customer name\" and @data-row-index=\"0\"]");
		}
		catch (Exception e)
		{
			String a=gettext("(//div[@class=\"warning-message ng-binding\" and @ng-bind-html=\"message\" and contains(text(),'No records found')])[1]");
			String b="No records found";
			Assertion(b, a, "No records found - Assertion failed");
		}
	}
	/*---------------------------------------------------------------------------------------------------------*/
	public void Contracts_Report() throws InterruptedException
	{
		click("(//a[@has-permission=\"ViewContractReport,readaccess\"])[1]"); //click 3rd customer report
		Thread.sleep(3000);
	}
	public void Customer8_Assertion()
	{
		try 
		{
			isdisplayed("//span[@data-column=\"Customer.name\" and @data-row-index=\"0\"]");
		}
		catch (Exception e)
		{
			String a=gettext("(//div[@class=\"warning-message ng-binding\" and @ng-bind-html=\"message\" and contains(text(),'No records found')])[1]");
			String b="No records found";
			Assertion(b, a, "No records found - Assertion failed");
		}
	}
	/*---------------------------------------------------------------------------------------------------------*/	
	public void PPM_Report() throws InterruptedException
	{
		click("(//a[@has-permission=\"ViewContractReport,readaccess\"])[2]"); //click 3rd customer report
		Thread.sleep(3000);
	}
	public void Customer9_Assertion()
	{
		try 
		{
			isdisplayed("//th[@data-column-index=\"2\" and contains (text(), 'Number of jobs planned')]");
		}
		catch (Exception e)
		{
			String a=gettext("(//div[@class=\"warning-message ng-binding\" and @ng-bind-html=\"message\" and contains(text(),'No records found')])[1]");
			String b="No records found";
			Assertion(b, a, "No records found - Assertion failed");
		}
	}
	
	
	
	
	
	
	
	

}
