package ru.anbn.jenkins;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLog;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.anbn.jenkins.pages.RegistrationPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class FirstTestPageObject {

        RegistrationPage registrationPage = new RegistrationPage();
        String
                firstName = "Ivan",
                lastName = "Petrov",
                userEmail = "ivan@bk.ru",
                gender = "Other",
                userNumber = "4955552244",
                birthDateYear = "1990",
                birthDateMounth = "6",
                birthDateDay = "16",
                birthDataResult = "16 July,1990",
                subjects = "En",
                hobbies = "Reading",
                downloadPicture = "img.png",
                currentAddress = "Russia",
                selectionState = "NCR",
                selectionCity = "Delhi";

        @BeforeAll
        static void beforeAll() {
            String user = System.getProperty("user");
            String password = System.getProperty("password");
            String remoteUrl = System.getProperty("remoteUrl");

            Configuration.baseUrl = "https://demoqa.com";
            Configuration.browserPosition = ("0x0");
            Configuration.browserSize = "1920x1080";

            // +++
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
            // адрес удаленного selenoid сервера, где user1 - login, 1234 - password, wd - webdriver
            Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
            //Configuration.remote = "https://" + user + ":" + password + "@" + remoteUrl;

            /* Jenkins не имеет графического интерфейса поэтому для тестирования web интерфейса необходимо
               подключить selenoid
            */
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.browserCapabilities = capabilities;

        }

        //@AfterAll
        // static void afterAll() {closeWebDriver();}

        @AfterEach
        void addAttachments() {
            Attach.screenshotAs("Last screenshot");
            Attach.pageSource();
            Attach.browserConsoleLogs();
            Attach.addVideo();

        }

        @Test
        void successPracticeFormTest() throws InterruptedException {
            // data entry
            registrationPage.openPage()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setEnterWrapper(gender)
                    .setUserNumber(userNumber)
                    .setBirthDate(birthDateYear, birthDateMounth, birthDateDay)
                    .setSubjects(subjects)
                    .setHobbies(hobbies)
                    //.downloadPicture(downloadPicture)
                    .currentAddress(currentAddress)
                    .selectionState(selectionState)
                    .selectionCity(selectionCity)
                    .submtButtonClick();

            // checking the correctness of the entered value
            registrationPage
                    .checkForm(firstName)
                    .checkForm(lastName)
                    .checkForm(userEmail)
                    .checkForm(gender)
                    .checkForm(userNumber)
                    .checkForm(birthDataResult)
                    .checkForm(subjects)
                    .checkForm(hobbies)
                    //.checkForm(downloadPicture)
                    .checkForm(currentAddress)
                    .checkForm(selectionState)
                    .checkForm(selectionCity);
        }

}
