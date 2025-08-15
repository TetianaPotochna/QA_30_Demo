package pages;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class PracticeFormsPage extends BasePage {
    public PracticeFormsPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "firstName")
    WebElement fieldFirstName;

    @FindBy(id = "lastName")
    WebElement fieldLastName;

    @FindBy(xpath = "//input[@placeholder='name@example.com']")
    WebElement fieldEmail;

    @FindBy(id = "userNumber")
    WebElement fieldMobile;

    @FindBy(id = "dateOfBirthInput")
    WebElement fieldDateOfBirth;

    @FindBy(id = "subjectsInput")
    WebElement fieldSubjects;

    @FindBy(id = "currentAddress")
    WebElement textAreaAddress;

    @FindBy(xpath = "//input[@id='react-select-3-input']")
    WebElement inputState;

    @FindBy(xpath = "//input[@id='react-select-4-input']")
    WebElement inputCity;

    @FindBy(id = "submit")
    WebElement submit;

    @FindBy(id = "example-modal-sizes-title-lg")
    WebElement modalMessage;


    public void typePracticeForm(Student student) {
        hideBanner();
        hideFooter();
        fieldFirstName.sendKeys(student.getName());
        fieldLastName.sendKeys(student.getLastName());
        fieldEmail.sendKeys(student.getEmail());
        typeGender(student.getGender());
        fieldMobile.sendKeys(student.getMobile());
        //fieldDateOfBirth.sendKeys(student.getDateOfBirth());
        typeDateOfBirth(student.getDateOfBirth());
        typeSubjects(student.getSubjects());
        typeHobbies(student.getHobbies());
        textAreaAddress.sendKeys(student.getAddress());
        typeStateCity(student.getState(), student.getCity());
        submit.click();

    }

    public boolean validateModalMessage(){
     return validateTextInElement(modalMessage,"Thanks for submitting the form");
    }

    public boolean validateModalMessageNegative(){
        return validateTextInElement(modalMessage, "Negative");
    }

    private void typeStateCity(String state, String city) {
        inputState.sendKeys(state);
        inputState.sendKeys(Keys.ENTER);

        inputCity.sendKeys(city);
        inputCity.sendKeys(Keys.ENTER);
    }

    private void typeHobbies(List<Hobbies> hobbies) {
        for (Hobbies h : hobbies) {
            switch (h) {
                case MUSIC:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
                case READING:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
                case SPORT:
                    driver.findElement(By.xpath(h.getLocator())).click();
                    break;
            }
        }
    }

    private void typeGender(Gender gender) {
        WebElement btnGender = driver.findElement(By.xpath(gender.getLocator()));
        btnGender.click();

    }

    private void typeDateOfBirth(String dateOfBirth) {
        fieldDateOfBirth.click();
        String operationSystem = System.getProperty("os.name");
        System.out.println(operationSystem);
        if (operationSystem.startsWith("Win"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        else if (operationSystem.startsWith("Mac"))
            fieldDateOfBirth.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        fieldDateOfBirth.sendKeys(dateOfBirth);
        fieldDateOfBirth.sendKeys(Keys.ENTER);

    }

    private void typeSubjects(String subjects) {
        fieldSubjects.click();
        String[] arr = subjects.split(",");
        for (String s : arr) {
            fieldSubjects.sendKeys(s);
            fieldSubjects.sendKeys(Keys.ENTER);
        }
    }
}
