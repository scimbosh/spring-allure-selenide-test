package com.scimbosh.springallureselenidetest.test.google

import com.scimbosh.springallureselenidetest.DriverFactory
import com.scimbosh.springallureselenidetest.TestProperties
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.junit.jupiter.SpringExtension

@Configuration
open class SetUp : BeforeAllCallback {

    val log = LoggerFactory.getLogger(javaClass)!!

    private var driverFactory = DriverFactory()

    override fun beforeAll(context: ExtensionContext) {

        var props = SpringExtension.getApplicationContext(context)
            .getBean(TestProperties::class.java)

        log.info(
            """
            \n
            ===============OUTPUT==============
                 init ${props.driver} driver
            ===============OUTPUT==============
        """.trimIndent()
        )

        driverFactory.setEnv(props.driver)

    }

}