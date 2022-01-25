package anz.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomeloanPage {
	
	
	private WebDriver driver;
	
	//1. OR
	
	private By applicationtype=By.xpath("//label[@for='application_type_single']");
	private By Property=By.xpath("//label[@for='borrow_type_home']");
	private By AnnualIncome=By.xpath("//input[@aria-labelledby='q2q1']");
	private By AnnualIncomeoptiona=By.xpath("//input[@aria-labelledby='q2q2']");
	private By Monthlylivingexpences=By.xpath("//input[@id='expenses']");
	private By HomeloanMonthlyrepayment=By.xpath("//input[@id='homeloans']");
	private By OtherLoan=By.xpath("//input[@id='otherloans'][@aria-describedby='q3q3i1 q3q3i2']");
	private By Othermonthlycommitments=By.xpath("//input[@id='otherloans'][@aria-describedby='q3q4i1 q3q4i2']");
	private By credit=By.xpath("//input[@id='credit']");
	private By  youcouldborrow=By.xpath("//button[@id='btnBorrowCalculater']");
	private By  valueCheck=By.xpath("//span[@id='borrowResultTextAmount']");
	private By  errorcheckmsg=By.xpath("//div[@class=\"borrow__error__text\"]");
	
	
	//2.constructor of the page class
	
	public HomeloanPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3.page actions
	
	public void urlLink() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
		driver.manage().window().maximize();
		
	}
	
	public void userInput1() {
		
		driver.findElement(applicationtype).click();
		driver.findElement(Property).click();
		
		
	}
	public void userInput2() {
		driver.findElement(AnnualIncome).clear();
		driver.findElement(AnnualIncome).sendKeys("$80000");
		driver.findElement(AnnualIncomeoptiona).clear();
		driver.findElement(AnnualIncomeoptiona).sendKeys("$10000");
		
	}
	
	public void userInput3() {
		driver.findElement(Monthlylivingexpences).clear();
		driver.findElement(Monthlylivingexpences).sendKeys("$500");
		driver.findElement(HomeloanMonthlyrepayment).clear();
		driver.findElement(HomeloanMonthlyrepayment).sendKeys("0");
		driver.findElement(OtherLoan).clear();
		driver.findElement(OtherLoan).sendKeys("$100");
	}
	
	public void userInput4() {
		driver.findElement(Othermonthlycommitments).clear();
		driver.findElement(Othermonthlycommitments).sendKeys("0");
		driver.findElement(credit).clear();
		driver.findElement(credit).sendKeys("$10000");
		
	}
	
	public void userInput5() {
	
	driver.findElement(youcouldborrow).click();	
	}
	
	public String valueCheck() {
		WebElement element=driver.findElement(valueCheck);
		String value=element.getText();
		return value;
	}
	
	public void expensecheck() {
		
		driver.findElement(Monthlylivingexpences).sendKeys("1");
	}
	
public String errorCheck() {
		
		 WebElement element=driver.findElement(errorcheckmsg);
		 String error=element.getText();
		 return error;
	}
	
	
	
}
