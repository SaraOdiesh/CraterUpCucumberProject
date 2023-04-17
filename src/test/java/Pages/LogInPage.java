package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilites.Driver;

public class LogInPage {
	 String itemName = null;
	public LogInPage() {
		
		PageFactory.initElements(Driver.getDriver(),this);
	}
		
		@FindBy (name = "email")
		public WebElement emailField;
		
		@FindBy (name ="password")
		public WebElement passwordField;
		
		@FindBy (xpath = "//button[@type ='submit']")
		public WebElement loginBtn;
		
		@FindBy (xpath = "//header/a[1]/*[1]")
		public WebElement accountSettingsHeader;
		
		@FindBy (xpath = "//p[contains(text(),'Error')]")
		public WebElement invalidloginerrorMessage;
		
		@FindBy (xpath = "//a[@href = '/admin/items']")
		public WebElement itemTab;
		
		@FindBy (xpath ="//body/div[1]/main[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[2]")
        public WebElement addItemButton;		
		
		@FindBy (name ="name")
		public WebElement nameField;
		
		@FindBy (name ="price")
		public WebElement priceField;
		@FindBy (name ="unit")
		public WebElement unitField;
		@FindBy (name ="description")
		public WebElement descriptionField;
		
		@FindBy (xpath = "//button[text()='Save Item']")
		public WebElement saveitembutton;
		@FindBy (xpath = "//td[text()='Books']")
		public WebElement itemlisttable;
		
		@FindBy (xpath = "//button[text()='Update Item']")
		public WebElement itemdetailspage;
		
		@FindBy (xpath = "//button[contains(text(),'Update Item')]")
		public WebElement updateitembutton;

	
		
		
	}

