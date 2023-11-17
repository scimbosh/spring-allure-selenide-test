package com.scimbosh.springallureselenidetest.test.google

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.open
import com.scimbosh.springallureselenidetest.steps.google.StartPageSteps
import io.qameta.allure.Step
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.extension.ExtendWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest()
@ExtendWith(SetUp::class)
class BaseTest {


    @Autowired
    lateinit var startPageSteps: StartPageSteps

    val log = LoggerFactory.getLogger(javaClass)!!

    init {
        openWebSite()
    }

    @Step("Open web-site {url}")
    fun openWebSite(url: String = "https://www.google.com/") {
        log.info("======INIT=SESSION======")
        open(url)
    }

    @AfterEach
    fun tearDownBrowser() {
        log.info("======END=SESSION======")
        Selenide.closeWebDriver()
    }

}