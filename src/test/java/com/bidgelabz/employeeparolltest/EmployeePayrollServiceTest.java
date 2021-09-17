package com.bidgelabz.employeeparolltest;

import java.util.Arrays;

import org.junit.Test;

import com.bridgelabz.employeepayroll.EmployeePayrollData;
import com.bridgelabz.employeepayroll.EmployeePayrollService;
import com.bridgelabz.employeepayroll.EmployeePayrollService.IOService;

public class EmployeePayrollServiceTest 
{
	@Test
	public void given3Employees_WhenWrittenToFile_ShouldMatchEntries()
	{
		EmployeePayrollData[] arrayOfEmps = {
				new EmployeePayrollData(1, "Vaibhav", 20000.0),
				new EmployeePayrollData(2, "Ajay", 50000.0),
				new EmployeePayrollData(3, "Mayur", 30000.0)
		};
		EmployeePayrollService employeePayrollService;
		employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(IOService.FILE_IO);
		
	}
}
