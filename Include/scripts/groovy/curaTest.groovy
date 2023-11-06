import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class curaTest {

	@Given("Open https://katalon-demo-cura.herokuapp.com/")
	def open_https_katalon_demo_cura_herokuapp_com() {		
		WebUI.openBrowser('')
		WebUI.maximizeWindow()
		WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
	}
	
	@When("Click button Make Appointment and Login Succeed (.*) and (.*)")
	def Click_button_Make_Appointment_and_Login_Succeed(String username, String password) {		
		WebUI.click(findTestObject('Object Repository/curaTest/btn_make_appointment'))
		WebUI.delay(3)
		WebUI.verifyElementPresent(findTestObject('Object Repository/curaTest/field_username'), 5)
		WebUI.setText(findTestObject('Object Repository/curaTest/field_username'), username)
		WebUI.verifyElementPresent(findTestObject("Object Repository/curaTest/field_password"), 5)
		WebUI.setText(findTestObject('Object Repository/curaTest/field_password'), password)
		WebUI.click(findTestObject('Object Repository/curaTest/btn_login'))
	}
	
	@And("Make appointment (.*) and (.*)")
	def Make_appointment(String date, String notes) {
		WebUI.verifyElementPresent(findTestObject('Object Repository/curaTest/text_to_verify_present'), 5)
		WebUI.scrollToElement(findTestObject('Object Repository/curaTest/text_to_scroll'), 5)
		WebUI.selectOptionByValue(findTestObject('Object Repository/curaTest/dropdown_selection'), 'Hongkong CURA Healthcare Center', true)
		WebUI.setText(findTestObject('Object Repository/curaTest/field_visit_date'), date)
		WebUI.setText(findTestObject('Object Repository/curaTest/field_notes'), notes)
		WebUI.click(findTestObject('Object Repository/curaTest/btn_book_appointment'))
		WebUI.delay(3)
	}
	
	@Then("Click back to homepage")
	def Click_back_to_homepage() {
		WebUI.click(findTestObject('Object Repository/curaTest/btn_go_to_homepage'))
		WebUI.delay(3)
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/curaTest/text_to_verify_not_present'), 5)
		WebUI.closeBrowser()
	}


}