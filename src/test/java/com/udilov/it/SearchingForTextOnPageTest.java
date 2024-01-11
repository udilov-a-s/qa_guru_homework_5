package com.udilov.it;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchingForTextOnPageTest {

    @BeforeAll
    static void configuration() {
        Configuration.browserSize = "1025x768";
        Configuration.baseUrl = "https://github.com/";
        Configuration.timeout = 5000;
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void existenceCodeForJUnit5() {

        //Preconditions
        open("selenide/selenide");

        //test
        $("#wiki-tab").click();
        $("#wiki-pages-box").$("#wiki-pages-filter").setValue("SoftAssertions");
        $("#wiki-pages-box").shouldHave(text("SoftAssertions")).shouldBe(visible);
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $("#wiki-body").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");

                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }"""));
    }
}
