package com.scimbosh.springallureselenidetest.steps

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class BaseStep {

    val log = LoggerFactory.getLogger(javaClass)!!

}