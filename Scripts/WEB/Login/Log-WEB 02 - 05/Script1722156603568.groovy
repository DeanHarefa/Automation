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

TestData dataLogin = findTestData("Data Files/dataLoginInternal");



WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Web/Homepage/btnMasuk'))

for (int i=1; i <= dataLogin.getRowNumbers(); i++ ) {
	//clear fields before input
	WebUI.clearText(findTestObject('Web/Login Page/input_Email'))
	WebUI.clearText(findTestObject('Web/Login Page/input_Kata Sandi'))
	
	WebUI.setText(findTestObject('Web/Login Page/input_Email'), dataLogin.getValue(1, i))
	WebUI.setText(findTestObject('Web/Login Page/input_Kata Sandi'), dataLogin.getValue(2, i))
	WebUI.click(findTestObject('Web/Login Page/button_Login'))
	
	// wait process
	WebUI.delay(2)
	
	if (WebUI.verifyElementPresent(findTestObject('Web/Login Page/alert_Email atau kata sandi salah'), 0, FailureHandling.OPTIONAL)) {
		WebUI.comment('Login failed for email: ' + dataLogin.getValue(1, i))
	} else if(WebUI.verifyElementPresent(findTestObject('Object Repository/Web/Login Page/alert_Email harus terverifikasi'), 0, FailureHandling.OPTIONAL)) {
		WebUI.comment('Login pending for email: ' + dataLogin.getValue(1, i))
		WebUI.click(findTestObject('Object Repository/Web/Login Page/button_Close modal email harus terverifikasi'))
	}else if (WebUI.verifyElementPresent(findTestObject('Web/Homepage/Profile'), 0, FailureHandling.OPTIONAL)){
		WebUI.comment('Login successful for email: ' + dataLogin.getValue(1, i))
		WebUI.click(findTestObject('Web/Homepage/Profile'))
		WebUI.verifyElementPresent(findTestObject('Web/Homepage/btnLogout'), 0)
		
		WebUI.click(findTestObject('Web/Homepage/btnLogout'))
		WebUI.click(findTestObject('Web/Homepage/btnMasuk'))
	} 
	
}



WebUI.closeBrowser()

