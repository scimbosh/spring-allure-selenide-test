package com.scimbosh.springtestseleniumtest.test.google

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import io.qameta.allure.*
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Epic(value = "Simple test example epic name")
@Feature(value = "Simple test example feature name")
@Story(value = "Simple test example story name")
@Tags(value = [Tag("Simple test example"), Tag("google")])
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class ExampleGoogleTest : BaseTest() {

    fun find(query: String) = Selenide.`$`(query)

    @BeforeEach
    @Step("Precondition step")
    fun precondition() {
        println("Run tests")
    }

    @Test
    @Owner(value = "scimbosh")
    @DisplayName("Simple Allure test example")
    @AllureId("1")
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
    @Owner(value = "scimbosh")
    @DisplayName("Simple Selenide successful test example")
    @AllureId("2")
    @Tags(value = [Tag("auto"), Tag("allure"), Tag("selenide"), Tag("positive")])
    fun selenideSuccessfulTestExample() {
        Allure.step("Open Google", Allure.ThrowableRunnable {
            Selenide.open("https://www.google.com/")
        })

        Allure.step("Find button \"Google Search\" ", Allure.ThrowableRunnable {
            find("input.gNO89b").shouldBe(Condition.exist)
        })
    }

    @Test
    @Owner(value = "scimbosh")
    @DisplayName("Simple Selenide unsuccessful test example")
    @AllureId("3")
    @Tags(value = [Tag("auto"), Tag("allure"), Tag("selenide"), Tag("negative")])
    fun selenideUnsuccessfulTestExample() {
        Allure.step("Open Google", Allure.ThrowableRunnable {
            Selenide.open("https://www.google.com/")
        })

        Allure.step("Find button \"Fail test\" ", Allure.ThrowableRunnable {
            find("input.FAILTEST").shouldBe(Condition.exist)
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

    @Owner(value = "scimbosh")
    @AllureId("5")
    @Tags(value = [Tag("auto"), Tag("allure"), Tag("selenide"), Tag("positive"), Tag("parameterized")])
    @ParameterizedTest(name = "Enter different words and check the result")
    @ValueSource(strings = ["First query", "Second query"])
    fun runSearchWithParam(queryString: String) {
        startPageSteps.inputQuery(queryString)
        startPageSteps.checkSearchResultPageIsOpen(queryString)
        Thread.sleep(1000)
    }

}