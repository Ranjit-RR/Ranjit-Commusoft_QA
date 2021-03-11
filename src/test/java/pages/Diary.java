package pages;

import org.openqa.selenium.WebDriver;

import action.Wrapper;

public class Diary extends Wrapper {
	public Diary(WebDriver ldriver)
	{
		this.driver = ldriver;
	}
	public void Diary_Daily()
	{
		try
		{
		click("//button[text()='Daily']");
		}catch(Exception e)
		{
			
		}
		
	}
	public void Diary_Today() throws InterruptedException
	{
		Thread.sleep(3000);
		try {
			click("//a[text()='Today']");
			Thread.sleep(3000);
			click("(//div[@class='fc-row fc-week fc-widget-content'])[2]");
		}catch(Exception e)
		{
			Thread.sleep(3000);
			click("(//a[@class='icon ss-navigateright'])[1]");
			Thread.sleep(3000);
			click("(//div[@class='fc-row fc-week fc-widget-content'])[2]");
		}
	}
	public void Diary_EventFromJob() throws InterruptedException
	{
		click("//button[@ng-click='saveDiaryEvent()']");
	}

}
