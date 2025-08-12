package tests;

import dto.Student;
import enums.Gender;
import enums.Hobbies;
import enums.StateCity;
import manager.AppManager;
import org.testng.annotations.Test;
import pages.FormsPage;
import pages.HomePage;
import pages.PracticeFormsPage;

import java.util.ArrayList;
import java.util.List;

public class PracticeFormTests extends AppManager {

    @Test
    public void studentRegistrationFormPositive() {
        List<Hobbies> hobbies = new ArrayList<>();
        hobbies.add(Hobbies.MUSIC);
        hobbies.add(Hobbies.SPORT);
        Student student = new Student("Vasya", "Ivanov", "vasya@gmail.com",
                Gender.MALE, "0509997755", "05 Jan 1972", "Maths,Physics,Chemistry"
                , hobbies, " ", "112 Ave", StateCity.UTTAR_PRADESH.getState(), StateCity.UTTAR_PRADESH.getCity()[2]);
        new HomePage(getDriver()).clickBtnForms();
        new FormsPage(getDriver()).clickBtnPracticeForm();
        new PracticeFormsPage(getDriver()).typePracticeForm(student);
    }

}