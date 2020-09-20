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
import com.kms.katalon.core.webui.keyword.builtin.OpenBrowserKeyword

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



class LoginStep {
	@Given ("I am on the login page")
	def navigateToUrl(){
		println("\n Navigate to Url")
		WebUI.openBrowser("https://opensource-demo.orangehrmlive.com")
		WebUI.maximizeWindow()
	}

	@When ("I input valid (.*) and (.*)")
	def inputValidUsernamePassword(String username, String password){
		println ("\n Saya di dalam inputValidUsernamePassword")
		WebUI.setText(findTestObject('Txt_Username'), username)
		WebUI.setEncryptedText(findTestObject('Txt_Password'), password)
	}

	@And ("I click login button")
	def clickLoginButton(){
		println("\n Click Login Button")
		WebUI.click(findTestObject('Btn_Login'))
	}

	@Then ("I should be navigated to home page")
	def successLogin(){
		println("\n User success Login")
		WebUI.verifyElementPresent(findTestObject('Ttl_Dashboard'), 0)
	}

	@Then ("Invalid credentials")
	def errorLogin(){
		println("\n Login error")
	}

	@And ("I click My Info menu")
	def clickMyInfo(){
		WebUI.click(findTestObject('Menu_MyInfo'))
	}

	@Then ("I am in My Info page")
	def myInfoPage(){
		WebUI.verifyElementPresent(findTestObject('Ttl_MyInfo_PersonalDetails'), 0)
	}

	@When ("I click Admin menu")
	def adminMenu(){
		WebUI.click(findTestObject('Menu_Admin'))
	}

	@And ("I click Nationality menu")
	def nationalityMenu(){
		WebUI.click(findTestObject('Menu_Nationality'))
	}

	@And ("I click Add button")
	def addButton(){
		WebUI.verifyElementPresent(findTestObject('Ttl_Nationality_Nationalities'), 0)
		WebUI.click(findTestObject('Btn_Nationality_Add'))
	}

	@And ("I input (.*) field")
	def inputNameNationality(String name){
		WebUI.setText(findTestObject('Txt_Nationality_AddName'), name)
	}

	@And ("I click Save button")
	def saveButton(){
		WebUI.click(findTestObject('Btn_Nationality_Save'))
	}

	@And ("I check test")
	def checkTest(){
		WebUI.check(findTestObject('Chk_Nationality_Test'))
	}

	@Then ("I click Delete button")
	def deleteButton(){
		WebUI.click(findTestObject('Btn_Nationality_Delete'))
	}

	@And ("I click OK")
	def okButton(){
		WebUI.click(findTestObject('Btn_Nationality_OK'))
	}
	
	@When ("I click PIM menu")
	def pimMenu(){
		WebUI.click(findTestObject('Menu_PIM'))
	}
	
	@And ("I click Add Employee menu")
	def addEmployeeMenu(){
		WebUI.click(findTestObject('Menu_PIM_AddEmployee'))
	}
	
	@And ("I input (.*) , (.*) and (.*)")
	def inputAddEmployee(String firstname, String middlename, String lastname){
		WebUI.verifyElementPresent(findTestObject('Ttl_PIM_AddEmployee'), 0)
		WebUI.setText(findTestObject('Txt_PIM_FirstName'), firstname)
		WebUI.setText(findTestObject('Txt_PIM_MiddleName'), middlename)
		WebUI.setText(findTestObject('Txt_PIM_LastName'), lastname)
	}
	
	@And ("I click Save button in Add Employee page")
	def saveEmployee(){
		WebUI.click(findTestObject('Btn_PIM_Save'))
	}
	
	@Then ("I success add new employee")
	def successAddEmployee(){
		WebUI.verifyElementPresent(findTestObject('Ttl_PIM_SuccessAddEmployee'), 0)
		WebUI.closeBrowser()
	}
}