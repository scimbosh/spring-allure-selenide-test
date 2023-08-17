package com.scimbosh.springallureselenidetest.test.google

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import com.scimbosh.springallureselenidetest.annotations.Manual
import io.qameta.allure.*
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Epic(value = "Simple test example epic name")
@Feature(value = "Simple test example feature name")
@Story(value = "Simple test example story name")
@Tags(value = [Tag("example"), Tag("google")])
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class ExampleGoogleTest : BaseTest() {


    @BeforeEach
    @Step("Precondition step")
    fun precondition() {
        println("Run tests")
    }

    @Test
    @AllureId("1")
    @Owner(value = "scimbosh")
    @DisplayName("Simple Allure test example")
    @Tags(value = [Tag("auto"), Tag("allure"), Tag("positive")])
    fun allureExampleTest() {
        Allure.step("Step 0")
        annotatedStep("Step1")
        annotatedStep2("Step2")
        Assertions.assertTrue(true)
    }

    @Step("Parent annotated step with parameter [{parameter}]")
    fun annotatedStep(parameter: String?) {
        println("Execute $parameter")
    }

    @Step("Parent annotated step with parameter [{parameter}]")
    fun annotatedStep2(parameter: String?) {
        println("Execute $parameter")
    }

    @Test
    @AllureId("2")
    @Owner(value = "scimbosh")
    @DisplayName("Simple Selenide successful test example")
    @Tags(value = [Tag("auto"), Tag("allure"), Tag("selenide"), Tag("positive")])
    fun selenideSuccessfulTestExample() {
        Allure.step("Open Google", Allure.ThrowableRunnable {
            Selenide.open("https://www.google.com/")
        })

        Allure.step("Find button \"Google Search\" ", Allure.ThrowableRunnable {
            Selenide.`$`("input.gNO89b").shouldBe(Condition.exist)
        })
    }

    @Test
    @AllureId("3")
    @Owner(value = "scimbosh")
    @DisplayName("Simple Selenide unsuccessful test example")
    @Tags(value = [Tag("auto"), Tag("allure"), Tag("selenide"), Tag("negative")])
    fun selenideUnsuccessfulTestExample() {
        Allure.step("Open Google", Allure.ThrowableRunnable {
            Selenide.open("https://www.google.com/")
        })

        Allure.step("Find button \"Fail test\" ", Allure.ThrowableRunnable {
            Selenide.`$`("input.FAILTEST").shouldBe(Condition.exist)
        })
    }

    @Test
    @AllureId("4")
    @Owner(value = "scimbosh")
    @DisplayName("Google search check")
    @Tags(value = [Tag("auto"), Tag("allure"), Tag("selenide"), Tag("positive")])
    fun runSearch() {
        val query = "First query"
        startPageSteps.inputQuery(query)
        startPageSteps.checkSearchResultPageIsOpen(query)
        Thread.sleep(1000)
    }

    @AllureId("5")
    @Owner(value = "scimbosh")
    @ParameterizedTest(name = "Enter different words and check the result")
    @Tags(value = [Tag("auto"), Tag("allure"), Tag("selenide"), Tag("positive"), Tag("parameterized")])
    @ValueSource(strings = ["First query", "Second query"])
    fun runSearchWithParam(queryString: String) {
        startPageSteps.inputQuery(queryString)
        startPageSteps.checkSearchResultPageIsOpen(queryString)
        Thread.sleep(1000)
    }

    @Manual
    @AllureId("6")
    @Owner(value = "scimbosh")
    @ValueSource(strings = ["First query", "Second query"])
    @ParameterizedTest(name = "Simple manual test example with param ")
    @Tags(value = [Tag("manual"), Tag("allure"), Tag("positive")])
    fun manualSearchWithParam(queryString: String){
        Allure.step("Open Google")
        Allure.step("Enter in the search field $queryString")
        Allure.step("Press Enter")
        Allure.step("Check that the search results page for the previously entered query has opened")
    }

}