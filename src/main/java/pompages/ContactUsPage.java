package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
  
	//Declaration 
	@FindBy(xpath = "//img[contains(@src=,'contactus')]")
	private WebElement contactUsIcon;
	
	@FindBy(name = "name")
	private WebElement fullNameTF;
	
	@FindBy(name = "sender")
	private WebElement emailTF;
	
	@FindBy(name = "subject")
	private WebElement subjectTF;
	
	@FindBy(name = "message")
	private WebElement messageTextArea;
	
	@FindBy(xpath = "//button[text()='send us mail']")
	private WebElement sendusMailButton;
	
	//Initialization
	public ContactUsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getContactUsIcon()
	{
		return contactUsIcon;
	}
	
	public void sendContactInfo(String fullname,String email, String subject, String message) {
		fullNameTF.sendKeys(fullname);
		emailTF.sendKeys(email);
		subjectTF.sendKeys(subject);
		messageTextArea.sendKeys(subject);
		sendusMailButton.click();
	}
}
