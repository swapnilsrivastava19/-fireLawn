package com.Ecommerce.FireLawn.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mysql.jdbc.Driver;

/**
 * 
 * @author Swapnil
 *
 */
public class FileUtilities {
	
	public static Connection con;
	/**
	 * It is used to read the data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	public String getPropertydata(String key) throws IOException {

		Properties p=new Properties();
		FileInputStream fis=new FileInputStream(AutoConstant.propertyFilePath);
		p.load(fis);
		return p.getProperty(key);

	}
	/**
	 * It is used to read the data from excel sheet
	 * @param Sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String getExcelData(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		String s="";
		FileInputStream fis=new FileInputStream(AutoConstant.execelPath);
		Workbook wb = WorkbookFactory.create(fis);
		s = wb.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		return s;
	}
	/**
	 * It is used to read data from database
	 * @return
	 * @throws SQLException
	 */
	public static Connection getDataDb() throws SQLException {
		Driver dref=new Driver();
		DriverManager.registerDriver(dref);
		return con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cards", "root", "root");
		
	}
	/**
	 * It is used to execute the query
	 * @param query
	 * @param columnName
	 * @param ExpectedResults
	 * @return
	 * @throws SQLException
	 */
	public String queryExecution(String query, int columnName, String ExpectedResults) throws SQLException {
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
			if(result.getString(columnName).equals(ExpectedResults)) {
				break;
			}
			else {
				System.out.println("Data not found");
			}
		}
		return ExpectedResults;
	}
	/**
	 * It is used to close the connection
	 * @throws SQLException
	 */
	
	public static void closedb() throws SQLException {
		con.close();
	}
	

}
