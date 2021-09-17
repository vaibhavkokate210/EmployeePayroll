package com.bridgelabz.employeepayroll;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
	   
	   public void printData() {
			try {
				Files.lines(new File(PAYROLL_FILE_NAME).toPath()).forEach(System.out::println);
			}catch(IOException e) {e.printStackTrace();}
			
		}

		public long countEntries() {
			long entries=0;
			try {
				entries = Files.lines(new File(PAYROLL_FILE_NAME).toPath()).count();
			}catch(IOException e) {e.printStackTrace();};
			return entries;
		}
		
		public List<EmployeePayrollData> readData() {
			List<EmployeePayrollData> employeePayrollList = new ArrayList<>();
			try {
				Files.lines(new File(PAYROLL_FILE_NAME).toPath()).map(line->line.split(",")).forEach(n->{
					Integer id=0;String name=""; Double salary=0.0;
					for (int i = 0; i < n.length; i++) {
						if (i==0) {
							id = n[i].charAt(3)-'0';
						}
						else if (i == 1) {
							name = n[i].substring(7, n[i].length()-1);
						}
						else if (i == 2 ) {
							salary = Double.parseDouble(n[i].substring(8, n[i].length()));
						}
					}
					employeePayrollList.add(new EmployeePayrollData(id, name, salary));
				});;
				
			}catch(IOException e) {e.printStackTrace();}
			return employeePayrollList;
		}
}
