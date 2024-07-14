package com.example.Assignment3;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Employee {
	private String firstName;
    private String lastName;
    private int employeeID;
    private String designation;
    @SerializedName("knownLanguages")
    private List<Language> knownLanguages;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public List<Language> getKnownLanguages() {
		return knownLanguages;
	}
	public void setKnownLanguages(List<Language> knownLanguages) {
		this.knownLanguages = knownLanguages;
	}
    
    

}
