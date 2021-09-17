package com.bidgelabz.employeeparolltest;

import java.util.Arrays;

import org.junit.Assert;
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
		employeePayrollService.printData(IOService.FILE_IO);
		long entries = employeePayrollService.countEntries(IOService.FILE_IO);
		Assert.assertEquals(3, entries);
		
	}
	
	@Test
	public void givenEmployees_WhenReadFromFile_ShouldReturnExactSize() {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		long entrie = employeePayrollService.readData(IOService.FILE_IO);
		Assert.assertEquals(3,entrie);
	}
}
