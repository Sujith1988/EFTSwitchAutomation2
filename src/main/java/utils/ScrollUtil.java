package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollUtil {

	            // scroll upto the element of the page
				public static  void scrollToAnElement(WebDriver driver, WebElement obj) {
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", obj);                            
				}
				
				// scroll to bottom of the page
				public  static void scrollToBottom(WebDriver driver) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollTo(0, document.body.scrollHeight);");                            
				}
				
				// scroll to the top of the page
				public static void scrollToTop(WebDriver driver) {
					JavascriptExecutor js = (JavascriptExecutor) driver;      
					js.executeScript("window.scrollTo(0, 0);");
				}
				
				// scroll to the right of the page
				public static void scrollToRight(WebDriver driver) {
					JavascriptExecutor js = (JavascriptExecutor) driver;      
					js.executeScript("window.scrollTo(document.body.scrollWidth, 0);");
				}
				
				public static void zoomOutAndScrollRightInWindow(WebDriver driver) {
				    JavascriptExecutor js = (JavascriptExecutor) driver;

				    // Zoom out to 70%
				    js.executeScript("document.body.style.zoom='70%'");

				    // Scroll to the far right
				    js.executeScript("window.scrollTo(document.body.scrollWidth, 0);");
				}
				
				
				
				public static void zoomOutAndScrollRightInElement(WebDriver driver, WebElement scrollableDiv) {
				    JavascriptExecutor js = (JavascriptExecutor) driver;

				    // Step 1: Find the container — adjust selector as needed (e.g., by class name or ID)
//				    WebElement scrollableDiv = driver.findElement(By.className("panel-body"));

				    // Step 2: Zoom out the container (optional)
				    js.executeScript("arguments[0].style.zoom='75%'", scrollableDiv);

				    // Step 3: Scroll to the right inside the container
				    js.executeScript("arguments[0].scrollLeft = arguments[0].scrollWidth;", scrollableDiv);
				}


}
