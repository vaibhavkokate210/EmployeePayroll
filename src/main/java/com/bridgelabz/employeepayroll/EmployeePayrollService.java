package com.bridgelabz.employeepayroll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService 
{
    public enum IOService 
    {
    	CONSOLE_IO, FILE_IO, DB_IO, REST_IO
    }
    private static List<EmployeePayrollData> employeePayrollList;
    public EmployeePayrollService() {}

    public EmployeePayrollService (List<EmployeePayrollData> employeePayrollList) {
    	this.employeePayrollList=employeePayrollList;
    }

    public static void main(String[] args) 
    {
        employeePayrollList = new ArrayList<>();

        EmployeePayrollService employeePayrollService = new EmployeePayrollService (employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService. readEmployeePayrollData(consoleInputReader);
        employeePayrollService.writeEmployeePayrollData(IOService.CONSOLE_IO);
    }

    private void readEmployeePayrollData(Scanner consoleInputReader) 
    {
        System.out.println("Enter Employee ID: ");
        int id= consoleInputReader.nextInt();

        System.out.println("Enter Employee Name: ");
        String name = consoleInputReader.next();

        System.out.println("Enter Employee Salary: ");
        double salary = consoleInputReader.nextDouble();

        employeePayrollList.add(new EmployeePayrollData(id, name, salary));
    }

    public void writeEmployeePayrollData(IOService ioService) 
    {
    	if (ioService.equals(IOService.CONSOLE_IO))
    		System.out.println("\nwriting Employee Payroll Roaster to Console\n" + employeePayrollList);
    	else if (ioService.equals(IOService.FILE_IO)) 
    	{
    		new EmployeePayrollIOService().writeData(employeePayrollList);
    	}
    }
    
    public void printData(IOService fileIo) {
		if(fileIo.equals(IOService.FILE_IO)) new EmployeePayrollIOService().printData();
	}


	public long countEntries(IOService fileIo) {
		if(fileIo.equals(IOService.FILE_IO)) return new EmployeePayrollIOService().countEntries();
		
		return 0;
	}
}
