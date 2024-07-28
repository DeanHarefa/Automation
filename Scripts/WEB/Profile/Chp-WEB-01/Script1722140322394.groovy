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

WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Homepage/btnMasuk'))

WebUI.setText(findTestObject('Login Page/input_Email'), GlobalVariable.email)

WebUI.setEncryptedText(findTestObject('Login Page/input_Kata Sandi'), GlobalVariable.password)

WebUI.click(findTestObject('Login Page/button_Login'))

WebUI.click(findTestObject('Web/Change Profile/Icon Profile'))

WebUI.click(findTestObject('Web/Change Profile/btn My Account'))

WebUI.click(findTestObject('Web/Change Profile/Dashboard/btn_Profil'))

WebUI.click(findTestObject('Web/Change Profile/Dashboard/btn_Edit Profile'))

//WebUI.click(findTestObject('Web/Change Profile/Dashboard/icon change image profile'))
WebUI.uploadFile(findTestObject('Web/Change Profile/Dashboard/icon change image profile'), 'C:\\Users\\asus\\git\\Automation\\Data External\\honey_lemon.jpg')

WebUI.click(findTestObject('Web/Change Profile/Dashboard/button_Save Changes'))

WebUI.verifyElementPresent(findTestObject('Web/Change Profile/Dashboard/div_Berhasil'), 0)

WebUI.verifyElementPresent(findTestObject('Web/Change Profile/Dashboard/modal Profile berhasil di edit'), 
    0)

