package com.scimbosh.springallureselenidetest


import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.TestPropertySource

@Configuration
@EnableConfigurationProperties
@TestPropertySource("resources/application.yml")
//@ConfigurationProperties(prefix = "test", ignoreInvalidFields = true)
//@PropertySource(
//    value = ["classpath:src/test/resources/application.yml"],
//    //ignoreResourceNotFound = true,
//    encoding = "UTF-8"
//)
class TestProperties {
    @Value("\${test.driver}")
    lateinit var driver: String


    @Value("\${test.ip-address}")
    lateinit var hostAddress: String


    @Value("\${test.browser}")
    lateinit var browser: String
}