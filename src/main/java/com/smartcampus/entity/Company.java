package com.smartcampus.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private float cgpacriteria;
	@Column
	private String branchcriteria;
	@Column
	private int backlogcriteria;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", cgpacriteria=" + cgpacriteria + ", branchcriteria="
				+ branchcriteria + ", backlogcriteria=" + backlogcriteria + "]";
	}

}
