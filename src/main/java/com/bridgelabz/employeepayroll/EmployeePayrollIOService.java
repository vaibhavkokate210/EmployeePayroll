package com.bridgelabz.employeepayroll;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollIOService 
{
       public static String PAYROLL_FILE_NAME="payroll-file.txt";
	
	   public void writeData(List<EmployeePayrollData> employeePayrollList)
	   {
		      StringBuffer empBuffer = new StringBuffer();
		      employeePayrollList.forEach(n->{
			       String employeeDataString = employeePayrollList.toString().concat("\n");
			     empBuffer.append(employeeDataString);
		});
		
		try
		{
			Files.write(Paths.get(PAYROLL_FILE_NAME),empBuffer.toString().getBytes());
			
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
