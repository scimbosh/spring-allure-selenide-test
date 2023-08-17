package com.scimbosh.springallureselenidetest.components

import com.codeborne.selenide.*
import org.openqa.selenium.*

//@Component
class Button{

    var queryParam = "input.gNO89b"

    fun find(query: String) = Selenide.`$`(query)
    fun findAll(by: By) = Selenide.`$$`(by)

    fun click(queryParam: String){
        find(queryParam).click()
    }

    fun getText(queryParam: String): String {
        return find(queryParam).text()
    }

    fun getLocator(): String {
        return queryParam
    }

    fun getElement(): WebElement {
        return find(queryParam)
    }

    companion object{
        fun find(query: String) = Selenide.`$`(query)
        fun findAll(by: By) = Selenide.`$$`(by)

        var queryParam = "input.gNO89b"
        fun getLocatorCO(): String {
            return queryParam
        }
        fun getElementCO(): WebElement {
            return find(queryParam)
        }
    }

}