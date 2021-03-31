package pages;

import org.openqa.selenium.WebDriver;

import action.Wrapper;

public class CreateJob extends Wrapper {
	
	public CreateJob(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	public void addjob() throws InterruptedException
	{
		click("//a[@id='newJob']");
		Thread.sleep(1000);
	}
	public void JobDescription(String a) throws InterruptedException
	{
		searchengine search = new searchengine(driver);
		search.searchbox_jobDescription(a);
		Thread.sleep(3000);
	}
	public void createjob()
	{
		click("//span[text()='Add job']");
	}
	public void jobdetail()
	{
		click("(//a[text()='Details'])[2]");
	}
	public void edit_job() throws InterruptedException
	{
		click("(//a[text()='Edit'])[1]");
		Thread.sleep(1000);
	}
	public void complete_job() throws InterruptedException
	{
		click("//input[@formcontrolname='completed']");
		Thread.sleep(3000);
		click("(//span[text()='Save'])[2]");
	}
	public void Add_new_diaryEvent()
	{
		click("//span[text()='Add new diary event']");
	}
	/*k*/
	public void JobCost()
	{
		click("//span[text()='Costs']");
	}
	public void JobCostPO()
	{
		click("(//a[@class=\"btn btn-primary btn-small ng-scope\"])[3]");//Click PO
	}
	public void PO_item_unitprice(String Focus, String Edit, String amount)
	{
		dclick(Focus);
		clear(Edit);
		type(Edit, amount);
		typeenter(Edit);		
	}
	public void Add_PO_button()
	{
		click("(//span[@class=\"ng-scope\"])[15]");
	}

}

