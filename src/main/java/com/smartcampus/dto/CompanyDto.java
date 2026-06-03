package com.smartcampus.dto;

public class CompanyDto {

	private String name;
	private float cgpacriteria;
	private String branchcriteria;
	private int backlogcriteria;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCgpacriteria() {
		return cgpacriteria;
	}

	public void setCgpacriteria(float cgpacriteria) {
		this.cgpacriteria = cgpacriteria;
	}

	public String getBranchcriteria() {
		return branchcriteria;
	}

	public void setBranchcriteria(String branchcriteria) {
		this.branchcriteria = branchcriteria;
	}

	public int getBacklogcriteria() {
		return backlogcriteria;
	}

	public void setBacklogcriteria(int backlogcriteria) {
		this.backlogcriteria = backlogcriteria;
	}

}
