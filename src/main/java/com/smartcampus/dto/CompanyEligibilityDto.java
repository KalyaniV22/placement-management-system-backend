package com.smartcampus.dto;

public class CompanyEligibilityDto {

    private String companyName;
    private int totalEligibleStudents;

    private int ceStudents;
    private int etcStudents;
    private int mechStudents;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public int getTotalEligibleStudents() {
		return totalEligibleStudents;
	}
	public void setTotalEligibleStudents(int totalEligibleStudents) {
		this.totalEligibleStudents = totalEligibleStudents;
	}
	public int getCeStudents() {
		return ceStudents;
	}
	public void setCeStudents(int ceStudents) {
		this.ceStudents = ceStudents;
	}
	public int getEtcStudents() {
		return etcStudents;
	}
	public void setEtcStudents(int etcStudents) {
		this.etcStudents = etcStudents;
	}
	public int getMechStudents() {
		return mechStudents;
	}
	public void setMechStudents(int mechStudents) {
		this.mechStudents = mechStudents;
	}
    
    
    
}