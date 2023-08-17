package com.scimbosh.springtestseleniumtest.steps.google

import com.codeborne.selenide.Condition.exist
import com.codeborne.selenide.Condition.text
import com.scimbosh.springtestseleniumtest.pages.google.SearchResultPage
import com.scimbosh.springtestseleniumtest.pages.google.StartPage
import com.scimbosh.springtestseleniumtest.steps.BaseStep
import io.qameta.allure.Step
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class StartPageSteps: BaseStep() {

    @Autowired
    lateinit var startPage: StartPage

    @Autowired
    lateinit var searchResultPage: SearchResultPage

    @Step("Enter the query {queryString} in the search bar. Press \"Enter\"")
    fun inputQuery(queryString: String){
        startPage.queryTextarea.sendKeys(queryString)
        startPage.queryTextarea.pressEnter()
    }

    @Step("Check that the page with search results has opened")
    fun checkSearchResultPageIsOpen(queryString: String){
        searchResultPage.searchResultsContainerPage.shouldBe(exist)
        searchResultPage.textInSearchField.shouldHave(text(queryString))
    }
}