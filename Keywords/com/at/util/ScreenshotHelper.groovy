import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

package com.at.util

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint


public class ScreenshotHelper {

	@Keyword
	public void takeElementScreenshot(TestObject object) {
		WebElement element = WebUICommonHelper.findWebElement(object, 20)
		WebDriver driver = DriverFactory.getWebDriver();

		Screenshot screenshot = new AShot().takeScreenshot(driver, element);
		ImageIO.write(screenshot.getImage(), "SVG", new File(System.getProperty("user.dir") +"/"))
	}

	@Keyword
	public boolean compareImages(TesObject object) {
		WebElement element = WebUICommonHelper.findWebElement(object, 20)
		WebDriver driver = DriverFactory.getWebDriver();

		BufferedImage expectedImage = ImageIO.read(new File(System.getProperty("user.dir") + "\\ErrorScreenshot\\"))
		Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, element);
		BufferedImage actualImage = logoImageScreenshot.getImage();

		ImageDiffer imgDiff = new ImageDiffer();\
		ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);

		return diff.hasDiff();
	}
}
