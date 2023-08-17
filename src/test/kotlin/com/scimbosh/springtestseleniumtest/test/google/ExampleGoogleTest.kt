package com.scimbosh.springtestseleniumtest.test.google

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide
import io.qameta.allure.*
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@Epic(value = "Extended test epic name")
@Feature(value = "Extended test name")
@Tags(value = [Tag("extendedTest"), Tag("google")])
@Story(value = "Extended test story name")
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class ExampleGoogleTest: BaseTest() {

    fun find(query: String) = Selenide.`$`(query)

    @Test
    @Owner(value = "scimbosh")
    @DisplayName("Example  Allure test")
    @AllureId("1")
    @Tags(value = [Tag("auto"), Tag("allure")])
    fun allureExampleTest() {
        Allure.step("Step 0")
        annotatedStep("Step1")
        annotatedStep2("Step2")
        Assertions.assertTrue(true)
    }

    @Step("Parent annotated step with parameter [{parameter}]")
    fun annotatedStep(parameter: String?) {
        println("execute $parameter")
    }

    @Step("Parent annotated step with parameter [{parameter}]")
    fun annotatedStep2(parameter: String?) {
        println("execute $parameter")
    }

    @Test
    @Owner(value = "scimbosh")
    @DisplayName("Selenide successful test example")
    @AllureId("2")
    @Tags(value = [Tag("auto"), Tag("web"), Tag("selenide"), Tag("positive")])
    fun selenideSuccessfulTestExample(){
        Allure.step("Open Google",Allure.ThrowableRunnable {
            Selenide.open("https://www.google.com/")
        })

        Allure.step("Find button \"Google Search\" ",Allure.ThrowableRunnable {
            find("input.gNO89b")
                .shouldBe(Condition.exist)
        })
    }

    @Test
    @Owner(value = "scimbosh")
    @DisplayName("Selenide unsuccessful test example")
    @AllureId("3")
    @Tags(value = [Tag("auto"), Tag("web"), Tag("selenide")])
    fun selenideUnsuccessfulTestExample(){
        Allure.step("Open Google",Allure.ThrowableRunnable {
            Selenide.open("https://www.google.com/")
        })

        Allure.step("Find button \"Fail test\" ",Allure.ThrowableRunnable {
            find("input.FAILTEST")
                .shouldBe(Condition.exist)
        })
    }

    @Test
    @AllureId("4")
    @Owner(value = "scimbosh")
    @DisplayName("Selenide successful test example")
    @Tags(value = [Tag("auto"), Tag("web"), Tag("selenide"), Tag("positive")])
    fun runSearch(){
        var query = "First query"
        startPageSteps.inputQuery(query)
        startPageSteps.checkSearchResultPageIsOpen(query)
        Thread.sleep(1000)
    }

    @Owner(value = "scimbosh")
    @AllureId("5")
    @Tags(value = [Tag("auto"), Tag("web"), Tag("selenide"), Tag("positive"), Tag("parametrized")])
    @ParameterizedTest(name = "Parametrized test example")
    @ValueSource(strings = ["First query", "Second query"])
    fun runSearchParam(queryString: String){
        startPageSteps.inputQuery(queryString)
        Thread.sleep(1000)
    }

    @BeforeEach
    fun precondition(){
        println("test")
    }

}