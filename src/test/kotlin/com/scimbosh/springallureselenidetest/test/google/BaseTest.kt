package com.scimbosh.springallureselenidetest.test.google

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.open
import com.scimbosh.springallureselenidetest.steps.google.StartPageSteps
import io.qameta.allure.Step
import org.junit.jupiter.api.AfterEach
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

//@SpringBootTest(classes = [SpringTestSeleniumTestApplication::class])
@SpringBootTest
class BaseTest {

    @Autowired
    lateinit var startPageSteps: StartPageSteps

    val log = LoggerFactory.getLogger(javaClass)!!

    init {
        setUpBrowser()
        openWebSite()
    }

    @Step("Open web-site {url}")
    fun openWebSite(url: String = "https://www.google.com/") {
        log.info("======INIT=SESSION======")
        open(url)
    }

    private fun setUpBrowser() {
        log.info("======SETUP======")

        Configuration.screenshots = true
        Configuration.fastSetValue = true
        Configuration.timeout = 10000
        Configuration.webdriverLogsEnabled
        //Configuration.startMaximized = true
        //Configuration.driverManagerEnabled = true
        System.setProperty("webdriver.chrome.driver", "./driver/win64.119.0.6045.105/chromedriver.exe");
        //Configuration.browser = ""
        //Configuration.headless = true
    }

    @AfterEach
    fun tearDownBrowser() {
        log.info("======END=SESSION======")
        Selenide.closeWebDriver()
    }

}