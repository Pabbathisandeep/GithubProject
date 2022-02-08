package DriverFactory;

import org.testng.annotations.Test;

import CommonFunctions.FunctionsLibrary;
import Constant.PBConstant;

import Utilities.ExcelFileutil1;

public class DriverScript extends PBConstant{
	String inputpath = "C:\\Users\\HP\\Automation_selenium\\Automation_Frameworks\\TestInput\\hybridTestnew.xlsx";
	String outputpath="C:\\Users\\HP\\Automation_selenium\\Automation_Frameworks\\Testoutput\\HybridTest1Results.xlsx";
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
				//read TCid cell from sheet
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
						if(keyword.equalsIgnoreCase("AdminLogin"))
						{
							String username= xl.getCellData(TSSheet, j, 5);
							String password = xl.getCellData(TSSheet, j,6);
							res=FunctionsLibrary.verifyLogin(username, password);
						}
						else if(keyword.equalsIgnoreCase("NewBranchCreation"))
						{
							String bname = xl.getCellData(TSSheet, j, 5);
							String address1 = xl.getCellData(TSSheet, j, 6);
							String address2 = xl.getCellData(TSSheet, j, 7);
							String address3 = xl.getCellData(TSSheet, j, 8);
							String area = xl.getCellData(TSSheet, j, 9);
							String zip = xl.getCellData(TSSheet, j, 10);
							String country = xl.getCellData(TSSheet, j, 11);
							String state = xl.getCellData(TSSheet, j, 12);
							String city = xl.getCellData(TSSheet, j, 13);
							FunctionsLibrary.clickBranches();
							res = FunctionsLibrary.verifyNewBranchCreation(bname, address1, address2, address3, area, zip, country, state, city);

						}
						else if(keyword.equalsIgnoreCase("UpdateBranch"))
						{
							String branchname = xl.getCellData(TSSheet, j, 5);
							String address = xl.getCellData(TSSheet, j, 6);
							String zipcode = xl.getCellData(TSSheet, j, 10);
							FunctionsLibrary.clickBranches();
							res = FunctionsLibrary.verifyBranchUpdates(branchname, address, zipcode);
						}
						else if(keyword.equalsIgnoreCase("NewRoleCreation"))
						{
							String rolename = xl.getCellData(TSSheet, j, 5);
							String roledes = xl.getCellData(TSSheet, j, 6);
							String roletype = xl.getCellData(TSSheet, j, 7);
							FunctionsLibrary.clickRoles();
							res = FunctionsLibrary.verifyRoleCreation(rolename, roledes, roletype);
						}
						else if(keyword.equalsIgnoreCase("AdminLogout"))
						{
							res = FunctionsLibrary.verifyLogOut();

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
		}
	}
}
