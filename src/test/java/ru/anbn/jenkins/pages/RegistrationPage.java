package ru.anbn.jenkins.pages;

import com.codeborne.selenide.SelenideElement;
import ru.anbn.jenkins.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    // components
    CalendarComponent calendarComponent = new CalendarComponent();

    // locators
    private SelenideElement
            headerTitle = $(".main-header"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailImput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendar = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesClick = $(".practice-form-wrapper"),
            downloadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitClick = $("#submit"),
            resultsTable = $(".table-responsive");


    // actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        userEmailImput.setValue(userEmail);
        return this;
    }

    public RegistrationPage setEnterWrapper(String gender) {
        genderWrapperInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);
        return this;
    }

    public RegistrationPage setBirthDate(String year, String mounth, String day) {
        calendar.click();
        calendarComponent.setDate(year, mounth, day);
        return this;
    }

    public RegistrationPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;

    }

    public RegistrationPage setHobbies(String hobbies) {
        hobbiesClick.$(byText(hobbies)).click();
        return this;
    }

    public RegistrationPage downloadPicture(String name) {
        downloadPictureInput.uploadFromClasspath(name);
        return this;
    }

    public RegistrationPage currentAddress(String addrress) {
        currentAddressInput.setValue("Russia");
        return this;
    }

    public RegistrationPage selectionState(String state) {
        executeJavaScript("scroll(0,250)");
        stateInput.click();
        stateInput.$(byText(state)).click();
        return this;
    }

    public RegistrationPage selectionCity(String city) {
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }

    public RegistrationPage submtButtonClick() {
        submitClick.click();
        return this;
    }


    public RegistrationPage checkForm(String value) {
        resultsTable.shouldHave(text(value));
        return this;
    }

}
