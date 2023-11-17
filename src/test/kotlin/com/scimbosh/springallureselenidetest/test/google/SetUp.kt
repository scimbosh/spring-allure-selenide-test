package com.scimbosh.springallureselenidetest.test.google

import com.codeborne.selenide.Configuration
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.openqa.selenium.chrome.ChromeOptions
import org.slf4j.LoggerFactory

internal class SetUp : BeforeAllCallback {
    val log = LoggerFactory.getLogger(javaClass)!!

    override fun beforeAll(context: ExtensionContext) {
        log.info("======SETUP======")

        Configuration.remote = "http://192.168.219.100:4444/wd/hub"
        Configuration.reportsFolder = "target/surefire-reports"
        Configuration.downloadsFolder = "target/downloads"
        val options: MutableMap<String, Boolean> = HashMap()
        options["enableVNC"] = true
        options["enableVideo"] = true
        options["enableLog"] = true
        val capabilities = ChromeOptions()
        //capabilities.setBrowserVersion("100.0")
        Configuration.browserCapabilities = capabilities
        Configuration.browserCapabilities.setCapability("selenoid:options", options)

        //selenide standalone
//        Configuration.screenshots = true
//        Configuration.fastSetValue = true
//        Configuration.timeout = 10000
//        Configuration.webdriverLogsEnabled
//        //Configuration.startMaximized = true
//        //Configuration.driverManagerEnabled = true
//        System.setProperty("webdriver.chrome.driver", "./driver/win64.119.0.6045.105/chromedriver.exe");
//        //Configuration.browser = ""
//        //Configuration.headless = true
    }



}