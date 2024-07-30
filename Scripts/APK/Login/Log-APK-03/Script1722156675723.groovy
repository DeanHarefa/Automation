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

Mobile.startApplication('C:\\Users\\asus\\Downloads\\demo-app.site.apk', true)

Mobile.tap(findTestObject('Object Repository/Mobile/Homepage/User doesnt login/Btn Login Here'), 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Login/Click Email'), 0)

Mobile.setText(findTestObject('Object Repository/Mobile/Login/Input Email'), 'teamsejahtera879@gmail.com', 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Login/Click Password'), 0)

Mobile.setEncryptedText(findTestObject('Object Repository/Mobile/Login/Input Password'), '/5S6MFFLcE4psZ5g+CnD2g==', 0)

Mobile.tap(findTestObject('Object Repository/Mobile/Login/Click Button Login'), 5)

Mobile.verifyElementVisible(findTestObject('Object Repository/Mobile/Login/android.widget.TextView - Invalid Credential'), 5)


