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
	public void PO_item_unitprice( String amount)
	{
		dclick("(//td[@class=\"overflow_handsontable\"])[2]");
		clear("(//textarea[@class=\"handsontableInput\"])[4]");
		type("(//textarea[@class=\"handsontableInput\"])[4]", amount);
		typeenter("(//textarea[@class=\"handsontableInput\"])[4]");		
	}
	public void PO_item_unitprice_value()
	{
		dclick("(//td[@class=\"overflow_handsontable\"])[2]");
		clear("(//textarea[@class=\"handsontableInput\"])[4]");
		type("(//textarea[@class=\"handsontableInput\"])[4]", "500");
		typeenter("(//textarea[@class=\"handsontableInput\"])[4]");		
	}
	public void PO_item_saleprice( String amount)
	{
		dclick("//td[@class=\"overflow_handsontable current highlight\"]");
		clear("//*[@id=\"job_item_new_purchase_order\"]/div[6]/textarea");
		type("//*[@id=\"job_item_new_purchase_order\"]/div[6]/textarea", amount);
		typeenter("//*[@id=\"job_item_new_purchase_order\"]/div[6]/textarea");		
	}
	public void PO_part_unitprice_eidt( String amount)
	{
		dclick("//*[@id=\"part_edit_purchase_order\"]/div[1]/div/div/div/table/tbody/tr/td[4]");
		clear("//textarea[@class=\"handsontableInput\"]");
		type("//textarea[@class=\"handsontableInput\"]", amount);
		typeenter("//textarea[@class=\"handsontableInput\"]");		
	}
	public void PO_part_itemprice_eidt( String amount)
	{
		dclick("(//td[@class=\"overflow_handsontable\"])[2]");
		clear("(//textarea[@class=\"handsontableInput\"])[2]");
		type("(//textarea[@class=\"handsontableInput\"])[2]", amount);
		typeenter("(//textarea[@class=\"handsontableInput\"])[2]");		
	}
	public void Add_PO_button()
	{
		click("(//span[@class=\"ng-scope\"])[15]");
	}
	public void view_po()
	{
		click("(//a[@class=\"ng-scope\"])[27]");
	}
	public void edit_po()
	{
		click("(//span[@class=\"ng-scope\"])[26]");
	}
	public void save_po()
	{
		click("//span[@ng-hide=\"saving\"]");
	}
	public void invoice_withlineitem()
	{
		click("(//span[@class=\"ng-scope\"])[16]");//click invoice tab
		click("//a[@class=\"btn btn-primary btn-small ng-scope\"]");// click add invoice
		click("(//span[@class=\"help-block\"])[1]");//copy from job
		selectdropdownindex("//select[@class=\"full-width-select ng-untouched ng-pristine ng-invalid\"]", 1);//invoice category
		click("//a[@class=\"without-margin\"]");// lineitem
		click("(//input[@class=\"inline-checkbox ng-untouched ng-pristine ng-valid\"])[1]");//click part checkbox
		isenabled("//a[@id=\"save-panel-btn\"]");//save and add line items
		click("(//input[@class=\"inline-checkbox ng-untouched ng-pristine ng-valid\"])[1]");//click labour checkbox
		click("//a[@id=\"save-panel-btn\"]");//save invoice
	}
	public void save_invocie()
	{
		click("//button[@class=\"btn btn-primary loading_btn save_btn\"]");// save button
	}

}

