import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')
WebUI.maximizeWindow()

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')
WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/curaTest/btn_make_appointment'))

//login process
WebUI.verifyElementPresent(findTestObject('Object Repository/curaTest/field_username'), 5)
WebUI.setText(findTestObject('Object Repository/curaTest/field_username'), 'John Doe')

WebUI.verifyElementPresent(findTestObject("Object Repository/curaTest/field_password"), 5)
WebUI.setText(findTestObject('Object Repository/curaTest/field_password'), 'ThisIsNotAPassword')
WebUI.click(findTestObject('Object Repository/curaTest/btn_login'))

//verify element present
WebUI.verifyElementNotPresent(findTestObject('Object Repository/curaTest/text_to_verify_present'), 5)
WebUI.click(findTestObject('Object Repository/curaTest/text_to_verify_present'))

//scroll to element
WebUI.scrollToElement(findTestObject('Object Repository/curaTest/text_to_scroll'), 5)
WebUI.click(findTestObject('Object Repository/curaTest/text_to_scroll'))

//make appointment process
WebUI.selectOptionByValue(findTestObject('Object Repository/curaTest/dropdown_selection'), 'Hongkong CURA Healthcare Center', true)
WebUI.setText(findTestObject('Object Repository/curaTest/field_visit_date'), '01/12/2023')
WebUI.setText(findTestObject('Object Repository/curaTest/field_notes'), 'Test')
WebUI.click(findTestObject('Object Repository/curaTest/btn_book_appointment'))

WebUI.click(findTestObject('Object Repository/curaTest/btn_go_to_homepage'))

//verify element not present
WebUI.verifyElementNotPresent(findTestObject('Object Repository/curaTest/text_to_verify_not_present'), 5)
WebUI.click(findTestObject('Object Repository/curaTest/text_to_verify_not_present'))

WebUI.delay(5)
WebUI.closeBrowser()

