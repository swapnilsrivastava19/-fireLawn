package scripts;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.Ecommerce.FireLawn.genericLib.BaseClass;

import pomPages.Address;
import pomPages.Cart;
import pomPages.Home;
import pomPages.Login;
import pomPages.Payment;
import pomPages.Product;
import pomPages.Welcome;

/**
 * 
 * @author asus
 *
 */
public class Testcase1 extends BaseClass{
	
	@Test
	public void demo() throws IOException, InterruptedException, SQLException {
		Welcome w=new Welcome(driver);
		Login l = w.loginButton();
		Home us = l.logindetails(fu.getPropertydata("username"), fu.getPropertydata("password"));
		Thread.sleep(15000);
		Product s = us.searchelement(fu.getExcelData("Sheet1", 1, 0));
		Thread.sleep(15000);
		Cart c = s.addtocartbtn();
		Address b = c.buynow();
		b.addaddress("annknf", "bjadbjad", "nkadnjand", "bdhBDI");
		webutilities.dropdown(b.getCountrydd(), fu.getPropertydata("country"));
		webutilities.dropdown(b.getStatedd(), fu.getPropertydata("state"));
		webutilities.dropdown(b.getCitydd(), fu.getPropertydata("city"));
		b.code(fu.getPropertydata("code"), fu.getPropertydata("phnum"));
		Payment ad = b.addresssradiobtn();
		ad.carddetails(fu.queryExecution("select * from carddetails", 1, "swapnil"), 
				fu.queryExecution("select * from carddetails", 2, "5014401191606541"),
				fu.queryExecution("select * from carddetails", 3, "8810"),
				fu.queryExecution("select * from carddetails", 4, "12"),
				fu.queryExecution("select * from carddetails", 5, "27"),
				fu.queryExecution("select * from carddetails", 6, "402"));
		
		
	}

}
