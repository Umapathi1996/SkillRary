package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains all the elements and respective business libraries of Home Page
 * @author umapathi Y
 *
 */

public class Homepage {

	//Declaration
	@FindBy(xpath = "//img[@alt='SkillRary']")
	private WebElement logo;
	
	@FindBy(xpath = "//a[text()=' GEARS ']")
	private WebElement gearsTab;
	
	@FindBy(xpath = "//ul[@class='dropdown-menu gear_menu']/descendant::a[text()=' SkillRary Demo APP']")
	private WebElement skillraryDemoApplink;
	
	//Initialization
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	/**
	 * This method returns the skillrary logo
	 * @return
	 */
	public WebElement getLogo() {
		return logo;
	}
	public void clickGearsTab() {
		gearsTab.click();
	}
	public void clickSkillraryDemoApp() {
		skillraryDemoApplink.click();
	}
}
