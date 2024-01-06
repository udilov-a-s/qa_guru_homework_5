package com.udilov.it;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

//Переименовать название класса

public class SearchingForTextOnPage {

    @BeforeAll
    static void configuration() {
        Configuration.browserSize = ",640x480";
        Configuration.baseUrl = "https://github.com/";
        Configuration.timeout = 5000;
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = false;
    }
    @Test
    void existenceCodeForJUnit5() {

        //Preconditions
        open("selenide/selenide");

        //test data
        String textForTesting1 = "Soft assertions";
        String textForTesting2 = "Using JUnit5";

        //test
        $("#wiki-tab").click();
        $("#wiki-body").shouldHave(text(textForTesting1));
        $("#wiki-body").$(byText(textForTesting1)).click();
        $("#wiki-content").shouldHave(text(textForTesting2));
    }
}
