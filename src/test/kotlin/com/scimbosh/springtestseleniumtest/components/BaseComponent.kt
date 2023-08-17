package com.scimbosh.springtestseleniumtest.components

import com.codeborne.selenide.Selenide
import org.openqa.selenium.By
import org.openqa.selenium.WebElement

open class BaseComponent{

    fun find(query: String) = Selenide.`$`(query)
    fun findAll(by: By) = Selenide.`$$`(by)

    fun click(queryParam: String){
        find(queryParam).click()
    }

    fun getText(queryParam: String): String {
        return find(queryParam).text()
    }

    fun getLocator(queryParam: String): String {
        return queryParam
    }

    fun getElement(queryParam: String): WebElement {
        return find(queryParam)
    }

}