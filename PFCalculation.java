package com.org.techno.soft.pf;

import java.util.Scanner;

public class PFCalculation {

	final static int PF_RATE = 12;
	
	private long companyContri;
	private long EmployeeContri;
	private long totalPf;
	private static String UIN;
	private static int basicSal;
	
	public static void main(String[] args) {

		System.out.println("Welcome to PF calculation Screen");
		System.out.println("Please enter your UIN number");
		Scanner sc = new Scanner(System.in);
		UIN = sc.next();
		System.out.println("Please Enter your basic Salary");
		sc = new Scanner(System.in);
		basicSal = sc.nextInt();
		sc.close();
		
		PFCalculation pfCal = new PFCalculation();
		if(pfCal.validateUIN(UIN)) {
			pfCal.calculatePF(basicSal);
		}else {
			System.out.println("As UIN not valid Existing from system.");
		}
	}

	boolean validateUIN(String UIN_NUMBER) {
		int uinLen = UIN_NUMBER.length(); 
		if(uinLen == 12) {
			System.out.println("UIN  Validated");
			return true;
		}else {
			System.out.println("UIN is nOt valid. Please Enter valid 12 digit UIN.");
			return false;
		}
	}

	void calculatePF(int basicSal) {
		System.out.println("calculating PF contribution from Employee on PF Rate " + PF_RATE);
		long employeeConty = calculateEmployeePF(basicSal);
		long companyPF = calculateCompanyPF(employeeConty);
		calculateTotalPF(employeeConty,companyPF);
	}

	void calculateTotalPF(long employeeConty, long companyPF) {
		long totalPF = employeeConty + companyPF;
		System.out.println("Total PF is " + totalPF);
		displayDetails(totalPF);
	}
	
	void displayDetails(long totalPF) {
		StringBuffer sb = new StringBuffer();
		
		sb.append("************************************* PF Details *********************************************");
		sb.append("\n");
		sb.append(String.format("%2s", "UIN Number "));
		sb.append(String.format("%20s", "Basic Salary "));
		sb.append(String.format("%25s", "Employee Contribution "));
		sb.append(String.format("%25s", "Company Contribution "));
		sb.append(String.format("%10s", "Total PF "));
		sb.append("\n");
		sb.append("------------------------------------- ----------------------------------------------------------");
		sb.append("\n");
		sb.append(String.format("%2s", UIN));
		sb.append(String.format("%20s", basicSal));
		sb.append(String.format("%25s", EmployeeContri));
		sb.append(String.format("%25s", companyContri));
		sb.append(String.format("%10s", totalPF));
		sb.append("\n");
		sb.append("------------------------------------------------------------------------------------------------");
		System.out.println(sb.toString());
	}

	long calculateCompanyPF(long employeePF) {
		companyContri = employeePF;
		return companyContri;
	}

	long calculateEmployeePF(int basicSal) {
		EmployeeContri = (basicSal*PF_RATE)/100;
		return EmployeeContri;
	}

	public long getCompanyContri() {
		return companyContri;
	}

	public void setCompanyContri(long companyContri) {
		this.companyContri = companyContri;
	}

	public long getEmployeeContri() {
		return EmployeeContri;
	}

	public void setEmployeeContri(long employeeContri) {
		EmployeeContri = employeeContri;
	}

	public long getTotalPf() {
		return totalPf;
	}

	public void setTotalPf(long totalPf) {
		this.totalPf = totalPf;
	}

	public static String getUIN() {
		return UIN;
	}

	public static void setUIN(String uIN) {
		UIN = uIN;
	}

	public static int getBasicSal() {
		return basicSal;
	}

	public static void setBasicSal(int basicSal) {
		PFCalculation.basicSal = basicSal;
	}

	public static int getPfRate() {
		return PF_RATE;
	}
}
