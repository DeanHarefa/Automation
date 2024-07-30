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

WebUI.click(findTestObject('Web/Homepage/btnMasuk'))

WebUI.setText(findTestObject('Web/Login Page/input_Email'), GlobalVariable.email)

WebUI.setEncryptedText(findTestObject('Web/Login Page/input_Kata Sandi'), GlobalVariable.password)

WebUI.click(findTestObject('Web/Login Page/button_Login'))

WebUI.click(findTestObject('Web/Homepage/btnCourse'))

WebUI.click(findTestObject('Object Repository/Web/Courses/CourseCard/img_Rp 5.000.000_imageHeader'))

WebUI.click(findTestObject('Web/Courses/CourseCardDetailPage/button_Take this Course (1)'))

WebUI.verifyElementPresent(findTestObject('Web/Courses/CourseCardDetailPage/Pop Up Message Cart/h3_Course berhasil ditambahkan ke pembelian'), 
    5)

WebUI.verifyElementPresent(findTestObject('Web/Courses/CourseCardDetailPage/Pop Up Message Cart/h2_Mobile Engineer with React Native'), 
    5)

WebUI.click(findTestObject('Object Repository/Web/Cart/btn_Lihat Pembelian Saya'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Web/Cart/h4_Pembelian Saya'), 5)

WebUI.verifyElementPresent(findTestObject('Object Repository/Web/Cart/h3_Mobile Engineer with React Native'), 5)

WebUI.closeBrowser()