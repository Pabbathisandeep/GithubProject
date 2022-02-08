package DriverFactory;

import org.testng.annotations.Test;

import CommonFunctions.FunctionLibraryOpencart;

import Constant.PBConstant;
import Utilities.ExcelFileutil1;

public class DriverScriptOpencart extends PBConstant
{
	String inputpath = "C:\\Users\\HP\\Automation_selenium\\Automation_Frameworks\\TestInput\\Opencart.xlsx";
	String outputpath = "C:\\Users\\HP\\Automation_selenium\\Automation_Frameworks\\TestOutput\\OpencartResults.xlsx";
	String TCSheet = "TestCases";
	String TSSheet = "TestSteps";
	@Test
	public void startTest() throws Throwable
	{
		boolean res = false;
		String tcres="";
		//create reference object
		ExcelFileutil1 xl = new ExcelFileutil1(inputpath);
		//count no of rows in TSSheet TCSheet
		int TCCount = xl.rowCount(TCSheet);
		int TSCount = xl.rowCount(TSSheet);
		//iterate all rows in TCSheet
		for(int i=1;i<=TCCount;i++)
		{
			//store all module name into TCModule
			String TCModule = xl.getCellData(TCSheet, i, 1);
			//read execution mode cell
			String executionmode = xl.getCellData(TCSheet, i, 2);
			if(executionmode.equalsIgnoreCase("Y"))
			{
				String TCid = xl.getCellData(TCSheet, i, 0);
				//iterate all rows in TSSheet
				for(int j=1;j<=TSCount;j++)	
				{
					//read TCid from TSSheet
					String TSid =xl.getCellData(TSSheet, j,	 0);
					if(TCid.equalsIgnoreCase(TSid))
					{	
						//read keyword from TSSheet
						String keyword = xl.getCellData(TSSheet, j, 4);
						if(keyword.equalsIgnoreCase("Register"))
						{
						 String Fname = xl.getCellData(TSSheet, j, 5);
						 String Lname = xl.getCellData(TSSheet, j, 6);
						 String Email = xl.getCellData(TSSheet, j, 7);
						 String telephone = xl.getCellData(TSSheet, j, 8);
						 String passwrd = xl.getCellData(TSSheet, j, 9);
						 String passconfirm = xl.getCellData(TSSheet, j, 10);
						 FunctionLibraryOpencart.clickMyAccount();
						 res = FunctionLibraryOpencart.VerifyRegister(Fname, Lname, Email, telephone, passwrd, passconfirm);
						 }
						else if(keyword.equalsIgnoreCase("Logout"))
						{
							res = FunctionLibraryOpencart.verifyLogout();
						}
						
						//res id holding true or false
						String tsres = "";
						if(res)
						{
							//write as pass into status cell in TSSheet
							tsres = "PASS";
							xl.setCellData(TSSheet, j, 3, tsres, outputpath);
						}
						else
						{
							tsres = "FAIL";
							xl.setCellData(TSSheet, j, 3, tsres, outputpath);
						}
						tcres = tsres;
					}
				}
				//write tcres into TCCSheet
				xl.setCellData(TCSheet, i, 3, tcres, outputpath);
			}
			else
			{
				//write as blocked into TCSheet under status
				xl.setCellData(TCSheet, i, 3, "BLOCKED", outputpath);
			}
						 
			}}}
				
				
				
				
				
				
				
				
				
				
				

