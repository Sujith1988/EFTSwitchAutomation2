package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.TestBase;
import dataprovider.ArrayDataProvider;
import dataprovider.ExcelDataProvider;
import pages.B_Home;
import pages.A_Login;
import pages.D_RoutingCatagory;
import utils.adminLoginCommon;
import utils.popupWindwHandlr;

public class D_RCTest extends TestBase{
	
	/*------Login as Admin user(credential from locator.props)--------*/
    @Test(priority = 1)
    public static void adminlogin() throws IOException, InterruptedException {
    	A_Login log = new A_Login();	
    	adminLoginCommon.adminLogin(log.admnUser, log.admnPass, log);
    }
    
    
    
    /*--------Deleting the fields from the RC. from View-RC. Page and adding new fields using Add-RC page--------*/
	@Test(dataProvider = "RCData", dataProviderClass = ExcelDataProvider.class, priority = 2, groups = "reggrsn1")
	public static void editRC(String paramName, String tr, String td, String tdEditbtn) throws IOException, InterruptedException {					
		// POM -- home page (class object-instance created and constructor invoked)
				B_Home h = new B_Home();
		// POM -- Routing Catagory page (class object-instance created and constructor invoked)
				D_RoutingCatagory rc = new D_RoutingCatagory();
	    // POM -- Login page (class object-instance created and constructor invoked)
		        A_Login log = new A_Login();
		       
		// View Sys. Conf:-  Edit/Delete configurations testing
		h.clickHome();
		h.clickonRoutingCatagory();	    Thread.sleep(log.slp_2);			
		h.clickonViewRoutingCatagory();     Thread.sleep(log.slp_2);	
		String pagHeadr = rc.pageHeader_viewRC();
		String actualPageHeader = rc.actPagHeader_viewRC();
		if (pagHeadr.equals(actualPageHeader)) {
			
			//Edit
			rc.clickonViewRCEditbtn(paramName,tr,td,tdEditbtn);
			rc.clickonRCUpdatebtn();              Thread.sleep(log.slp_2);			
			popupWindwHandlr.alertHandler();     Thread.sleep(log.slp_2);
			
			//Delete
			rc.clickonViewRCEditbtn(paramName,tr,td,tdEditbtn);Thread.sleep(log.slp_2);	
			rc.clickonRCDeletebtn();              Thread.sleep(log.slp_2);			
			popupWindwHandlr.alertHandler();     Thread.sleep(log.slp_2);
			
		}
		else {  System.out.println("error in loading View Sys Conf page");   }
				
	}
	
	
	
	// Add
	@Test(priority = 3, dataProvider = "RCData1", dataProviderClass = ArrayDataProvider.class)
	public static void addRC(String rcName, String spare) throws IOException, InterruptedException {
		B_Home h               = new B_Home();
		D_RoutingCatagory rc = new D_RoutingCatagory();
		A_Login log            = new A_Login();
		
		h.clickHome();
		h.clickonRoutingCatagory();	    Thread.sleep(log.slp_2);			
		h.clickonAddRoutingCatagory();     Thread.sleep(log.slp_2);
		rc.routingCatagory(rcName);
		rc.clickonroutingCatagorySavebtn();
		
	}

}
