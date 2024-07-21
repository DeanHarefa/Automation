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

WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Homepage/btnBuatAkun'))

WebUI.setText(findTestObject('RegisterPage/input_Nama'), fakerData.name().fullName())

WebUI.sendKeys(findTestObject('RegisterPage/input_Tanggal lahir'), '19-02-1987')

WebUI.click(findTestObject('RegisterPage/input_Nama'))

WebUI.setText(findTestObject('RegisterPage/input_Email'), GlobalVariable.email)

WebUI.setText(findTestObject('RegisterPage/input_Whatsapp'), fakerData.phoneNumber.phoneNumber().replace('-', ''))

WebUI.setText(findTestObject('RegisterPage/input_Kata Sandi'), GlobalVariable.password)

WebUI.setText(findTestObject('RegisterPage/input_Konfirmasi kata sandi'), GlobalVariable.password)

WebUI.click(findTestObject('RegisterPage/checkbox_Konfirmasi'))

WebUI.click(findTestObject('RegisterPage/button_Daftar'))

WebUI.verifyElementPresent(findTestObject('RegisterPage/Verifikasi Email/alert_email sudah terdaftar'), 0)

WebUI.closeBrowser()

