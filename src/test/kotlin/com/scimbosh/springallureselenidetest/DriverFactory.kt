package com.scimbosh.springallureselenidetest

import com.codeborne.selenide.Configuration
import org.openqa.selenium.chrome.ChromeOptions
import org.slf4j.LoggerFactory

class DriverFactory(var props: TestProperties) {

    val log = LoggerFactory.getLogger(javaClass)!!

    init {
        log.info(
            """
                
        -----Configuration----
        driver =  ${props.driver}
        host address =  ${props.hostAddress}
        browser =  ${props.browser}
        -----Configuration----
        """.trimIndent()
        )
        setEnv()
    }

    fun setEnv() {
        if (props.driver == "docker")  dockerRun()
        else localRun()
    }


    private fun localRun() {

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

    private fun dockerRun() {
        Configuration.remote = props.hostAddress
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
    }

}