package step_definitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Pages.LogInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilites.BrowserUtils;
import utilites.DataReader;
import utilites.Driver;

public class UserManagmentSteps {
	

    LogInPage loginpage = new LogInPage();
    BrowserUtils utils = new BrowserUtils();  
    //valid login scenario
	@Given("As a user, I am on the login page")
	public void as_a_user_i_am_on_the_login_page() {
	  Driver.getDriver().get(DataReader.getProperty("appUrl")); 
	}
	@When("I enter a valid username and valid password")
	public void i_enter_a_valid_username_and_valid_password() {
		utils.actionsSendKeys(loginpage.emailField, DataReader.getProperty("username"));
		utils.actionsSendKeys(loginpage.passwordField,DataReader.getProperty("password"));
	 // loginpage.emailField.sendKeys(DataReader.getProperty("username"));
	 // loginpage.passwordField.sendKeys(DataReader.getProperty("password")); 
	}

   @When("I click on login button")
    public void i_click_on_login_button() {
	    loginpage.loginBtn.click();
	}
   @Then("I should be on user profile page")
   public void i_should_be_on_user_profile_page() {
		Assert.assertTrue(loginpage.accountSettingsHeader.isDisplayed());
		
	    
	}
   // invalid scenario step 
   @When("I enter a invalid username and valid password")
   public void i_enter_a_invalid_username_and_valid_password() {
	  utils.actionsSendKeys(loginpage.emailField, "invalid@primetech.com");
	  utils.actionsSendKeys(loginpage.passwordField, DataReader.getProperty("password"));
   }
   @Then("I should see an error message")
   public void i_should_see_an_error_message() {
	   utils.waitUntilElementVisible(loginpage.invalidloginerrorMessage);
       Assert.assertTrue(loginpage.invalidloginerrorMessage.isDisplayed());
   }
   @Then("I should not be logged in")
   public void i_should_not_be_logged_in() {
      Assert.assertTrue(loginpage.emailField.isDisplayed());;
      
   }
   //invalid password login steps
   @When("I enter a vaid username and invalid password")
   public void i_enter_a_vaid_username_and_invalid_password() {
	   utils.actionsSendKeys(loginpage.emailField, DataReader.getProperty("username"));
	   utils.actionsSendKeys(loginpage.passwordField,"HelloWorld123");
   }


//invalid username and invalid password
   
   @When("I enter invalid username and invalid password")
   public void i_enter_invalid_username_and_invalid_password() {
	   utils.actionsSendKeys(loginpage.emailField, "invalid@primetech.com");
		utils.actionsSendKeys(loginpage.passwordField,"HelloWorld123");
	   
   }
   // create An Item Or Service
   @Given("I navigate to the Items tab")
   public void i_navigate_to_the_items_tab() {
	   utils.waitUntilElementVisible(loginpage.itemTab);
	   loginpage.itemTab.click();
	  
	   
      
   }
   @When("I click on the add Item button")
   public void i_click_on_the_add_item_button() {
	   utils.waitUntilElementVisible(loginpage.addItemButton);
	   loginpage.addItemButton.click();
   }
   @When("I should be on the item input page")
   public void i_should_be_on_the_item_input_page() {
	   Assert.assertTrue(loginpage.addItemButton.isDisplayed());;
   }
   @When("I provide item information name {string}, price {string}, unit {string}, and description {string}")
   public void i_provide_item_information_name_price_unit_and_description(String string, String string2, String string3, String string4) {
	   utils.actionsSendKeys(loginpage.nameField, DataReader.getProperty("name"));
		utils.actionsSendKeys(loginpage.priceField,DataReader.getProperty("price"));
		utils.actionsSendKeys(loginpage.unitField, DataReader.getProperty("unit"));
		utils.actionsSendKeys(loginpage.descriptionField,DataReader.getProperty("discription"));
   }
   @When("I click save Item button")
   public void i_click_save_item_button() {
	   loginpage.saveitembutton.click();
       
   }
   @Then("The Item is added to the Item list table")
   public void the_item_is_added_to_the_item_list_table() {
	   loginpage.itemlisttable.click();
      
   }
   
   @When("I navigate to Items tab")
   public void i_navigate_to_items_tab() {
	   loginpage.itemTab.click();
   }
   @When("I select the Item {name}")
   public void i_select_the_item(String string) {
	   utils.actionsSendKeys(loginpage.emailField, DataReader.getProperty("username"));
	   WebElement itemListTable = Driver.getDriver().findElement(By.xpath("//table[@id='itemListTable']"));
       List<WebElement> rows = itemListTable.findElements(By.tagName("tr"));
       for (WebElement row : rows) {
           List<WebElement> cells = row.findElements(By.tagName("td"));
           if (cells.size() >= 1 && cells.get(0).getText().equals("name")) {
               WebElement editButton = row.findElement(By.xpath("//button[@class='btn btn-sm btn-info']"));
               editButton.click();
               break;
           }
       }
   }
   @When("I should be on Item details page")
   public void i_should_be_on_item_details_page() {
      Assert.assertTrue(loginpage.itemdetailspage.isDisplayed());
   }
   @When("I update the Item price to {int} dollars")
   public void i_update_the_item_price_to_dollars(Integer int1) {
	   WebElement priceInput = loginpage.priceField;
       priceInput.clear();
       char[] newPrice = null;
	priceInput.sendKeys(String.valueOf(newPrice));
   }
   @When("I click update Item button")
   public void i_click_update_item_button() {
      loginpage.updateitembutton.click();
   }
   @Then("The Item price is updated to {int} dollars")
   public void the_item_price_is_updated_to_dollars(Integer int1) {
   
	   
   }


}
