import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.github.javafaker.Faker as Faker
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

Faker fakerData = new Faker(new Locale('in-ID'))

TestData dataRegister = findTestData("Data Files/dataRegisterInternal");


WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Homepage/btnBuatAkun'))



//for (int i=1; i <= dataRegister.getRowNumbers(); i++ ) {
//	WebUI.setText(findTestObject('RegisterPage/input_Email'), dataRegister.getValue(1, i))
//
//}

for (int i = 1; i <= dataRegister.getRowNumbers(); i++) {
	WebUI.clearText(findTestObject('RegisterPage/input_Nama'))
	WebUI.clearText(findTestObject('RegisterPage/input_Tanggal lahir'))
	WebUI.clearText(findTestObject('RegisterPage/input_Email'))
	WebUI.clearText(findTestObject('RegisterPage/input_Whatsapp'))
	WebUI.clearText(findTestObject('RegisterPage/input_Kata Sandi'))
	WebUI.clearText(findTestObject('RegisterPage/input_Konfirmasi kata sandi'))
	
	
	
	WebUI.setText(findTestObject('RegisterPage/input_Nama'), fakerData.name().fullName())
	
	WebUI.sendKeys(findTestObject('RegisterPage/input_Tanggal lahir'), '19-02-1987')
	
	
	WebUI.click(findTestObject('RegisterPage/input_Nama'))
	
	String email = dataRegister.getValue(1, i)
	WebUI.setText(findTestObject('RegisterPage/input_Email'), email)
	
	
	WebUI.setText(findTestObject('RegisterPage/input_Whatsapp'), fakerData.phoneNumber.phoneNumber().replace('-', ''))
	
	WebUI.setText(findTestObject('RegisterPage/input_Kata Sandi'), GlobalVariable.password)
	
	WebUI.setText(findTestObject('RegisterPage/input_Konfirmasi kata sandi'), GlobalVariable.password)
	
	WebUI.click(findTestObject('RegisterPage/checkbox_Konfirmasi'))
	
	WebUI.click(findTestObject('RegisterPage/button_Daftar'))
	
	if (email == "Bagus@.com") {
		WebUI.verifyEqual(WebUI.getAttribute(findTestObject('RegisterPage/input_Email'), 'validationMessage'), "'.' is used at a wrong position in '.com'.")
	} else if (email == "Bagus") {
		WebUI.verifyEqual(WebUI.getAttribute(findTestObject('RegisterPage/input_Email'), 'validationMessage'), "Please include an '@' in the email address. 'Bagus' is missing an '@'.")
	} else if (email == "Bagus@") {
		WebUI.verifyEqual(WebUI.getAttribute(findTestObject('RegisterPage/input_Email'), 'validationMessage'), "Please enter a part following '@'. 'Bagus@' is incomplete.")
	}
}

WebUI.closeBrowser()

