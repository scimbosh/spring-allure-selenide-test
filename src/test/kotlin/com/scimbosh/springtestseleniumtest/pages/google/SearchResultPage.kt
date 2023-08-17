package com.scimbosh.springtestseleniumtest.pages.google

import com.codeborne.selenide.SelenideElement
import com.scimbosh.springtestseleniumtest.pages.BasePage
import org.springframework.stereotype.Component

@Component
class SearchResultPage: BasePage() {

    companion object {
        const val SEARCH_RESULTS_PAGE_CONTAINER_CSS = "html[itemtype='http://schema.org/SearchResultsPage']"
        const val TEXT_IN_SEARCH_FIELD_CSS =  "*[role='combobox']"
    }

    var searchResultsContainerPage: SelenideElement = find(SEARCH_RESULTS_PAGE_CONTAINER_CSS)
    var textInSearchField : SelenideElement = find(TEXT_IN_SEARCH_FIELD_CSS)

}