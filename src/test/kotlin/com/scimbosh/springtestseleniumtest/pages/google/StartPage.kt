package com.scimbosh.springtestseleniumtest.pages.google

import com.codeborne.selenide.SelenideElement
import com.scimbosh.springtestseleniumtest.pages.BasePage
import org.springframework.stereotype.Component

@Component
class StartPage: BasePage() {

    companion object {
        const val QUERY_TEXTAREA_CSS = "textarea[name='q']"
        const val SEARCH_BUTTON_CSS =  "input.gNO89b"
        const val FEELING_LUCKY_BUTTON_CSS =  "input.RNmpXc"
    }

    var queryTextarea: SelenideElement = find(QUERY_TEXTAREA_CSS)
    var searchButton: SelenideElement = find(SEARCH_BUTTON_CSS)
    var feelingLuckyButton: SelenideElement = find(FEELING_LUCKY_BUTTON_CSS)

}