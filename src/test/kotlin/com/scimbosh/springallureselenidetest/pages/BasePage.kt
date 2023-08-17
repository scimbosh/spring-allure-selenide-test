package com.scimbosh.springallureselenidetest.pages

import com.codeborne.selenide.Selenide
import org.openqa.selenium.By

open class BasePage {

    fun find(query: String) = Selenide.`$`(query)
    fun findAll(by: By) = Selenide.`$$`(by)
}