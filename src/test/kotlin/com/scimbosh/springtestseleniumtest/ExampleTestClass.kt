package com.scimbosh.springtestseleniumtest

import org.junit.jupiter.api.Assertions.assertTrue
import org.openqa.selenium.By
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.*
import com.codeborne.selenide.Condition.*
import io.qameta.allure.*
import org.junit.jupiter.api.*


@Epic(value = "Example epic name")
@Feature(value = "Example feature name")
@Tags(value = [Tag("example"), Tag("google")])
@Story(value = "Example story name")
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class ExampleTestClass {

	fun find(query: String) = Selenide.`$`(query)
	fun findAll(by: By) = Selenide.`$$`(by)

	@Test
	@Owner(value = "scimbosh")
	@DisplayName("Selenide successful test example")
	@AllureId("1")
	@Tags(value = [Tag("auto"), Tag("web"), Tag("selenide"), Tag("positive")])
	fun selenideSuccessfulTestExample(){
		Allure.step("Open Google",Allure.ThrowableRunnable {
			open("https://www.google.com/")
		})

		Allure.step("Find button \"Google Search\" ",Allure.ThrowableRunnable {
			find("input.gNO89b")
				.shouldBe(exist)
		})
	}


	@Test
	@Owner(value = "scimbosh")
	@DisplayName("Selenide unsuccessful test example")
	@AllureId("2")
	@Tags(value = [Tag("auto"), Tag("web"), Tag("selenide")])
	fun selenideUnsuccessfulTestExample(){
		Allure.step("Open Google",Allure.ThrowableRunnable {
			open("https://www.google.com/")
		})

		Allure.step("Find button \"Fail test\" ",Allure.ThrowableRunnable {
			find("input.FAILTEST")
				.shouldBe(exist)
		})
	}

	@Test
	@Owner(value = "scimbosh")
	@DisplayName("Example  Allure test")
	@AllureId("2")
	@Tags(value = [Tag("auto"), Tag("allure")])
	fun allureExampleTest() {
		Allure.step("Step 0")
		annotatedStep("Step1")
		annotatedStep2("Step2")
		assertTrue(true);
	}


	@Step("Parent annotated step with parameter [{parameter}]")
	fun annotatedStep(parameter: String?) {
		println("${parameter}")
	}

	@Step("Parent annotated step with parameter [{parameter}]")
	fun annotatedStep2(parameter: String?) {
		println("${parameter}")
	}


}
