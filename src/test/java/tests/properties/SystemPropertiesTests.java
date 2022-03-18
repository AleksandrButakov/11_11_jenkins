package tests.properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("properties")
public class SystemPropertiesTests {

    // запуск теста с передачей параметров:
    // gradle clean test -Dbrowser=mozilla

    @Test
    void someTest1() {
        // пытаемся забрать значение, которого нет, вывод в консоль null
        String browser = System.getProperty("browser");
        System.out.println(browser);    // null
    }

    @Test
    void someTest2() {
        // System хранилище для хранения системных переменных
        System.setProperty("some_browser", "safari");
        String browser = System.getProperty("some_browser");
        System.out.println(browser);    // safari
    }

    @Test
    void someTest3() {
        // указали что если не находит значения browser, то выводим opera
        // def значит по дефолту
        String browser = System.getProperty("browser", "opera");
        System.out.println(browser);    // opera
        // в зависимости от запуска командами получим следующий результат:
        // gradle clean test                    // opera
        // gradle clean test -Dbrowser=mozilla  // mozilla
    }

    @Test
    void someTest4() {
        System.out.println(System.getProperty("any_value"));    // null
        System.setProperty("any_value", "some");
        System.out.println(System.getProperty("any_value"));    // some
    }

    @Test
    void someTest5(){
        String browser = System.getProperty("browser", "chrome");
        String version = System.getProperty("version", "91");
        String browserSize = System.getProperty("browserSize", "300x300");

        System.out.println(browser);
        System.out.println(version);
        System.out.println(browserSize);

        // gradle clean test
        // gradle clean test -Dbrowser=mozilla -Dversion=80 -DbrowserSize=600x600
    }

    @Test
    @Tag("smoke")
    void someTest6() {
        System.out.println("I want to say: " + System.getProperty("someText"));
    }

}
