package com.org.techno.soft.pf;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PFCalculationTest {

	@Test
	void testMain() {
		PFCalculation pf = new PFCalculation();
		pf.setCompanyContri(100L);
		pf.setEmployeeContri(100l);
		pf.setUIN("123456789123");
		pf.setBasicSal(200);
		pf.calculatePF(pf.getBasicSal());
	}

	
	@Test
	void testValidateUIN_Valid() {
		PFCalculation pf = new PFCalculation();
		String UIN = "124556789123";
		boolean result = pf.validateUIN(UIN);
		assertTrue(result);
	}
	
	@Test
	void testValidateUIN_NotValid() {
		PFCalculation pf = new PFCalculation();
		String UIN = "124545555555";
		boolean result = pf.validateUIN(UIN);
		assert(result);
	}


	@Test
	void testCalculateTotalPF() {

		PFCalculation pf = new PFCalculation();
		pf.setCompanyContri(100L);
		pf.setEmployeeContri(100l);
		pf.setUIN("12345");
		pf.setBasicSal(200);
		pf.calculateTotalPF(pf.getEmployeeContri(), pf.getCompanyContri());
		assertNotNull("Total PF is ", pf.getTotalPf());
	}
  
	
	
	@Test
	void testDisplayDetails() {
		PFCalculation pf = new PFCalculation();
		pf.setCompanyContri(100L);
		pf.setEmployeeContri(100l);
		pf.setUIN("12345");
		pf.setBasicSal(200);
		pf.setTotalPf(300);
		pf.displayDetails(pf.getTotalPf());
	}

	@Test
	void testCalculateCompanyPF() {
		PFCalculation pf = new PFCalculation();
		long employeePF = 200;
		long compPf = pf.calculateCompanyPF(employeePF);
		assertEquals(employeePF, compPf);
	}
	@Test
	void testCalculateCompanyPF_ForZero() {
		PFCalculation pf = new PFCalculation();
		long employeePF = 0;
		long compPf = pf.calculateCompanyPF(employeePF);
		assertEquals(employeePF, compPf);
	}

	
	
	
	@Test
	void testCalculateEmployeePF() {
		PFCalculation pf = new PFCalculation();
		long employeePF=303;
		long checkpf= pf.calculateEmployeePF(2525);
		assertEquals(employeePF, checkpf);
	}
	
	@Test
	void testCalculateEmployeePF_forZero() {
		PFCalculation pf = new PFCalculation();
		long employeePF=0;
		long checkpf= pf.calculateEmployeePF(0);
		assertEquals(employeePF, checkpf);
	}
}
