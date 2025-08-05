package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PracticeFormsPage extends BasePage{
    public PracticeFormsPage(WebDriver driver){
        setDriver(driver);
                PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
@FindBy(id = "firstName")
    WebElement fieldFirstName;

    @FindBy(id = "lastName")
    WebElement fieldLastName;

    @FindBy(xpath = "//input[@placeholder='name@example.com']")
    WebElement fieldEmail;




    public void typePracticeForm() {
        hideBanner();
        hideFooter();
        fieldFirstName.sendKeys("Monkey");
        fieldLastName.sendKeys("Monkeys");
        fieldEmail.sendKeys("monkey@gmail.com");

    }
}
