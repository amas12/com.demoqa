package guru.qa;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import com.codeborne.selenide.selector.WithText;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;





public class PracticeFormTests {


    @Test
    void fillFormTest() throws InterruptedException {
        Faker faker = new Faker();
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("George"); //(faker.name().fullName());
        $("#lastName").setValue("Clooney");
        $("#userEmail").setValue("test@tets.test");
        $(".custom-control").click();
        $("#userNumber").setValue("7674635847");
        $("#dateOfBirthInput").click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__day--012").click();
        $("#hobbiesWrapper").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#uploadPicture").uploadFile(new File("fixtures/EIEXH0aWkAMsRvR.jpg"));
        $("#currentAddress").setValue("USA");
        $("#state").scrollTo().click();
        $(new WithText("Haryana")).shouldHave(text("Haryana")).click();
        $("#city").click();
        $(new WithText("Panipat")).shouldHave(text("Panipat")).click();
        $("#submit").click();
        $(".modal-content");
        $(new WithText("Thanks for submitting the form")).shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("George Clooney"),text("test@tets.test"),
                text("Male"),text("7674635847"),text("12 April,1999"),
                text("English"),text("Reading"),text("EIEXH0aWkAMsRvR.jpg"),text("USA"),text("Haryana Panipat"));


    }


}

