package utils;
import org.openqa.selenium.Alert;
import base.TestBase;
public class popupWindwHandlr extends TestBase {
//import the utility folder in to the package(tests)-> class(LoginTest)
// JavaScript Alert Popup (e.g. alert(), confirm()) : Handled using Alert interface:
	public static int alertHandler() {
		// 🔔 Alert Handling Block 🔔🔔🔔
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert found: " + alert.getText());
			alert.accept();
//			System.out.println("Alert accepted successfully.");
		} catch (org.openqa.selenium.NoAlertPresentException e) {
//			System.out.println("No alert found");
			return 0;
		}
		return 1;
	}	
	
	
	public static String alertHandler1() {
		String a;
		// 🔔 Alert Handling Block 🔔🔔🔔
		try {
			Alert alert = driver.switchTo().alert();
			System.out.println("Alert found: " + alert.getText());
			alert.accept();
			System.out.println("Alert accepted successfully.");
		} catch (org.openqa.selenium.NoAlertPresentException e) {
			System.out.println("No alert found");
			return a= "alert not found";
		}
		return a= "alert accepted";
	}	
}