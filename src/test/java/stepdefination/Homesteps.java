package stepdefination;



import org.testng.Assert;

import anz.Pages.HomeloanPage;
import anz.QA.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class Homesteps {
	
	String Your_annual_income_before_tax;
	String Your_annual_other_income_optional_Tooltip;
	String Monthly_living_expenses_Tooltip;
	String Current_home_loan_monthly_repayments_Tooltip;
	String Othe_loan_monthly_repayments_Tooltip;
	String Other_monthly_commitments;
	String Total_credit_card_limits;
	String Monthly_living_expenses;
	
	
     private HomeloanPage homeloan = new HomeloanPage(DriverFactory.getDriver());
	
	@Given("open the homeloan calculator URL {string}")
	public void open_the_homeloan_calculator_url(String string) {
		
		DriverFactory.getDriver().get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
	    
	}

	@When("User upadte the Application type as {string} dependency as {string} buying property as {string}")
	public void user_upadte_the_application_type_as_dependency_as_buying_property_as(String string, String string2, String string3) {
	    
		
		homeloan.userInput1();
		
	}

	@When("Enter the annual income as {string} and annual othe income as {string}")
	public void enter_the_annual_income_as_and_annual_othe_income_as(String Your_annual_income_before_tax, String Your_annual_other_income_optional_Tooltip) {
	    this.Your_annual_income_before_tax=Your_annual_income_before_tax;
	    this.Your_annual_other_income_optional_Tooltip=Your_annual_other_income_optional_Tooltip;
		homeloan.userInput2(Your_annual_income_before_tax,Your_annual_other_income_optional_Tooltip);
	}

	@When("update Monthly living expenses as {string} and home loan monthly repayments as {string} and other loan repayments as {string}")
	public void update_monthly_living_expenses_as_and_home_loan_monthly_repayments_as_and_other_loan_repayments_as(String Monthly_living_expenses_Tooltip, String Current_home_loan_monthly_repayments_Tooltip, String Othe_loan_monthly_repayments_Tooltip) {
		
		this.Monthly_living_expenses_Tooltip=Monthly_living_expenses_Tooltip;
		this.Current_home_loan_monthly_repayments_Tooltip=Current_home_loan_monthly_repayments_Tooltip;
		this.Othe_loan_monthly_repayments_Tooltip=Othe_loan_monthly_repayments_Tooltip;
		
		homeloan.userInput3(Monthly_living_expenses_Tooltip,Current_home_loan_monthly_repayments_Tooltip,Othe_loan_monthly_repayments_Tooltip);
		
		
	}

	@When("select other commitments as {string} and total credit card limits {string}")
	public void select_other_commitments_as_and_total_credit_card_limits(String Other_monthly_commitments, String Total_credit_card_limits) {
	   homeloan.userInput4(Other_monthly_commitments,Total_credit_card_limits);
	}

	@When("click on the work out how much I could borrow")
	public void click_on_the_work_out_how_much_i_could_borrow() {
		
		homeloan.userInput5();
	    
	}

	@Then("Amount should be generated as {string}")
	public void amount_should_be_generated_as(String string) {
		String expectedValue="$479,000";
		
		String ActualValue=homeloan.valueCheck();
		
//		Assert.assertEquals(ActualValue,expectedValue," ");
		
		Assert.assertTrue(ActualValue.contains(expectedValue),  "");
		
//		if(expectedValue.equalsIgnoreCase(ActualValue)) {
//			System.out.println("Value is matched");
//			
//		}
//		else {
//			
//			System.out.println("Value is not matching");
//		}
	   
	}
	
	@When("update Monthly_living_expenses as {string}")
	public void update_monthly_living_expenses_as(String Monthly_living_expenses) {
		this.Monthly_living_expenses=Monthly_living_expenses;
		homeloan.expensecheck(Monthly_living_expenses);
	}
		
	@Then("error message should be matched")
	public void error_message_should_be_matched() {

		String extepectedError= "Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641";
		String actualError=homeloan.errorCheck();
		
//       Assert.assertEquals(actualError, extepectedError, "Test case is passed");
       
       
		Assert.assertTrue(actualError.contains(extepectedError), " ");
		
//		if(extepectedError.equals(actualError)) {
//			System.out.println("Error message is matching " +
//					"\n Error message is :\n " +actualError);
//			
//		}
//		else {
//			
//			System.out.println("Error message is not matching  " +
//					"\n Error message is :\n " +actualError);
//		}
//		
		
	}

	@When("click on the StartOver button")
	public void click_on_the_start_over_button() {
		homeloan.refresh();
	}

	@Then("All the fields should be clear")
	public void all_the_fields_should_be_clear() {
	    
		String Annincome=homeloan.clearDataCheck();
		System.out.println("After Refresgh : " +   Annincome);
//		Assert.assertEquals(" ", Annincome);
		
	}


}
