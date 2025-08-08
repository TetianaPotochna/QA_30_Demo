package tests;

import dto.Student;
import enums.Gender;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormsPage;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegistrationFormPositive() {
        Student student = new Student("Vasya", "Ivanov", "vasya@gmail.com", Gender.MALE, "0509997755", "05 Jan 1972", "Maths,Physics,Chemistry"
                , "music", " ", "112 Ave", "Haryana", "Karnal");
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormsPage(getDriver()).typePracticeForm(student);
    }

}