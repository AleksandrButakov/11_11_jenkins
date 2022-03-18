package ru.anbn.jenkins.pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    // locators
    private SelenideElement
            birthDateYear = $(".react-datepicker__year-select"),
            birthDateMounth = $(".react-datepicker__month-select"),
            birthDateDay = $(".react-datepicker__month");

    public void setDate(String year, String mounth, String day) {
        birthDateYear.selectOptionByValue(year);
        birthDateMounth.selectOptionByValue(mounth);
        birthDateDay.$(byText(day)).click();
    }

}
