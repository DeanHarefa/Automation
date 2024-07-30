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

TestData dataLogin = findTestData('Data Files/dataLoginInternal2')

WebUI.openBrowser(GlobalVariable.URL)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Web/Homepage/btnMasuk'))

for (int i = 1; i <= dataLogin.getRowNumbers(); i++) {
    WebUI.clearText(findTestObject('Web/Login Page/input_Email'))

    WebUI.clearText(findTestObject('Web/Login Page/input_Kata Sandi'))

    String email = dataLogin.getValue(1, i)

    String password = dataLogin.getValue(2, i)

    WebUI.setText(findTestObject('Web/Login Page/input_Email'), email)

    WebUI.setText(findTestObject('Web/Login Page/input_Kata Sandi'), password)

    WebUI.click(findTestObject('Web/Login Page/button_Login'))

    // Jika email kosong
    if (email.isEmpty()) {
        WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Web/Login Page/input_Email'), 'validationMessage'), 'Please fill out this field.')

        WebUI.comment('Email Empty')
    }
    
    // Jika password kosong
    if (password.isEmpty()) {
        WebUI.verifyEqual(WebUI.getAttribute(findTestObject('Web/Login Page/input_Kata Sandi'), 'validationMessage'), 'Please fill out this field.')

        WebUI.comment('Password Empty')
    }
}

WebUI.closeBrowser()

