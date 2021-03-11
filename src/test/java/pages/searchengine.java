package pages;
import org.openqa.selenium.WebDriver;

import action.Wrapper;

public class searchengine extends Wrapper {
	
	public searchengine(WebDriver ldriver)
	{
		this.driver =ldriver;
	}
	
	public void searchbox(String name)
	{
		click("(//span[@class='select2-chosen'])[3]");
		type("//input[@class='select2-input select2-focused']", name);  //input[@class="select2-input select2-focused"]
		click("//span[@class='select2-match']");
	}
	public void searchbox_jobDescription(String name)
	{
		click("(//span[@class='select2-chosen'])[3]");
		type("//input[@class='select2-input select2-focused']", name);  //input[@class="select2-input select2-focused"]
		click("//span[@class='select2-match']");
	}

}
