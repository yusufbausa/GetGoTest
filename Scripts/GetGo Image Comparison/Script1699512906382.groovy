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

WebUI.navigateToUrl('https://getgo.sg/')

WebUI.click(findTestObject('Object Repository/GetGo Image Comparison/menu_cars'))

WebUI.delay(2)

//zoom out
WebUI.setViewPortSize(703, 347)

//zoom in
WebUI.setViewPortSize(1290, 1080)

WebUI.click(findTestObject('Object Repository/GetGo Image Comparison/car_bmw_528i'))

Assert.assertFalse(CustomKeywords.'com.at.util.ScreenshotHelper.compareImages'(findTestObject('Object Repository/GetGo Image Comparison/img_bmw_528I')))

WebUI.click(findTestObject('Object Repository/GetGo Image Comparison/img_bmw_528I'))

WebUI.scrollToElement(findTestObject('Object Repository/GetGo Image Comparison/text_ready_to_getgo'), 5)

WebUI.click(findTestObject('Object Repository/GetGo Image Comparison/text_ready_to_getgo'))

WebUI.scrollToElement(findTestObject('Object Repository/GetGo Image Comparison/text_bmw_528'), 5)

WebUI.click(findTestObject('Object Repository/GetGo Image Comparison/text_bmw_528i'))

WebUI.closeBrowser()

Windows.switchToWindow(findWindowsObject(null))

