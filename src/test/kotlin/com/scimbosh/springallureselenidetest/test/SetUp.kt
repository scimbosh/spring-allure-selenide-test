package com.scimbosh.springallureselenidetest.test

import com.scimbosh.springallureselenidetest.DriverFactory
import com.scimbosh.springallureselenidetest.TestProperties
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.junit.jupiter.SpringExtension


@Configuration
open class SetUp : BeforeAllCallback {

//    @Autowired
//    lateinit var context: ApplicationContext

    val log = LoggerFactory.getLogger(javaClass)!!

    override fun beforeAll(context: ExtensionContext) {

        var props = SpringExtension.getApplicationContext(context)
            .getBean(TestProperties::class.java)

        var driverFactory = DriverFactory(props)

    }

}